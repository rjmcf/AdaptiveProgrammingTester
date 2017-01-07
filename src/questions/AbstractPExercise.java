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

    public float getQuestionDiffModifier() {
        NodeCount count = solution.getTreeSize();
        return ((float)count.empty) / (count.filled + count.empty);
    }

    public void deliverQuestion() {
        System.out.println();
        System.out.println(question);
        System.out.println();
        printSolution();
    }

    public void printSolution() {
        System.out.println(solution.stringRepr(1));
    }

    public boolean makeHarder(int numberOfTimes) {
        if (numberOfTimes < 1)
            return false;
        for (int i = 0; i < numberOfTimes; i++)
            if (!addBlank())
                return false;

        return true;
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
                        NodeCount replaced;
                        // if parents is empty, replace solution
                        if (parents.empty()) {
                            replaced = solution.getTreeSize();
                            solution = new FillableBlankStmnt(replaced.empty + replaced.filled);
                            return true;
                        }
                        // replace parent.peek().getSubNodes.get(index.peek())
                        // TODO count nodes being replaced!
                        replaced = nodes.peek().getTreeSize();
                        if (nodes.peek() instanceof StatementBase) {
                            ((ArrayList<MiniJASTNode>) parents.peek().getSubNodes()).set(index.peek(),
                                    new FillableBlankStmnt(replaced.empty + replaced.filled));
                        } else if (nodes.peek() instanceof ExpressionBase) {
                            ((ArrayList<MiniJASTNode>) parents.peek().getSubNodes()).set(index.peek(),
                                    new FillableBlankExpr(replaced.empty + replaced.filled));
                        } else {
                            System.err.println("node was neither StatementBase nor ExpressionBase!");
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
}
