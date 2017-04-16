package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;

import java.util.ArrayList;

public class UnaryPostIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private int exprI;

    public void setUpPostIncExpr(boolean p, Expression e) {
        subNodes.clear();
        isPlus = p; exprI = 0; subNodes.add(e);
    }

    @Override
    public String stringRepr() {
        return subNodes.get(exprI).stringRepr() + (isPlus ? "++" : "--");
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(exprI), AssignLHS.class);

        AssignLHS expr;
        try {
            if (subNodes.get(exprI) instanceof FillableBlank) {
                expr = (AssignLHS)((FillableBlankExpr)subNodes.get(exprI)).getStudentExpr();
            } else {
                expr = (AssignLHS)subNodes.get(exprI);
            }
        } catch (ClassCastException e) {
            throw new TypeException("Left hand side of assignment must be of type AssignLHS!");
        }

        if (expr instanceof ArrayAccess) {
            ArrayAccess aa = (ArrayAccess) expr;
            ReturnValues raa = aa.evaluate(c);

            switch (raa.getType().uType) {
                case CHAR:
                    ReturnValuesCharAA rcaa = (ReturnValuesCharAA) raa;
                    char ch = isPlus ? (char) (rcaa.value + 1) : (char) (rcaa.value - 1);
                    if (!c.namesToValues.peek().containsKey(rcaa.getName()))
                        throw new VariableNotInitException((rcaa).getName());
                    ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(rcaa.getName());
                    chs.set(rcaa.getIndex(), ch);
                    c.namesToValues.peek().put(rcaa.getName(), chs);
                    return new ReturnValuesChar(rcaa.value);
                case INT:
                    ReturnValuesIntAA riaa = (ReturnValuesIntAA) raa;
                    int i = isPlus ? riaa.value + 1 :  riaa.value - 1;
                    if (!c.namesToValues.peek().containsKey(riaa.getName()))
                        throw new VariableNotInitException((riaa).getName());
                    ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(riaa.getName());
                    is.set(riaa.getIndex(), i);
                    c.namesToValues.peek().put(riaa.getName(), is);
                    return new ReturnValuesInt(riaa.value);
                case DOUBLE:
                    ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) raa;
                    double d = isPlus ? rdaa.value + 1 : rdaa.value - 1;
                    if (!c.namesToValues.peek().containsKey(rdaa.getName()))
                        throw new VariableNotInitException((rdaa).getName());
                    ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(rdaa.getName());
                    ds.set(rdaa.getIndex(), d);
                    c.namesToValues.peek().put(rdaa.getName(), ds);
                    return new ReturnValuesDouble(rdaa.value);
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }


        } else {
            Id id = (Id) expr;
            ReturnValues e = id.evaluate(c);

            switch (e.getType().uType) {
                case CHAR:
                    char ch = isPlus ? (char) (((ReturnValuesChar) e).value + 1) : (char) (((ReturnValuesChar) e).value - 1);
                    c.namesToValues.peek().put(id.getName(), ch);
                    return new ReturnValuesChar(((ReturnValuesChar) e).value);
                case INT:
                    int i = isPlus ? ((ReturnValuesInt) e).value + 1 : ((ReturnValuesInt) e).value - 1;
                    c.namesToValues.peek().put(id.getName(), i);
                    return new ReturnValuesInt(((ReturnValuesInt) e).value);
                case DOUBLE:
                    double d = isPlus ? ((ReturnValuesDouble) e).value + 1 : ((ReturnValuesDouble) e).value - 1;
                    c.namesToValues.peek().put(id.getName(), d);
                    return new ReturnValuesDouble(((ReturnValuesDouble) e).value);
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }
        }
    }
}
