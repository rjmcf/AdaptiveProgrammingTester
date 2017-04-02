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
import miniJAST.statements.BlockStatement;
import miniJAST.statements.FillableBlankStmnt;
import miniJAST.statements.StatementBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Stack;

public abstract class AbstractPExercise implements Comparable<AbstractPExercise> {
    protected String question;
    protected BlockStatement solution;
    private int baseDifficulty;
    private boolean replaceMarked = false;
    private Stack<MiniJASTNode> replacedNodes = new Stack<>();
    private Stack<Stack<Integer>> replacedNodeTreeIndices = new Stack<>();
    public abstract void setUp();
    public abstract boolean checkSolved();
    protected Context c;

    protected void baseSetUp() {
        replaceMarked = false;
        replacedNodes = new Stack<>();
        replacedNodeTreeIndices = new Stack<>();
    }

    public void runSolution() throws MiniJASTException {
        c = new Context();
        solution.executeStart(c);
    }

    @Override
    public int compareTo(AbstractPExercise o) {
        return (baseDifficulty - o.baseDifficulty);
    }

    public AbstractPExercise(String q, int diff) { question = q; baseDifficulty = diff; }

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

    public String printSolution() {
        return solution.stringRepr(1);
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
                            ((FillableBlankStmnt) nodes.peek()).setStudentStmnt((BlockStatement) replacement);
                        } else {
                            throw new ClassCastException("node is neither Expression not Statement!");
                        }
                        return true;
                    } catch (ClassCastException e) {
                        throw new TypeException("Incorrect type submitted for blank");
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
        Stack<Boolean> childrenBlank = new Stack<>();
        nodes.add(solution);

        while (true) {
            while (!nodes.empty()) {
                if (!parents.empty() && nodes.peek() == parents.peek()) {
                    // mark if children leaves
                    if (childrenBlank.peek()) {
                        nodes.peek().setMarked(!replaceMarked);
                        nodes.peek().setIsLeaf(true);
                    }
                    // pop node increase index
                    nodes.pop();
                    parents.pop();
                    index.pop();
                    if (!index.empty()) {
                        int i = index.pop();
                        index.push(i+1);
                    }
                    childrenBlank.pop();
                    continue;
                }
                if (nodes.peek().getIsLeaf()) {
                    if (nodes.peek().getIsMarked() == replaceMarked) {
                        NodeCount replacedNodes;
                        // if parents is empty, replace solution
                        if (parents.empty()) {
                            // Store the replaced node and its location so it can be reinserted
                            this.replacedNodes.push(solution);
                            replacedNodeTreeIndices.push(index);

                            replacedNodes = solution.getTreeSize();
                            solution = new FillableBlankStmnt(replacedNodes.empty + replacedNodes.filled);
                            return true;
                        }
                        // replace parent.peek().getSubNodes.get(index.peek())

                        // Store the replaced node and its location so it can be reinserted
                        this.replacedNodes.push(nodes.peek());
                        replacedNodeTreeIndices.push(index);

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
                        return true;
                    } else {
                        // pop node, increase index, record that a child is not blank
                        nodes.pop();
                        int i = index.pop();
                        index.push(i + 1);
                        childrenBlank.pop();
                        childrenBlank.push(false);
                        continue;
                    }
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
                // update current childrenBlank to false if exists
                if (!childrenBlank.empty()) {
                    childrenBlank.pop();
                    childrenBlank.push(false);
                }
                // push true onto childrenLeaves
                childrenBlank.push(true);
                // push children onto nodes
                ArrayList<? extends MiniJASTNode> children = nodes.peek().getSubNodes();
                ListIterator<? extends MiniJASTNode> it = children.listIterator(children.size());
                while (it.hasPrevious())
                    nodes.push(it.previous());
            }
            // invert which marking is being searched for
            replaceMarked ^= true;
            nodes.add(solution);
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
            solution = (BlockStatement)replacedNodes.pop();
            replacedNodeTreeIndices.pop();
            return true;
        }

        MiniJASTNode toReplace = replacedNodes.pop();
        MiniJASTNode parent = solution;
        boolean alwaysLast = true;
        Stack<Integer> indicesRev = replacedNodeTreeIndices.pop();
        Stack<Integer> indices = new Stack<>();
        while (!indicesRev.empty()) {
            indices.push(indicesRev.pop());
        }
        while (indices.size() > 1) {
            // check if it was the last index in the parent's subnodes.
            if (indices.peek() < parent.getSubNodes().size() - 1)
                alwaysLast = false;
            // Make sure the parent is not a leaf
            parent.setIsLeaf(false);
            parent = parent.getSubNodes().get(indices.pop());
        }

        // Make sure parent is not a leaf
        parent.setIsLeaf(false);
        ((ArrayList<MiniJASTNode>)parent.getSubNodes()).set(indices.pop(), toReplace);
        if (alwaysLast) {
            // invert since it was just inverted by last addBlank
            replaceMarked ^= true;
        }
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
