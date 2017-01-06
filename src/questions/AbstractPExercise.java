package questions;

import miniJAST.FillableBlank;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.expressions.Expression;
import miniJAST.expressions.ExpressionBase;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.statements.FillableBlankStmnt;
import miniJAST.statements.Statement;
import miniJAST.statements.StatementBase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

public abstract class AbstractPExercise {
    public String question;
    protected Statement solution;
    private float baseDifficulty;
    private boolean replaceMarked = false;
    public abstract void setUp();
    public abstract void runSolution();
    public abstract boolean checkSolved();

    public AbstractPExercise(String q, float diff) { question = q; baseDifficulty = diff; }

    public float getQuestionDifficulty() {
        NodeCount count = solution.getTreeSize();
        float percentageEmpty = count.empty / (count.filled + count.empty);
        return baseDifficulty + percentageEmpty;
    }

    public void deliverQuestion() {
        System.out.println(question);
        System.out.println();
        printSolution();
    }

    public void printSolution() {
        System.out.println(solution.stringRepr(1));
    }

    public boolean addBlank() {
        Stack<MiniJASTNode> nodes = new Stack<>();
        Stack<MiniJASTNode> parents = new Stack<>();
        Stack<Integer> index = new Stack<>();
        Stack<Boolean> childrenLeaves = new Stack<>();
        nodes.add(solution);

        while (true) {
            while (!nodes.empty()) {
                if (!parents.empty() && nodes.peek() == parents.peek()) {
                    // mark if children leaves
                    if (childrenLeaves.peek()) {
                        nodes.peek().setMarked(!replaceMarked);
                        nodes.peek().setIsLeaf(true);
                    }
                    // pop otherwise
                    nodes.pop();
                    parents.pop();
                    index.pop();
                    childrenLeaves.pop();
                    continue;
                }
                if (nodes.peek().getIsLeaf()) {
                    if (nodes.peek().getIsMarked() == replaceMarked) {
                        // if parents is empty, replace solution
                        if (parents.empty()) {
                            solution = new FillableBlankStmnt();
                            return true;
                        }
                        // replace parent.peek().getSubNodes.get(index.peek())
                        if (nodes.peek() instanceof StatementBase) {
                            ((ArrayList<MiniJASTNode>) parents.peek().getSubNodes()).set(index.peek(), new FillableBlankStmnt());
                        } else if (nodes.peek() instanceof ExpressionBase) {
                            ((ArrayList<MiniJASTNode>) parents.peek().getSubNodes()).set(index.peek(), new FillableBlankExpr());
                        } else {
                            System.err.println("node was neither StatementBase nor ExpressionBase!");
                        }
                        return true;
                    } else {
                        // pop node, increase index
                        nodes.pop();
                        int i = index.pop();
                        index.push(i + 1);
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
                // update current childrenLeaves to false if exists
                if (!childrenLeaves.empty()) {
                    childrenLeaves.pop();
                    childrenLeaves.push(false);
                }
                // push true onto childrenLeaves
                childrenLeaves.push(true);
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
}
