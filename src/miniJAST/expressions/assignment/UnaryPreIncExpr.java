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
import miniJAST.types.Type;

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
            if (!aa.checkDefined(c)) {
                throw new VariableNotInitException(aa.getName());
            }
            Type arType = aa.getArType();
            int index = aa.evaluateIndex(c).value;

            switch (arType.pType) {
                case CHAR:
                    ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(aa.getName());
                    char cVal = chs.get(index);
                    char ch = isPlus ? (char) (cVal + 1) : (char) (cVal - 1);
                    chs.set(index, ch);
                    c.namesToValues.peek().put(aa.getName(), chs);
                    return new ReturnValuesChar(ch);
                case INT:
                    ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(aa.getName());
                    int iVal = is.get(index);
                    int i = isPlus ? iVal + 1 : iVal - 1;
                    is.set(index, i);
                    c.namesToValues.peek().put(aa.getName(), is);
                    return new ReturnValuesInt(i);
                case DOUBLE:
                    ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(aa.getName());
                    double dVal = ds.get(index);
                    double d = isPlus ? dVal + 1 : dVal - 1;
                    ds.set(index, d);
                    c.namesToValues.peek().put(aa.getName(), ds);
                    return new ReturnValuesDouble(d);
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }


        } else {
            Id id = (Id) expr;
            if (!id.checkDefined(c))
                throw new VariableNotInitException(id.getName());

            switch (id.getType().pType) {
                case CHAR:
                    char cVal = (char)c.namesToValues.peek().get(id.getName());
                    char ch = isPlus ? (char) (cVal + 1) : (char) (cVal - 1);
                    c.namesToValues.peek().put(id.getName(), ch);
                    return new ReturnValuesChar(ch);
                case INT:
                    int iVal = (int)c.namesToValues.peek().get(id.getName());
                    int i = isPlus ? iVal + 1 : iVal - 1;
                    c.namesToValues.peek().put(id.getName(), i);
                    return new ReturnValuesInt(i);
                case DOUBLE:
                    double dVal = (double)c.namesToValues.peek().get(id.getName());
                    double d = isPlus ? dVal + 1 : dVal - 1;
                    c.namesToValues.peek().put(id.getName(), d);
                    return new ReturnValuesDouble(d);
                default: // BOOLEAN
                    throw new TypeException("Cannot increment or decrement a Boolean expression");
            }
        }
    }
}
