package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.Id;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.StatementExpr;

public class UnaryPreIncExpr extends UnaryExpr implements StatementExpr {
    private boolean isPlus;
    private Id expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues e = expr.evaluate(c);
        ReturnValues result = new ReturnValues();

        type = e.type;
        result.type = e.type;
        result.gType = e.gType;

        switch (e.gType) {
            case BOOL:
                throw new Exception("Only numeric types can be post-incremented/decremented");
            case INTEGER:
                if(c.namesToTypes.get(expr.getName()).equals(e.type)) {
                    c.namesToValues.put(expr.getName(), isPlus ? e.intVal + 1 : e.intVal - 1);
                    result.intVal = isPlus ? e.intVal + 1 : e.intVal - 1;
                } else throw new Exception("Variable " + expr.getName() + " not visible in this scope");
                break;
            case FP:
                if(c.namesToTypes.get(expr.getName()).equals(e.type)) {
                    c.namesToValues.put(expr.getName(), isPlus ? e.fpVal + 1 : e.fpVal - 1);
                    result.fpVal = isPlus ? e.fpVal + 1 : e.fpVal - 1;
                } else throw new Exception("Variable " + expr.getName() + " not visible in this scope");
                break;
        }

        return result;
    }
}
