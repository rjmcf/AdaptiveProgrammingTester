package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesIntAA;
import miniJAST.types.Type;
import miniJAST.types.UnannType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class PrintStatementTest {
    PrintStatement pr;
    Expression boolExpr, intAAExpr, arrayExpr;
    Context c;

    @BeforeMethod
    public void setUp() {
        pr = new PrintStatement();
        boolExpr = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesBool(true);
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
                return new ReturnValuesArray<Character>(new Type(UnannType.CHAR,5), string);
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