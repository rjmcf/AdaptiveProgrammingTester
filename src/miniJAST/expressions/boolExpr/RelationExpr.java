package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.UnannType;

public class RelationExpr extends EqExpr {
    private RelationOp op;
    private RelationExpr leftSide; // Left associative
    private AddExpr rightSide;

    public void setUpRelationExpr(RelationOp o, RelationExpr l, AddExpr r) { op = o; leftSide = l; rightSide = r; }

    @Override
    public int getSubNodes() {
        int l = leftSide.getSubNodes();
        int r = rightSide.getSubNodes();
        return l + r + 2;
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        ReturnValuesBool result;

        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (l.getType().uType == UnannType.BOOLEAN || r.getType().uType == UnannType.BOOLEAN)
            throw new TypeException("Cannot relate boolean values");

        if (l.getIsArray() || r.getIsArray())
            throw new TypeException("Cannot operate on whole arrays");

        switch (op) {
            case GT:
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value > ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value > ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesChar)l).value > ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value > ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value > ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesInt)l).value > ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value > ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value > ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value > ((ReturnValuesDouble)r).value);
                        }


                }
            case LT:
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value < ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value < ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesChar)l).value < ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value < ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value < ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesInt)l).value < ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value < ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value < ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value < ((ReturnValuesDouble)r).value);
                        }
                }
            case GTE:
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value >= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value >= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesChar)l).value >= ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value >= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value >= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesInt)l).value >= ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value >= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value >= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value >= ((ReturnValuesDouble)r).value);
                        }
                }
            default: // LTE
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value <= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesChar)l).value <= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesChar)l).value <= ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value <= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesInt)l).value <= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesInt)l).value <= ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value <= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value <= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBool(((ReturnValuesDouble)l).value <= ((ReturnValuesDouble)r).value);
                        }
                }
        }
    }
}
