package miniJAST.statements;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesIntAA;
import miniJAST.types.Type;
import miniJAST.types.PrimType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class PrintStatementTest {
    PrintStatement pr;
    Expression boolExpr, intAAExpr, arrayExpr;
    Context c;

    @BeforeMethod
    public void setUp() throws Exception{
        pr = new PrintStatement("test/testOutput.txt");
        boolExpr = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesBool(true);
            }

            @Override
            public boolean getIsLeaf() { return false; }

            @Override
            public boolean getIsMarked() { return false; }

            @Override
            public void setMarked(boolean b) { }

            @Override
            public void setIsLeaf(boolean b) { }

            @Override
            public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

            @Override
            public NodeCount getTreeSize() {
                return new NodeCount(1,0);
            }

            @Override
            public String stringRepr() {
                return "true";
            }
        };
        intAAExpr = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesIntAA("fakeArray", 2, 42);
            }

            @Override
            public boolean getIsLeaf() { return false; }

            @Override
            public boolean getIsMarked() { return false; }

            @Override
            public void setMarked(boolean b) { }

            @Override
            public void setIsLeaf(boolean b) { }

            @Override
            public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

            @Override
            public NodeCount getTreeSize() {
                return new NodeCount(1,0);
            }

            @Override
            public String stringRepr() {
                return "fakeArray[2]";
            }
        };
        arrayExpr = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                ArrayList<Character> string = new  ArrayList<>();
                string.add('P');
                string.add('r');
                string.add('i');
                string.add('n');
                string.add('t');
                return new ReturnValuesArray<Character>(new Type(PrimType.CHAR,5), string);
            }

            @Override
            public boolean getIsLeaf() { return false; }

            @Override
            public boolean getIsMarked() { return false; }

            @Override
            public void setMarked(boolean b) { }

            @Override
            public void setIsLeaf(boolean b) { }

            @Override
            public ArrayList<? extends MiniJASTNode> getSubNodes() { return null; }

            @Override
            public NodeCount getTreeSize() {
                return new NodeCount(1,0);
            }

            @Override
            public String stringRepr() {
                return "['P', 'r', 'i', 'n', 't']";
            }
        };
        c = new Context();
    }

    @Test
    public void testExecute() {
        try {
            pr.setUpPrint(boolExpr);
            pr.executeStart(c);

            pr.setUpPrint(intAAExpr);
            pr.executeStart(c);

            pr.setUpPrint(arrayExpr);
            pr.executeStart(c);
        } catch (MiniJASTException e) {
            e.printStackTrace();
            Assert.fail("A MiniJASTException was thrown");
        }
    }
}