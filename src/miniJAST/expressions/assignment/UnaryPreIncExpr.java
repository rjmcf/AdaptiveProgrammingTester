package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.arithExpr.UnaryExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.StatementExpr;

import java.util.ArrayList;

public class UnaryPreIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private AssignLHS expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        if (expr instanceof ArrayAccess) {
            ArrayAccess aa = (ArrayAccess) expr;
            ReturnValuesArrayAccess raa = (ReturnValuesArrayAccess) aa.evaluate(c);

            switch (raa.getType().uType) {
                case CHAR:
                    char ch = isPlus ? (char) ((char)raa.value + 1) : (char) ((char)raa.value - 1);
                    ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(raa.name);
                    chs.set(raa.index, ch);
                    c.namesToValues.put(raa.name, chs);
                    return new ReturnValuesChar(ch);
                case INT:
                    int i = isPlus ? (int)raa.value + 1 :  (int)raa.value - 1;
                    ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(raa.name);
                    is.set(raa.index, i);
                    c.namesToValues.put(raa.name, is);
                    return new ReturnValuesInt(i);
                case DOUBLE:
                    double d = isPlus ? (double)raa.value + 1 : (double)raa.value - 1;
                    ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(raa.name);
                    ds.set(raa.index, d);
                    c.namesToValues.put(raa.name, ds);
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
}
