package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.NodeCount;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.Id;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.FlowControl;

import java.util.ArrayList;

public class UnaryPostIncExpr extends UnaryPostfixExpr implements StatementExpr {
    private boolean isPlus;
    private AssignLHS expr;

    public void setUpPostIncExpr(boolean p, AssignLHS e) { isPlus = p; expr = e; subNodes.add(expr); }

    @Override
    public NodeCount getTreeSize() {
        NodeCount result = expr.getTreeSize();
        result.filled++;
        return result;
    }

    @Override
    public String stringRepr() {
        return expr.stringRepr() + (isPlus ? "++" : "--");
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        if (expr instanceof ArrayAccess) {
            ArrayAccess aa = (ArrayAccess) expr;
            ReturnValues raa = aa.evaluate(c);

            switch (raa.getType().uType) {
                case CHAR:
                    ReturnValuesCharAA rcaa = (ReturnValuesCharAA) raa;
                    char ch = isPlus ? (char) (rcaa.value + 1) : (char) (rcaa.value - 1);
                    if (!c.namesToValues.containsKey(rcaa.getName()))
                        throw new VariableNotInitException((rcaa).getName());
                    ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                    chs.set(rcaa.getIndex(), ch);
                    c.namesToValues.put(rcaa.getName(), chs);
                    return new ReturnValuesChar(rcaa.value);
                case INT:
                    ReturnValuesIntAA riaa = (ReturnValuesIntAA) raa;
                    int i = isPlus ? riaa.value + 1 :  riaa.value - 1;
                    if (!c.namesToValues.containsKey(riaa.getName()))
                        throw new VariableNotInitException((riaa).getName());
                    ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                    is.set(riaa.getIndex(), i);
                    c.namesToValues.put(riaa.getName(), is);
                    return new ReturnValuesInt(riaa.value);
                case DOUBLE:
                    ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) raa;
                    double d = isPlus ? rdaa.value + 1 : rdaa.value - 1;
                    if (!c.namesToValues.containsKey(rdaa.getName()))
                        throw new VariableNotInitException((rdaa).getName());
                    ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                    ds.set(rdaa.getIndex(), d);
                    c.namesToValues.put(rdaa.getName(), ds);
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
                    c.namesToValues.put(id.getName(), ch);
                    return new ReturnValuesChar(((ReturnValuesChar) e).value);
                case INT:
                    int i = isPlus ? ((ReturnValuesInt) e).value + 1 : ((ReturnValuesInt) e).value - 1;
                    c.namesToValues.put(id.getName(), i);
                    return new ReturnValuesInt(((ReturnValuesInt) e).value);
                case DOUBLE:
                    double d = isPlus ? ((ReturnValuesDouble) e).value + 1 : ((ReturnValuesDouble) e).value - 1;
                    c.namesToValues.put(id.getName(), d);
                    return new ReturnValuesDouble(((ReturnValuesDouble) e).value);
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }
        }
    }
}
