package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.*;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class AssignExpr extends ExpressionBase implements StatementExpr {
    private int lhsI;
    private AssignOp op;
    private int expr;

    public void setUpAssignExpr(Expression l, AssignOp o, Expression e) {
        subNodes.clear();
        op = o; subNodes.add(l); subNodes.add(e);
        lhsI = 0; expr = 1;
    }

    @Override
    public String stringRepr() {
        String opS;
        switch (op) {
            case EQ:
                opS = " = ";
                break;
            case PLUSEQ:
                opS = " += ";
                break;
            case SUBEQ:
                opS = " -= ";
                break;
            case TIMESEQ:
                opS = " *= ";
                break;
            default: // DivEq
                opS = " /= ";
        }
        return subNodes.get(lhsI).stringRepr() + opS + subNodes.get(expr).stringRepr();
    }

    @Override
    public ReturnValues evaluate(Context c) throws MiniJASTException{
        checkType(subNodes.get(lhsI), AssignLHS.class);
        checkType(subNodes.get(expr), Expression.class);

        AssignLHS lhs = (AssignLHS)subNodes.get(lhsI);

        if (lhs instanceof ArrayAccess) {
            ArrayAccess arac = (ArrayAccess) lhs;
            ReturnValues access = arac.evaluate(c);
            ReturnValues ex = subNodes.get(expr).evaluate(c);

            switch (op) {
                case EQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            ReturnValuesBoolAA rbaa = (ReturnValuesBoolAA) access;
                            if (ex.getType().uType != UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBool) ex).value;
                            ArrayList<Boolean> bs = (ArrayList<Boolean>)c.namesToValues.get(rbaa.getName());
                            bs.set(rbaa.getIndex(), b);
                            c.namesToValues.put(rbaa.getName(), bs);
                            return new ReturnValuesBool(b);
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                            chs.set(rcaa.getIndex(), ch);
                            c.namesToValues.put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                            is.set(riaa.getIndex(), i);
                            c.namesToValues.put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
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
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                            ds.set(rdaa.getIndex(), d);
                            c.namesToValues.put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case PLUSEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use += on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value + rcaa.value);
                            if (!c.namesToValues.containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value + riaa.value;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value + riaa.value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value + rdaa.value;
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value + rdaa.value;
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value + rdaa.value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case SUBEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use -= on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(rcaa.value - ((ReturnValuesChar) ex).value);
                            if (!c.namesToValues.containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = riaa.value - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = riaa.value - ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = rdaa.value - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = rdaa.value - ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = rdaa.value - ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case TIMESEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use -= on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(rcaa.value * ((ReturnValuesChar) ex).value);
                            if (!c.namesToValues.containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = riaa.value * ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = riaa.value * ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = rdaa.value * ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = rdaa.value * ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = rdaa.value * ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                default: // DIVEQ
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use -= on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(rcaa.value / ((ReturnValuesChar) ex).value);
                            if (!c.namesToValues.containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = riaa.value / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = riaa.value / ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = rdaa.value / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = rdaa.value / ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = rdaa.value / ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            if (!c.namesToValues.containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
            }
        } else {
            Id id = (Id) lhs;
            ReturnValues ex = subNodes.get(expr).evaluate(c);

            switch (op) {
                case EQ:
                    switch (id.getType().uType) {
                        case BOOLEAN:
                            if (ex.getType().uType != UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBool) ex).value;
                            c.namesToValues.put(id.getName(), b);
                            return new ReturnValuesBool(b);
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
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
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                    }
                case PLUSEQ:
                    switch (id.getType().uType) {
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value + ((char)c.namesToValues.get(id.getName())));
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value + (int)c.namesToValues.get(id.getName());
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value + (int)c.namesToValues.get(id.getName());
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
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
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use += on variable of type boolean");
                    }
                case SUBEQ:
                    switch (id.getType().uType) {
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((char)c.namesToValues.get(id.getName())) - ((ReturnValuesChar) ex).value);
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)c.namesToValues.get(id.getName()) - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)c.namesToValues.get(id.getName()) - ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
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
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use -= on variable of type boolean");
                    }
                case TIMESEQ:
                    switch (id.getType().uType) {
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value * ((char)c.namesToValues.get(id.getName())));
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value * (int)c.namesToValues.get(id.getName());
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value * (int)c.namesToValues.get(id.getName());
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
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
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use *= on variable of type boolean");
                    }
                default: // DIVEQ
                    switch (id.getType().uType) {
                        case CHAR:
                            if (ex.getType().uType != UnannType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((char)c.namesToValues.get(id.getName())) / ((ReturnValuesChar) ex).value);
                            c.namesToValues.put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == UnannType.BOOLEAN || ex.getType().uType == UnannType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)c.namesToValues.get(id.getName()) / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)c.namesToValues.get(id.getName()) / ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
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
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use /= on variable of type boolean");
                    }
            }
        }
    }
}
