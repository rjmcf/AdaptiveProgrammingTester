package miniJAST.expressions.arithExpr;

import miniJAST.Context;
import miniJAST.expressions.boolExpr.RelationExpr;
import miniJAST.expressions.returnValues.ReturnValues;
import miniJAST.types.GeneralType;

public class AddExpr extends RelationExpr {
    private boolean isPlus;
    private AddExpr leftSide; // Left associative
    private MultExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues left = leftSide.evaluate(c);
        ReturnValues right = rightSide.evaluate(c);

        if (left.gType == GeneralType.BOOL || right.gType == GeneralType.BOOL)
            throw new Exception("Cannot use + or - on operands of type Boolean");

        ReturnValues result = new ReturnValues();
        result.type = left.type.compareTo(right.type) >= 0 ? left.type : right.type;

        switch (left.gType) {
            case INTEGER:
                switch (right.gType) {
                    case INTEGER:
                        result.gType = GeneralType.INTEGER;
                        result.intVal = isPlus ? left.intVal + right.intVal : left.intVal - right.intVal;
                        break;
                    case FP:
                        result.gType = GeneralType.FP;
                        result.fpVal = isPlus ? left.intVal + right.fpVal : left.intVal - right.fpVal;
                        break;
                }
                break;
            case FP:
                result.gType = GeneralType.FP;
                switch (right.gType) {
                    case INTEGER:
                        result.fpVal = isPlus ? left.fpVal + right.intVal : left.fpVal - right.intVal;
                        break;
                    case FP:
                        result.fpVal = isPlus ? left.fpVal + right.fpVal : left.fpVal - right.fpVal;
                        break;
                }
                break;
        }

        return result;
    }
}
