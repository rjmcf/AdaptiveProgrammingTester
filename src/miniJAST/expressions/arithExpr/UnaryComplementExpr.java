package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;

public class UnaryComplementExpr extends UnaryExpr {
    private boolean isBitwiseNotLogical;
    private UnaryExpr expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {

        ReturnValues e = expr.evaluate(c);
        
        ReturnValues result = new ReturnValues();
        result.type = e.type;
        type = e.type;

        if (isBitwiseNotLogical) {
            result.gType = GeneralType.INTEGER;
            switch (e.type) {
                case BOOLEAN:
                case FLOAT:
                case DOUBLE:
                    throw new Exception("~ takes an integral type only");
                case BYTE:
                    result.intVal = ~((byte)e.intVal);
                    break;
                case CHAR:
                    result.intVal = ~((char)e.intVal);
                    break;
                case SHORT:
                    result.intVal = ~((short)e.intVal);
                    break;
                case INT:
                    result.intVal = ~((int)e.intVal);
                    break;
                case LONG:
                    result.intVal = ~e.intVal;
                    break;
            }
        } else {
            result.gType = GeneralType.BOOL;
            switch (e.gType) {
                case INTEGER:
                case FP:
                    throw new Exception("! takes a boolean type only");
                case BOOL:
                    result.boolVal = !e.boolVal;
                    break;
            }
            
        }

        return result;
    }
}
