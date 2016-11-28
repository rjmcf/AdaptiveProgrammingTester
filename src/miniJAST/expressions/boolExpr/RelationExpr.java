package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.ReturnValues;
import miniJAST.expressions.arithExpr.ShiftExpr;
import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class RelationExpr extends EqExpr {
    private RelationOp op;
    private RelationExpr leftSide; // Left associative
    private ShiftExpr rightSide;

    public void setOp(RelationOp o) { op = o; }
    public void setLeft(RelationExpr l) { leftSide = l; }
    public void setRight(ShiftExpr r) { rightSide = r; }

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (leftSide.getType() != rightSide.getType())
            throw new Exception("Type mismatch between arguments of relational operator.");
        if (leftSide.getType() == UnannType.BOOLEAN || rightSide.getType() == UnannType.BOOLEAN)
            throw new Exception("Cannot use relation operators on operands of type Boolean.");

        type = UnannType.BOOLEAN;

        ReturnValues result = new ReturnValues();
        result.type = UnannType.BOOLEAN;
        result.gType = GeneralType.BOOL;

        switch (op) {
            case LT:
                switch (leftSide.getType()) {
                    case BYTE:
                    case CHAR:
                    case SHORT:
                    case INT:
                    case LONG:
                        result.boolVal = l.intVal < r.intVal;
                        return result;
                    case FLOAT:
                    case DOUBLE:
                        result.boolVal = l.fpVal < r.fpVal;
                        return result;
                    default:
                        throw new Exception("LHS type is not one of possible UnannTypes.");
                }
            case GTE:
                RelationExpr reGTE = new RelationExpr();
                reGTE.setLeft(leftSide);
                reGTE.setRight(rightSide);
                reGTE.setOp(RelationOp.LT);
                ReturnValues notRGTE = reGTE.evaluate(c);
                result.boolVal = !(notRGTE.boolVal);
                return result;
            case GT:
                switch (leftSide.getType()) {
                    case BYTE:
                    case CHAR:
                    case SHORT:
                    case INT:
                    case LONG:
                        result.boolVal = l.intVal > r.intVal;
                        return result;
                    case FLOAT:
                    case DOUBLE:
                        result.boolVal = l.fpVal > r.fpVal;
                        return result;
                    default:
                        throw new Exception("LHS type is not one of possible UnannTypes.");
                }
            case LTE:
                RelationExpr reLTE = new RelationExpr();
                reLTE.setLeft(leftSide);
                reLTE.setRight(rightSide);
                reLTE.setOp(RelationOp.GT);
                ReturnValues notRLTE = reLTE.evaluate(c);
                result.boolVal = !(notRLTE.boolVal);
                return result;
            case INSTANCEOF:
                throw new Exception("Instance of not yet implemented");
            default:
                throw new Exception("Op is not one of possible RelationOps.");
        }
    }
}
