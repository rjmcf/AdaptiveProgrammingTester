package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.StatementExpr;
import miniJAST.statements.FlowControl;

import java.util.ArrayList;

public class UnaryPreIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private AssignLHS expr;

    public UnaryPreIncExpr(boolean p, AssignLHS e) { isPlus = p; expr = e; }

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        if (expr instanceof ArrayAccess) {
            ArrayAccess aa = (ArrayAccess) expr;
            ReturnValues raa = aa.evaluate(c);

            switch (raa.getType().uType) {
                case CHAR:
                    ReturnValuesCharAA rcaa = (ReturnValuesCharAA) raa;
                    char ch = isPlus ? (char) (rcaa.value + 1) : (char) (rcaa.value - 1);
                    if (!c.namesToValues.containsKey(rcaa.getName()))
                        throw new Exception("Variable not initialised");
                    ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                    chs.set(rcaa.getIndex(), ch);
                    c.namesToValues.put(rcaa.getName(), chs);
                    return new ReturnValuesChar(ch);
                case INT:
                    ReturnValuesIntAA riaa = (ReturnValuesIntAA) raa;
                    int i = isPlus ? riaa.value + 1 :  riaa.value - 1;
                    if (!c.namesToValues.containsKey(riaa.getName()))
                        throw new Exception("Variable not initialised");
                    ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                    is.set(riaa.getIndex(), i);
                    c.namesToValues.put(riaa.getName(), is);
                    return new ReturnValuesInt(i);
                case DOUBLE:
                    ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) raa;
                    double d = isPlus ? rdaa.value + 1 : rdaa.value - 1;
                    if (!c.namesToValues.containsKey(rdaa.getName()))
                        throw new Exception("Variable not initialised");
                    ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                    ds.set(rdaa.getIndex(), d);
                    c.namesToValues.put(rdaa.getName(), ds);
                    return new ReturnValuesDouble(d);
                default: // BOOLEAN
                    throw new Exception("Cannot increment or decrement a Boolean expression");
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
                    throw new Exception("Cannot increment or decrement a Boolean expression");
            }
        }
    }

    @Override
    // This is never called but needs implementing to satisfy compiler
    // This implements StatementExpression which extends ExpressionStatement which extends BlockStatement
    public FlowControl execute(Context c) throws Exception {
        return null;
    }
}
