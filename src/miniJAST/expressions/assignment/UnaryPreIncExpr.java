package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.FillableBlankExpr;
import miniJAST.expressions.Id;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.StatementExpr;

import java.util.ArrayList;

public class UnaryPreIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private int exprI;

    public void setUpPreIncExpr(boolean p, Expression e) {
        subNodes.clear();
        isPlus = p; exprI = 0; subNodes.add(e);
    }

    @Override
    public String stringRepr() {
        return (isPlus ? "++" : "--") + subNodes.get(exprI).stringRepr();
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
                    if (!c.namesToValues.containsKey(rcaa.getName()))
                        throw new VariableNotInitException(rcaa.getName());
                    ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                    chs.set(rcaa.getIndex(), ch);
                    c.namesToValues.put(rcaa.getName(), chs);
                    return new ReturnValuesChar(ch);
                case INT:
                    ReturnValuesIntAA riaa = (ReturnValuesIntAA) raa;
                    int i = isPlus ? riaa.value + 1 :  riaa.value - 1;
                    if (!c.namesToValues.containsKey(riaa.getName()))
                        throw new VariableNotInitException(riaa.getName());
                    ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                    is.set(riaa.getIndex(), i);
                    c.namesToValues.put(riaa.getName(), is);
                    return new ReturnValuesInt(i);
                case DOUBLE:
                    ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) raa;
                    double d = isPlus ? rdaa.value + 1 : rdaa.value - 1;
                    if (!c.namesToValues.containsKey(rdaa.getName()))
                        throw new VariableNotInitException(rdaa.getName());
                    ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                    ds.set(rdaa.getIndex(), d);
                    c.namesToValues.put(rdaa.getName(), ds);
                    return new ReturnValuesDouble(d);
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }
        } else {
            Id id = (Id) expr;
            ReturnValues e = id.evaluate(c);

            ReturnValues result;

            switch (e.getType().uType) {
                case CHAR:
                    char ch = isPlus ? (char) (((ReturnValuesChar) e).value + 1) : (char) (((ReturnValuesChar) e).value - 1);
                    result = new ReturnValuesChar(ch);
                    c.namesToValues.put(id.getName(), ch);
                    return result;
                case INT:
                    int i = isPlus ? ((ReturnValuesInt) e).value + 1 : ((ReturnValuesInt) e).value - 1;
                    result = new ReturnValuesInt(i);
                    c.namesToValues.put(id.getName(), i);
                    return result;
                case DOUBLE:
                    double d = isPlus ? ((ReturnValuesDouble) e).value + 1 : ((ReturnValuesDouble) e).value - 1;
                    result = new ReturnValuesDouble(d);
                    c.namesToValues.put(id.getName(), d);
                    return result;
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }
        }
    }
}
