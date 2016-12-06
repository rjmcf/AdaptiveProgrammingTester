package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.types.GeneralType;

public class ShiftExpr extends RelationExpr {
    private ShiftOp op;
    private ShiftExpr leftSide; // Left associative
    private AddExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues left = leftSide.evaluate(c);
        ReturnValues right = rightSide.evaluate(c);

        if (left.gType == GeneralType.BOOL || right.gType == GeneralType.BOOL)
            throw new Exception("Cannot use <<, >> or >>> on operands of type Boolean");

        ReturnValues result = new ReturnValues();
        result.type = left.type.compareTo(right.type) >= 0 ? left.type : right.type;

        switch (left.gType) {
            case INTEGER:
                switch (right.gType) {
                    case INTEGER:
                        result.gType = GeneralType.INTEGER;
                        switch (op) {
                            case LS:
                                result.intVal = left.intVal << right.intVal;
                                break;
                            case RS:
                                result.intVal = left.intVal >> right.intVal;
                                break;
                            default:
                                result.intVal = left.intVal >>> right.intVal;
                                break;

                        }
                        break;
                    case FP:
                        throw new Exception("Cannot use <<, >> or >>> on operands of FP type");
                }
                break;
            case FP:
                throw new Exception("Cannot use <<, >> or >>> on operands of FP type");
        }

        return result;
    }
}
