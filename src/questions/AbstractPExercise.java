package questions;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.statements.Statement;
import miniJAST.statements.FillableBlankStmnt;
import miniJAST.statements.StatementBase;
import parser.JavaToMiniJava;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractPExercise implements Comparable<AbstractPExercise> {
    protected String question;
    protected String solutionCode;
    private Statement solution;
    private int baseDifficulty;
    private Stack<MiniJASTNode> replacedNodes = new Stack<>();
    private Stack<Stack<Integer>> replacedNodeTreeIndices = new Stack<>();
    private Stack<Integer> lastNodeReplaced = new Stack<>();
    public abstract boolean checkSolved();
    protected Context c;

    public void setUp() {
        replacedNodes = new Stack<>();
        replacedNodeTreeIndices = new Stack<>();
        lastNodeReplaced = new Stack<>();
        solution = (Statement)JavaToMiniJava.makeAST(solutionCode);
    }

    public void runSolution() throws MiniJASTException {
        c = new Context();
        solution.execute(c);
    }

    public void setSolution(Statement s) {
        solution = s;
    }

    @Override
    public int compareTo(AbstractPExercise o) {
        return (baseDifficulty - o.baseDifficulty);
    }

    public AbstractPExercise(String q, String c, int diff) { question = q; solutionCode = c; baseDifficulty = diff; }

    public int getBaseDifficulty() { return baseDifficulty; }
    public int getNodesBlank() {
        NodeCount count = solution.getTreeSize();
        return count.empty;
    }

    public float getQuestionDifficulty() {
        NodeCount count = solution.getTreeSize();
        float percentageEmpty = (float)count.empty / (count.filled + count.empty);
        return baseDifficulty + percentageEmpty;
    }

    public int numNodes() {
        NodeCount size = solution.getTreeSize();
        return size.filled + size.empty;
    }

    public float getQuestionDiffModifier() {
        NodeCount count = solution.getTreeSize();
        return ((float)count.empty) / (count.filled + count.empty);
    }

    public String deliverQuestion() {
        String result = "\n";
        result += question;
        result += "\n";
        result += printSolution();
        return result;
    }

    public String getQuestion() { return question; }

    public String printSolution() {
        return solution.stringRepr(1);
    }

    public boolean blankIsExpression(int bId) throws MiniJASTException{
        Stack<MiniJASTNode> nodes = new Stack<>();
        nodes.push(solution);
        while (!nodes.empty()) {
            if (nodes.peek() instanceof FillableBlank) {
                if (((FillableBlank) nodes.peek()).getId() == bId) {
                    if (nodes.peek() instanceof FillableBlankExpr) return true;
                    else return false;
                } else {
                    nodes.pop();
                }
            } else {
                ArrayList<? extends MiniJASTNode> children = nodes.pop().getSubNodes();
                ListIterator<? extends MiniJASTNode> it = children.listIterator(children.size());
                while (it.hasPrevious())
                    nodes.push(it.previous());
            }
        }
        throw new MiniJASTException("Blank Id not found");
    }

    public boolean fillBlank(int bId, MiniJASTNode replacement) throws MiniJASTException{
        Stack<MiniJASTNode> nodes = new Stack<>();
        nodes.push(solution);
        while (!nodes.empty()) {
            if (nodes.peek() instanceof FillableBlank) {
                if (((FillableBlank) nodes.peek()).getId() == bId) {
                    try {
                        if (nodes.peek() instanceof FillableBlankExpr) {
                            ((FillableBlankExpr) nodes.peek()).setStudentExpr((Expression) replacement);
                        } else if (nodes.peek() instanceof FillableBlankStmnt) {
                            ((FillableBlankStmnt) nodes.peek()).setStudentStmnt((Statement) replacement);
                        } else {
                            throw new TypeException("node is neither Expression not Statement!");
                        }
                        return true;
                    } catch (ClassCastException e) {
                        Pattern p = Pattern.compile(".*\\.(.*) cannot be cast to .*\\.(.*)");
                        Matcher m = p.matcher(e.getMessage());
                        String text = "Incorrect type submitted for blank";
                        if (m.matches()) {
                            String from = m.group(1);
                            String to = m.group(2);
                            text += ": cannot cast from " + from + " to " + to +".";
                        }
                        throw new TypeException(text);
                    }
                } else {
                    nodes.pop();
                }
            } else {
                ArrayList<? extends MiniJASTNode> children = nodes.pop().getSubNodes();
                ListIterator<? extends MiniJASTNode> it = children.listIterator(children.size());
                while (it.hasPrevious())
                    nodes.push(it.previous());
            }
        }
        return false;
    }

    public boolean emptyBlank(int bId) {
        Stack<MiniJASTNode> nodes = new Stack<>();
        nodes.push(solution);
        while (!nodes.empty()) {
            if (nodes.peek() instanceof FillableBlank) {
                if (((FillableBlank) nodes.peek()).getId() == bId) {
                    ((FillableBlank) nodes.peek()).empty();
                    return true;
                } else {
                    nodes.pop();
                }
            } else {
                ArrayList<? extends MiniJASTNode> children = nodes.pop().getSubNodes();
                ListIterator<? extends MiniJASTNode> it = children.listIterator(children.size());
                while (it.hasPrevious())
                    nodes.push(it.previous());
            }
        }
        return false;
    }

    public ArrayList<Integer> getBlankIds() {
        ArrayList<Integer> blankIds = new ArrayList<>();
        Stack<MiniJASTNode> nodes = new Stack<>();
        nodes.push(solution);
        while (!nodes.empty()) {
            if (nodes.peek() instanceof FillableBlank) {
                blankIds.add(((FillableBlank)nodes.pop()).getId());
                continue;
            }
            for (MiniJASTNode n : nodes.pop().getSubNodes()) {
                nodes.push(n);
            }
        }
        Collections.reverse(blankIds);
        return blankIds;
    }

    public boolean addBlank() {
        Stack<MiniJASTNode> nodes = new Stack<>();
        Stack<MiniJASTNode> parents = new Stack<>();
        Stack<Integer> index = new Stack<>();
        Collections.reverse(lastNodeReplaced);
        boolean needToPop = false;
        nodes.push(solution);

        while(!lastNodeReplaced.empty()) {
            needToPop = true;
            parents.push(nodes.peek());
            int i = lastNodeReplaced.pop();
            index.push(i);
            ArrayList<MiniJASTNode> allChildren = new ArrayList<>();
            for (MiniJASTNode n : nodes.peek().getSubNodes()) {
                allChildren.add(n);
            }
            List<? extends MiniJASTNode> newNodes = allChildren.subList(i, allChildren.size());
            Collections.reverse(newNodes);
            for (MiniJASTNode n : newNodes) {
                nodes.push(n);
            }
        }
        if (needToPop) {
            nodes.pop();
            int i = index.pop();
            index.push(i + 1);
        }

        while (true) {
            while (!nodes.empty()) {
                if (!parents.empty() && nodes.peek() == parents.peek()) {
                    // pop node increase index
                    nodes.pop();
                    parents.pop();
                    index.pop();
                    if (!index.empty()) {
                        int i = index.pop();
                        index.push(i + 1);
                    }
                    continue;
                }
                if (nodes.peek().getIsLeaf()) {
                    NodeCount replacedNodes;
                    // Store the replaced node and its location so it can be reinserted
                    this.replacedNodes.push(nodes.peek());
                    replacedNodeTreeIndices.push((Stack<Integer>)index.clone());

                    // if parents is empty, replace solution
                    if (parents.empty()) {

                        replacedNodes = solution.getTreeSize();
                        solution = new FillableBlankStmnt(replacedNodes.empty + replacedNodes.filled);
                        return true;
                    }
                    // Get number of nodes being replaced
                    replacedNodes = nodes.peek().getTreeSize();
                    if (nodes.peek() instanceof StatementBase) {
                        ((ArrayList<MiniJASTNode>) parents.peek().getSubNodes()).set(index.peek(),
                                new FillableBlankStmnt(replacedNodes.empty + replacedNodes.filled));
                    } else if (nodes.peek() instanceof ExpressionBase) {
                        ((ArrayList<MiniJASTNode>) parents.peek().getSubNodes()).set(index.peek(),
                                new FillableBlankExpr(replacedNodes.empty + replacedNodes.filled));
                    } else {
                        throw new ClassCastException("Node was neither Expression nor Statement!");
                    }
                    lastNodeReplaced = index;
                    return true;
                }
                if (nodes.peek() instanceof FillableBlank) {
                    // if parents is empty, solution is blank, so can't add blank
                    if (parents.empty())
                        return false;
                    // pop node, increase index
                    nodes.pop();
                    int i = index.pop();
                    index.push(i + 1);
                    continue;
                }
                // push node as parent
                parents.push(nodes.peek());
                // push 0 onto indices
                index.push(0);
                // push children onto nodes
                ArrayList<? extends MiniJASTNode> children = nodes.peek().getSubNodes();
                ListIterator<? extends MiniJASTNode> it = children.listIterator(children.size());
                while (it.hasPrevious())
                    nodes.push(it.previous());
            }
            nodes.push(solution);
        }


    }
    // TODO fix how ForInits and ExprStmnts are handled

    public int makeHarder(int numberOfTimes) {
        if (numberOfTimes < 1)
            throw new ArithmeticException("The number supplied (" + numberOfTimes + ") must be greater than 0");
        while (numberOfTimes > 0) {
            if (!addBlank())
                break;
            numberOfTimes--;
        }

        return numberOfTimes;
    }

    public boolean removeBlank() {
        if (replacedNodes.empty())
            return false;

        if (replacedNodeTreeIndices.peek().empty()) {
            solution = (Statement)replacedNodes.pop();
            replacedNodeTreeIndices.pop();
            lastNodeReplaced = (Stack<Integer>)replacedNodeTreeIndices.peek().clone();
            return true;
        }

        MiniJASTNode toReplace = replacedNodes.pop();
        MiniJASTNode parent = solution;
        Stack<Integer> indices = replacedNodeTreeIndices.pop();
        if (!replacedNodeTreeIndices.empty())
            lastNodeReplaced = (Stack<Integer>)replacedNodeTreeIndices.peek().clone();

        Collections.reverse(indices);
        while (indices.size() > 1) {
            parent = parent.getSubNodes().get(indices.pop());
        }

        ((ArrayList<MiniJASTNode>)parent.getSubNodes()).set(indices.pop(), toReplace);
        return true;
    }

    public int makeEasier(int numberOfTimes) {
        if (numberOfTimes < 1)
            throw new ArithmeticException("The number supplied (" + numberOfTimes + ") must be greater than 0");
        while (numberOfTimes > 0) {
            if (!removeBlank())
                break;
            numberOfTimes--;
        }

        return numberOfTimes;
    }
}
