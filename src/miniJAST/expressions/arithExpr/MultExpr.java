package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.ReturnValues;
import miniJAST.types.GeneralType;

public class MultExpr extends AddExpr {
    private MultOp op;
    private MultExpr leftSide; // Left associative
    private UnaryExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues left = leftSide.evaluate(c);
        ReturnValues right = rightSide.evaluate(c);

        if (left.gType == GeneralType.BOOL || right.gType == GeneralType.BOOL)
            throw new Exception("Cannot use *, / or % on operands of type Boolean");

        ReturnValues result = new ReturnValues();
        result.type = left.type.compareTo(right.type) >= 0 ? left.type : right.type;

        switch (left.gType) {
            case INTEGER:
                switch (right.gType) {
                    case INTEGER:
                        result.gType = GeneralType.INTEGER;
                        switch (op) {
                            case MULT:
                                result.intVal = left.intVal * right.intVal;
                                break;
                            case DIV:
                                result.intVal = left.intVal / right.intVal;
                                break;
                            default:
                                result.intVal = left.intVal % right.intVal;
                                break;

                        }
                        break;
                    case FP:
                        result.gType = GeneralType.FP;
                        switch (op) {
                            case MULT:
                                result.fpVal = left.intVal * right.fpVal;
                                break;
                            case DIV:
                                result.fpVal = left.intVal / right.fpVal;
                                break;
                            case MOD:
                                result.fpVal = left.intVal % right.fpVal;
                                break;
                        }
                        break;
                }
                break;
            case FP:
                result.gType = GeneralType.FP;
                switch (right.gType) {
                    case INTEGER:
                        switch (op) {
                            case MULT:
                                result.fpVal = left.fpVal * right.intVal;
                                break;
                            case DIV:
                                result.fpVal = left.fpVal / right.intVal;
                                break;
                            case MOD:
                                result.fpVal = left.fpVal % right.intVal;
                                break;
                        }
                        break;
                    case FP:
                        switch (op) {
                            case MULT:
                                result.fpVal = left.fpVal * right.fpVal;
                                break;
                            case DIV:
                                result.fpVal = left.fpVal / right.fpVal;
                                break;
                            case MOD:
                                result.fpVal = left.fpVal % right.fpVal;
                                break;
                        }
                        break;
                }
                break;
        }

        return result;
    }
}
