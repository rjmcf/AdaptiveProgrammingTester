package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.types.UnannType;

public class AssignExpr extends Expression implements StatementExpr {
    private AssignLHS lhs;
    private AssignOp op;
    private Expression expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        if (lhs instanceof ArrayAccess)
            throw new Exception("Arrays not yet implemented");
        // TODO implement arrays and update this.

        Id id = ((Id) lhs);
        ReturnValues current = id.evaluate(c);
        ReturnValues ex = expr.evaluate(c);

        ReturnValues result;

        switch (op) {
            case EQ:
                switch (current.getType().uType) {
                    case BOOLEAN:
                        if (ex.getType().uType != UnannType.BOOLEAN)
                            throw new Exception("Cannot assign anything but a boolean value to a boolean variable");
                        boolean b = ((ReturnValuesBoolean) ex).value;
                        c.namesToValues.put(id.getName(), b);
                        return new ReturnValuesBoolean(b);
                    case CHAR:
                        if (ex.getType().uType != UnannType.CHAR)
                            throw new Exception("Cannot assign anything but a char value to a char variable");
                        char ch = ((ReturnValuesChar) ex).value;
                        c.namesToValues.put(id.getName(), ch);
                        return new ReturnValuesChar(ch);
                    case INT:
                        if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                            throw new Exception("Can only assign char or int to int variable");
                        int i;
                        switch (ex.getType().uType) {
                            case CHAR:
                                i = ((ReturnValuesChar) ex).value;
                                break;
                            case INT:
                                i = ((ReturnValuesInt) ex).value;
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), i);
                        return new ReturnValuesInt(i);
                    default: // DOUBLE
                        if (ex.getType().uType == UnannType.BOOLEAN)
                            throw new Exception("Cannot assign boolean to double variable");
                        double d;
                        switch (ex.getType().uType) {
                            case CHAR:
                                d = ((ReturnValuesChar) ex).value;
                                break;
                            case INT:
                                d = ((ReturnValuesInt) ex).value;
                                break;
                            case DOUBLE:
                                d = ((ReturnValuesDouble) ex).value;
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), d);
                        return new ReturnValuesDouble(d);
                }
            case PLUSEQ:
                switch (current.getType().uType) {
                    case CHAR:
                        if (ex.getType().uType != UnannType.CHAR)
                            throw new Exception("Cannot assign anything but a char value to a char variable");
                        char ch = (char)(((ReturnValuesChar) ex).value + ((char)c.namesToValues.get(id.getName())));
                        c.namesToValues.put(id.getName(), ch);
                        return new ReturnValuesChar(ch);
                    case INT:
                        if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                            throw new Exception("Can only assign char or int to int variable");
                        int i;
                        switch (ex.getType().uType) {
                            case CHAR:
                                i = ((ReturnValuesChar) ex).value + (int)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                i = ((ReturnValuesInt) ex).value + (int)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), i);
                        return new ReturnValuesInt(i);
                    case DOUBLE:
                        if (ex.getType().uType == UnannType.BOOLEAN)
                            throw new Exception("Cannot assign boolean to double variable");
                        double d;
                        switch (ex.getType().uType) {
                            case CHAR:
                                d = ((ReturnValuesChar) ex).value  + (double)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                d = ((ReturnValuesInt) ex).value  + (double)c.namesToValues.get(id.getName());
                                break;
                            case DOUBLE:
                                d = ((ReturnValuesDouble) ex).value  + (double)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), d);
                        return new ReturnValuesDouble(d);
                    default:
                        throw new Exception("Cannot use += on variable of type boolean");
                }
            case SUBEQ:
                switch (current.getType().uType) {
                    case CHAR:
                        if (ex.getType().uType != UnannType.CHAR)
                            throw new Exception("Cannot assign anything but a char value to a char variable");
                        char ch = (char)(((ReturnValuesChar) ex).value - ((char)c.namesToValues.get(id.getName())));
                        c.namesToValues.put(id.getName(), ch);
                        return new ReturnValuesChar(ch);
                    case INT:
                        if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                            throw new Exception("Can only assign char or int to int variable");
                        int i;
                        switch (ex.getType().uType) {
                            case CHAR:
                                i = ((ReturnValuesChar) ex).value - (int)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                i = ((ReturnValuesInt) ex).value - (int)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), i);
                        return new ReturnValuesInt(i);
                    case DOUBLE:
                        if (ex.getType().uType == UnannType.BOOLEAN)
                            throw new Exception("Cannot assign boolean to double variable");
                        double d;
                        switch (ex.getType().uType) {
                            case CHAR:
                                d = ((ReturnValuesChar) ex).value  - (double)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                d = ((ReturnValuesInt) ex).value  - (double)c.namesToValues.get(id.getName());
                                break;
                            case DOUBLE:
                                d = ((ReturnValuesDouble) ex).value  - (double)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), d);
                        return new ReturnValuesDouble(d);
                    default:
                        throw new Exception("Cannot use -= on variable of type boolean");
                }
            case TIMESEQ:
                switch (current.getType().uType) {
                    case CHAR:
                        if (ex.getType().uType != UnannType.CHAR)
                            throw new Exception("Cannot assign anything but a char value to a char variable");
                        char ch = (char)(((ReturnValuesChar) ex).value * ((char)c.namesToValues.get(id.getName())));
                        c.namesToValues.put(id.getName(), ch);
                        return new ReturnValuesChar(ch);
                    case INT:
                        if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                            throw new Exception("Can only assign char or int to int variable");
                        int i;
                        switch (ex.getType().uType) {
                            case CHAR:
                                i = ((ReturnValuesChar) ex).value * (int)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                i = ((ReturnValuesInt) ex).value * (int)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), i);
                        return new ReturnValuesInt(i);
                    case DOUBLE:
                        if (ex.getType().uType == UnannType.BOOLEAN)
                            throw new Exception("Cannot assign boolean to double variable");
                        double d;
                        switch (ex.getType().uType) {
                            case CHAR:
                                d = ((ReturnValuesChar) ex).value  * (double)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                d = ((ReturnValuesInt) ex).value  * (double)c.namesToValues.get(id.getName());
                                break;
                            case DOUBLE:
                                d = ((ReturnValuesDouble) ex).value  * (double)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), d);
                        return new ReturnValuesDouble(d);
                    default:
                        throw new Exception("Cannot use *= on variable of type boolean");
                }
            default: // DIVEQ
                switch (current.getType().uType) {
                    case CHAR:
                        if (ex.getType().uType != UnannType.CHAR)
                            throw new Exception("Cannot assign anything but a char value to a char variable");
                        char ch = (char)(((ReturnValuesChar) ex).value / ((char)c.namesToValues.get(id.getName())));
                        c.namesToValues.put(id.getName(), ch);
                        return new ReturnValuesChar(ch);
                    case INT:
                        if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                            throw new Exception("Can only assign char or int to int variable");
                        int i;
                        switch (ex.getType().uType) {
                            case CHAR:
                                i = ((ReturnValuesChar) ex).value / (int)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                i = ((ReturnValuesInt) ex).value / (int)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), i);
                        return new ReturnValuesInt(i);
                    case DOUBLE:
                        if (ex.getType().uType == UnannType.BOOLEAN)
                            throw new Exception("Cannot assign boolean to double variable");
                        double d;
                        switch (ex.getType().uType) {
                            case CHAR:
                                d = ((ReturnValuesChar) ex).value  / (double)c.namesToValues.get(id.getName());
                                break;
                            case INT:
                                d = ((ReturnValuesInt) ex).value  / (double)c.namesToValues.get(id.getName());
                                break;
                            case DOUBLE:
                                d = ((ReturnValuesDouble) ex).value  / (double)c.namesToValues.get(id.getName());
                                break;
                            default:
                                throw new Exception("You shouldn't be here!");
                        }
                        c.namesToValues.put(id.getName(), d);
                        return new ReturnValuesDouble(d);
                    default:
                        throw new Exception("Cannot use /= on variable of type boolean");
                }

        }
    }
}
