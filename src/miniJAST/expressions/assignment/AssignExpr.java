package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.ReturnValues;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.types.GeneralType;
import miniJAST.types.UnannType;

public class AssignExpr extends Expression implements StatementExpr {
    private AssignLHS lhs;
    private AssignOp op;
    private Expression expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        if (lhs instanceof ArrayAccess)
            throw new Exception("Arrays not yet implemented");

        Id id = ((Id)lhs);
        ReturnValues current = id.evaluate(c);
        ReturnValues ex = expr.evaluate(c);

        if (UnannType.canBeAssigned(id.getType(), expr.getType())) {
            type = id.getType();
            ReturnValues result = new ReturnValues();
            result.type = id.getType();
            switch(id.getType()) {
                case BOOLEAN:
                    result.gType = GeneralType.BOOL;
                    break;
                case BYTE:
                case CHAR:
                case SHORT:
                case INT:
                case LONG:
                    result.gType = GeneralType.INTEGER;
                    break;
                case FLOAT:
                case DOUBLE:
                    result.gType = GeneralType.FP;
                    break;
                default:
                    throw new Exception("Type of id not one of possible UnannTypes.");

            }

            switch (op) {
                case EQ:
                    switch (result.gType) {
                        case BOOL:
                            c.namesToValues.put(id.getName(), ex.boolVal);
                            result.boolVal = ex.boolVal;
                            return result;
                        case INTEGER:
                            c.namesToValues.put(id.getName(), ex.intVal);
                            result.intVal = ex.intVal;
                            return result;
                        case FP:
                            c.namesToValues.put(id.getName(), ex.fpVal);
                            result.fpVal = ex.fpVal;
                            return result;
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case PLUSEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use += on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal + ex.intVal));
                                result.intVal = current.intVal + ex.intVal;
                            } else {
                                c.namesToValues.put(id.getName(), (long)(current.intVal + ex.fpVal));
                                result.intVal = (long)(current.intVal + ex.fpVal);
                            }
                            return result;
                        case FP:
                            c.namesToValues.put(id.getName(), current.fpVal + ex.fpVal);
                            result.fpVal = current.fpVal + ex.fpVal;
                            return result;
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case SUBEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use -= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal - ex.intVal));
                                result.intVal = current.intVal - ex.intVal;
                            } else {
                                c.namesToValues.put(id.getName(), (long)(current.intVal - ex.fpVal));
                                result.intVal = (long)(current.intVal - ex.fpVal);
                            }
                            return result;
                        case FP:
                            c.namesToValues.put(id.getName(), current.fpVal - ex.fpVal);
                            result.fpVal = current.fpVal - ex.fpVal;
                            return result;
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case TIMESEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use *= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal * ex.intVal));
                                result.intVal = current.intVal * ex.intVal;
                            } else {
                                c.namesToValues.put(id.getName(), (long)(current.intVal * ex.fpVal));
                                result.intVal = (long)(current.intVal * ex.fpVal);
                            }
                            return result;
                        case FP:
                            c.namesToValues.put(id.getName(), current.fpVal * ex.fpVal);
                            result.fpVal = current.fpVal * ex.fpVal;
                            return result;
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case DIVEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use /= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal / ex.intVal));
                                result.intVal = current.intVal / ex.intVal;
                            } else {
                                c.namesToValues.put(id.getName(), (long)(current.intVal / ex.fpVal));
                                result.intVal = (long)(current.intVal / ex.fpVal);
                            }
                            return result;
                        case FP:
                            c.namesToValues.put(id.getName(), current.fpVal / ex.fpVal);
                            result.fpVal = current.fpVal / ex.fpVal;
                            return result;
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case MODEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use %= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal % ex.intVal));
                                result.intVal = current.intVal % ex.intVal;
                            } else {
                                c.namesToValues.put(id.getName(), (long)(current.intVal % ex.fpVal));
                                result.intVal = (long)(current.intVal % ex.fpVal);
                            }
                            return result;
                        case FP:
                            c.namesToValues.put(id.getName(), current.fpVal % ex.fpVal);
                            result.fpVal = current.fpVal % ex.fpVal;
                            return result;
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case LSEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use <<= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal << ex.intVal));
                                result.intVal = current.intVal << ex.intVal;
                            } else {
                                throw new Exception("Cannot use <<= with operand of FP type");
                            }
                            return result;
                        case FP:
                            throw new Exception("Cannot use <<= with operand of FP type");
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case RSEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use >>= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal >> ex.intVal));
                                result.intVal = current.intVal >> ex.intVal;
                            } else {
                                throw new Exception("Cannot use >>= with operand of FP type");
                            }
                            return result;
                        case FP:
                            throw new Exception("Cannot use >>= with operand of FP type");
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case ZFRSEQ:
                    switch (result.gType) {
                        case BOOL:
                            throw new Exception("Cannot use >>>= on type boolean");
                        case INTEGER:
                            if (ex.gType == GeneralType.INTEGER) {
                                c.namesToValues.put(id.getName(), (current.intVal >>> ex.intVal));
                                result.intVal = current.intVal >>> ex.intVal;
                            } else {
                                throw new Exception("Cannot use >>>= with operand of FP type");
                            }
                            return result;
                        case FP:
                            throw new Exception("Cannot use >>>= with operand of FP type");
                        default:
                            throw new Exception("gType not one of possible GeneralTypes");
                    }
                case BANDEQ:
                    switch (result.gType) {
                        case BOOL:
                            c.namesToValues.put(id.getName(), current.boolVal & ex.boolVal);
                            result.boolVal = current.boolVal & ex.boolVal;
                            return result;
                        default:
                            throw new Exception("Cannot use &= on operands that aren't Boolean");
                    }
                case BOREQ:
                    switch (result.gType) {
                        case BOOL:
                            c.namesToValues.put(id.getName(), current.boolVal | ex.boolVal);
                            result.boolVal = current.boolVal | ex.boolVal;
                            return result;
                        default:
                            throw new Exception("Cannot use |= on operands that aren't Boolean");
                    }
                case BXOREQ:
                    switch (result.gType) {
                        case BOOL:
                            c.namesToValues.put(id.getName(), current.boolVal ^ ex.boolVal);
                            result.boolVal = current.boolVal ^ ex.boolVal;
                            return result;
                        default:
                            throw new Exception("Cannot use ^= on operands that aren't Boolean");
                    }
                default:
                    throw new Exception("op not one of possible relation operators");
            }
        } else
            throw new Exception(expr.getType() + " cannot be assigned to a variable of type " + id.getType() +".");
    }
}
