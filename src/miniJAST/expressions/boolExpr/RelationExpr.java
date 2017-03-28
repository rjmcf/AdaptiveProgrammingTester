package miniJAST.expressions.boolExpr;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.arithExpr.AddExpr;
import miniJAST.expressions.returnValues.*;
import miniJAST.types.PrimType;

public class RelationExpr extends EqExpr {
    private RelationOp op;
    private int leftSide; // Left associative
    private int rightSide;

    public void setUpRelationExpr(RelationOp o, Expression l, Expression r) {
        subNodes.clear();
        op = o; leftSide = 0; rightSide = 1;
        subNodes.add(l); subNodes.add(r);
    }

    @Override
    public String stringRepr() {
        String opS;
        switch (op) {
            case GT:
                opS = " > ";
                break;
            case LT:
                opS = " < ";
                break;
            case GTE:
                opS = " >= ";
                break;
            default: // LTE
                opS = " <= ";
        }
        return subNodes.get(leftSide).stringRepr() + opS + subNodes.get(rightSide).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException {
        checkType(subNodes.get(leftSide), RelationExpr.class);
        checkType(subNodes.get(rightSide), AddExpr.class);

        ReturnValues l = subNodes.get(leftSide).evaluate(c);
        ReturnValues r = subNodes.get(rightSide).evaluate(c);

        if (l.getType().uType == PrimType.BOOLEAN || r.getType().uType == PrimType.BOOLEAN)
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
