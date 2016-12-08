package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.returnValues.ReturnValuesChar;
import miniJAST.expressions.returnValues.ReturnValuesDouble;
import miniJAST.expressions.returnValues.ReturnValuesInt;

public class UnaryPreIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private AssignLHS expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        if (expr instanceof ArrayAccess)
            throw new Exception("Arrays not implemented yet");

        Id id = (Id)expr;
        ReturnValues e = id.evaluate(c);

        ReturnValues result;

        switch (e.getType().uType) {
            case CHAR:
                char ch = isPlus ? (char)(((ReturnValuesChar)e).value + 1) : (char)(((ReturnValuesChar)e).value - 1);
                result = new ReturnValuesChar(ch);
                c.namesToValues.put(id.getName(), ch);
                return result;
            case INT:
                int i = isPlus ? ((ReturnValuesInt)e).value + 1 : ((ReturnValuesInt)e).value - 1;
                result = new ReturnValuesInt(i);
                c.namesToValues.put(id.getName(), i);
                return result;
            case DOUBLE:
                double d = isPlus ? ((ReturnValuesDouble)e).value + 1 : ((ReturnValuesDouble)e).value - 1;
                result = new ReturnValuesDouble(d);
                c.namesToValues.put(id.getName(), d);
                return result;
            default: // BOOLEAN
                throw new Exception("Cannot increment or decrement a Boolean expression");
        }
    }
}
