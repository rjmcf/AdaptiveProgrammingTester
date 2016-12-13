package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.returnValues.ReturnValuesArray;
import miniJAST.expressions.returnValues.ReturnValuesBool;
import miniJAST.expressions.returnValues.ReturnValuesIntAA;
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
        };
        intAAExpr = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                return new ReturnValuesIntAA("fakeArray", 2, 42);
            }
        };
        arrayExpr = new Expression() {
            @Override
            public ReturnValues evaluate(Context c) throws MiniJASTException {
                ArrayList<Character> string = new  ArrayList<>();
                string.add('H');
                string.add('e');
                string.add('l');
                string.add('l');
                string.add('o');
                string.add('!');
                return new ReturnValuesArray<Character>(UnannType.CHAR, string);
            }
        };
        c = new Context();
    }

    @Test
    public void testExecute() {
        try {
            pr.setUp(boolExpr);
            pr.execute(c);

            pr.setUp(intAAExpr);
            pr.execute(c);

            pr.setUp(arrayExpr);
            pr.execute(c);
        } catch (MiniJASTException e) {
            e.printStackTrace();
            Assert.fail("A MiniJASTException was thrown");
        }
    }
}