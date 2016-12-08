package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.UnannType;

public class RelationExpr extends EqExpr {
    private RelationOp op;
    private RelationExpr leftSide; // Left associative
    private AddExpr rightSide;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        ReturnValuesBoolean result;

        ReturnValues l = leftSide.evaluate(c);
        ReturnValues r = rightSide.evaluate(c);

        if (l.getType().uType == UnannType.BOOLEAN || r.getType().uType == UnannType.BOOLEAN)
            throw new Exception("Cannot relate boolean values");

        switch (op) {
            case GT:
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value > ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value > ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value > ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value > ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value > ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value > ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value > ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value > ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value > ((ReturnValuesDouble)r).value);
                        }


                }
            case LT:
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value < ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value < ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value < ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value < ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value < ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value < ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value < ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value < ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value < ((ReturnValuesDouble)r).value);
                        }
                }
            case GTE:
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value >= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value >= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value >= ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value >= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value >= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value >= ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value >= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value >= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value >= ((ReturnValuesDouble)r).value);
                        }
                }
            default: // LTE
                switch (l.getType().uType) {
                    case CHAR:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value <= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value <= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesChar)l).value <= ((ReturnValuesDouble)r).value);
                        }
                    case INT:
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value <= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value <= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesInt)l).value <= ((ReturnValuesDouble)r).value);
                        }
                    default: // DOUBLE
                        switch (r.getType().uType) {
                            case CHAR:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value <= ((ReturnValuesChar)r).value);
                            case INT:
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value <= ((ReturnValuesInt)r).value);
                            default: // DOUBLE
                                return new ReturnValuesBoolean(((ReturnValuesDouble)l).value <= ((ReturnValuesDouble)r).value);
                        }
                }
        }
    }
}
