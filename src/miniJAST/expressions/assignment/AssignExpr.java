package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.StatementExpr;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class AssignExpr extends Expression implements StatementExpr {
    private AssignLHS lhs;
    private AssignOp op;
    private Expression expr;

    @Override
    public ReturnValues evaluate(Context c) throws Exception {
        if (lhs instanceof ArrayAccess) {
            ArrayAccess arac = (ArrayAccess) lhs;
            ReturnValuesArrayAccess access = (ReturnValuesArrayAccess)arac.evaluate(c);
            ReturnValues ex = expr.evaluate(c);

            switch (op) {
                case EQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            if (ex.getType().uType != UnannType.BOOLEAN)
                                throw new Exception("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBoolean) ex).value;
                            ArrayList<Boolean> bs = (ArrayList<Boolean>)c.namesToValues.get(access.name);
                            bs.set(access.index, (boolean)access.value);
                            c.namesToValues.put(access.name, bs);
                            return new ReturnValuesBoolean(b);
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new Exception("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(access.name);
                            chs.set(access.index, (char)access.value);
                            c.namesToValues.put(access.name, chs);
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
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(access.name);
                            is.set(access.index, (int)access.value);
                            c.namesToValues.put(access.name, is);
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
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(access.name);
                            ds.set(access.index, (double)access.value);
                            c.namesToValues.put(access.name, ds);
                            return new ReturnValuesDouble(d);
                    }
                case PLUSEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new Exception("Cannot use += on Boolean");
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new Exception("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value + (char)access.value);
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(access.name);
                            chs.set(access.index, (char)access.value);
                            c.namesToValues.put(access.name, chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new Exception("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value + (int)access.value;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value + (int)access.value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(access.name);
                            is.set(access.index, (int)access.value);
                            c.namesToValues.put(access.name, is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new Exception("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value + (double)access.value;
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value + (double)access.value;
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value + (double)access.value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(access.name);
                            ds.set(access.index, (double)access.value);
                            c.namesToValues.put(access.name, ds);
                            return new ReturnValuesDouble(d);
                    }
                case SUBEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new Exception("Cannot use -= on Boolean");
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new Exception("Cannot assign anything but a char value to a char variable");
                            char ch = (char)((char)access.value - ((ReturnValuesChar) ex).value);
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(access.name);
                            chs.set(access.index, (char)access.value);
                            c.namesToValues.put(access.name, chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new Exception("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)access.value - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)access.value - ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(access.name);
                            is.set(access.index, (int)access.value);
                            c.namesToValues.put(access.name, is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new Exception("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = (double)access.value - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)access.value - ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)access.value - ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(access.name);
                            ds.set(access.index, (double)access.value);
                            c.namesToValues.put(access.name, ds);
                            return new ReturnValuesDouble(d);
                    }
                case TIMESEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new Exception("Cannot use -= on Boolean");
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new Exception("Cannot assign anything but a char value to a char variable");
                            char ch = (char)((char)access.value * ((ReturnValuesChar) ex).value);
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(access.name);
                            chs.set(access.index, (char)access.value);
                            c.namesToValues.put(access.name, chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new Exception("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)access.value * ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)access.value * ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(access.name);
                            is.set(access.index, (int)access.value);
                            c.namesToValues.put(access.name, is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new Exception("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = (double)access.value * ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)access.value * ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)access.value * ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(access.name);
                            ds.set(access.index, (double)access.value);
                            c.namesToValues.put(access.name, ds);
                            return new ReturnValuesDouble(d);
                    }
                default: // DIVEQ
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new Exception("Cannot use -= on Boolean");
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new Exception("Cannot assign anything but a char value to a char variable");
                            char ch = (char)((char)access.value / ((ReturnValuesChar) ex).value);
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(access.name);
                            chs.set(access.index, (char)access.value);
                            c.namesToValues.put(access.name, chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new Exception("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)access.value / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)access.value / ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(access.name);
                            is.set(access.index, (int)access.value);
                            c.namesToValues.put(access.name, is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new Exception("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = (double)access.value / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)access.value / ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)access.value / ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new Exception("You shouldn't be here!");
                            }
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(access.name);
                            ds.set(access.index, (double)access.value);
                            c.namesToValues.put(access.name, ds);
                            return new ReturnValuesDouble(d);
                    }
            }
        } else {
            Id id = (Id) lhs;
            ReturnValues current = id.evaluate(c);
            ReturnValues ex = expr.evaluate(c);

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
                            char ch = (char)(((char)c.namesToValues.get(id.getName())) - ((ReturnValuesChar) ex).value);
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new Exception("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)c.namesToValues.get(id.getName()) - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)c.namesToValues.get(id.getName()) - ((ReturnValuesInt) ex).value;
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
                                    d = (double)c.namesToValues.get(id.getName()) - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)c.namesToValues.get(id.getName()) - ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)c.namesToValues.get(id.getName()) - ((ReturnValuesDouble) ex).value;
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
                            char ch = (char)(((char)c.namesToValues.get(id.getName())) / ((ReturnValuesChar) ex).value);
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new Exception("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)c.namesToValues.get(id.getName()) / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)c.namesToValues.get(id.getName()) / ((ReturnValuesInt) ex).value;
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
                                    d = (double)c.namesToValues.get(id.getName()) / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)c.namesToValues.get(id.getName()) / ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)c.namesToValues.get(id.getName()) / ((ReturnValuesDouble) ex).value;
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
}
