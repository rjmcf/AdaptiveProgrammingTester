package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.FillableBlank;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableNotInitException;
import miniJAST.expressions.*;
import miniJAST.expressions.arrays.ArrayInit;
import miniJAST.expressions.returnValues.*;
import miniJAST.expressions.arrays.ArrayAccess;
import miniJAST.types.PrimType;

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

        AssignLHS lhs;
        try {
            if (subNodes.get(lhsI) instanceof FillableBlank) {
                lhs = (AssignLHS)((FillableBlankExpr)subNodes.get(lhsI)).getStudentExpr();
            } else {
                lhs = (AssignLHS)subNodes.get(lhsI);
            }
        } catch (ClassCastException e) {
            throw new TypeException("Left hand side of assignment must be of type AssignLHS!");
        }

        if (lhs instanceof ArrayAccess) {
            ArrayAccess arac = (ArrayAccess) lhs;
            ReturnValues access = arac.evaluate(c);
            ReturnValues ex = subNodes.get(expr).evaluate(c);

            switch (op) {
                case EQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            ReturnValuesBoolAA rbaa = (ReturnValuesBoolAA) access;
                            if (ex.getType().uType != PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBool) ex).value;
                            ArrayList<Boolean> bs = (ArrayList<Boolean>)c.namesToValues.peek().get(rbaa.getName());
                            bs.set(rbaa.getIndex(), b);
                            c.namesToValues.peek().put(rbaa.getName(), bs);
                            return new ReturnValuesBool(b);
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(rcaa.getName());
                            chs.set(rcaa.getIndex(), ch);
                            c.namesToValues.peek().put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
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
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(riaa.getName());
                            is.set(riaa.getIndex(), i);
                            c.namesToValues.peek().put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN)
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
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(rdaa.getName());
                            ds.set(rdaa.getIndex(), d);
                            c.namesToValues.peek().put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case PLUSEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use += on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value + rcaa.value);
                            if (!c.namesToValues.peek().containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.peek().put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
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
                            if (!c.namesToValues.peek().containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.peek().put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN)
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
                            if (!c.namesToValues.peek().containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.peek().put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case SUBEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use -= on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(rcaa.value - ((ReturnValuesChar) ex).value);
                            if (!c.namesToValues.peek().containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.peek().put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
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
                            if (!c.namesToValues.peek().containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.peek().put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN)
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
                            if (!c.namesToValues.peek().containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.peek().put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case TIMESEQ:
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use -= on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(rcaa.value * ((ReturnValuesChar) ex).value);
                            if (!c.namesToValues.peek().containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.peek().put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
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
                            if (!c.namesToValues.peek().containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.peek().put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN)
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
                            if (!c.namesToValues.peek().containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.peek().put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                default: // DIVEQ
                    switch (access.getType().uType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use -= on Boolean");
                        case CHAR:
                            ReturnValuesCharAA rcaa = (ReturnValuesCharAA) access;
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(rcaa.value / ((ReturnValuesChar) ex).value);
                            if (!c.namesToValues.peek().containsKey(rcaa.getName()))
                                throw new VariableNotInitException(rcaa.getName());
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(rcaa.getName());
                            chs.set(rcaa.getIndex(), rcaa.value);
                            c.namesToValues.peek().put(rcaa.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            ReturnValuesIntAA riaa = (ReturnValuesIntAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
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
                            if (!c.namesToValues.peek().containsKey(riaa.getName()))
                                throw new VariableNotInitException(riaa.getName());
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(riaa.getName());
                            is.set(riaa.getIndex(), riaa.value);
                            c.namesToValues.peek().put(riaa.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            ReturnValuesDoubleAA rdaa = (ReturnValuesDoubleAA) access;
                            if (ex.getType().uType == PrimType.BOOLEAN)
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
                            if (!c.namesToValues.peek().containsKey(rdaa.getName()))
                                throw new VariableNotInitException(rdaa.getName());
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(rdaa.getName());
                            ds.set(rdaa.getIndex(), rdaa.value);
                            c.namesToValues.peek().put(rdaa.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
            }
        } else {
            Id id = (Id) lhs;
            try {
                id.evaluate(c);
            } catch (VariableNotInitException ve) {
                // don't care
            }


            if (id.getIsArray()) {
                if (op != AssignOp.EQ)
                    throw new TypeException("Can only use = assignment operator with arrays");
                if (subNodes.get(expr) instanceof ArrayInit)
                    throw new TypeException("Cannot use Array Initialiser in assign expression");
                ReturnValues rV = subNodes.get(expr).evaluate(c);
                if (!rV.getIsArray())
                    throw new TypeException("You must assign an array to an array variable");
                if (rV.getType().uType != id.getType().uType)
                    throw new TypeException("The types of the arrays do not match");
                c.namesToTypes.peek().put(id.getName(), rV.getType());
                c.namesToValues.peek().put(id.getName(), ((ReturnValuesArray)rV).getArray());
                return rV;
            }

            ReturnValues ex = subNodes.get(expr).evaluate(c);

            switch (op) {
                case EQ:
                    switch (c.namesToTypes.peek().get(id.getName()).uType) {
                        case BOOLEAN:
                            if (ex.getType().uType != PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBool) ex).value;
                            c.namesToValues.peek().put(id.getName(), b);
                            return new ReturnValuesBool(b);
                        case CHAR:
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
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
                            c.namesToValues.peek().put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getType().uType == PrimType.BOOLEAN)
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
                            c.namesToValues.peek().put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                    }
                case PLUSEQ:
                    switch (c.namesToTypes.peek().get(id.getName()).uType) {
                        case CHAR:
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value + ((char)c.namesToValues.peek().get(id.getName())));
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value + (int)c.namesToValues.peek().get(id.getName());
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value + (int)c.namesToValues.peek().get(id.getName());
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value  + (double)c.namesToValues.peek().get(id.getName());
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value  + (double)c.namesToValues.peek().get(id.getName());
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value  + (double)c.namesToValues.peek().get(id.getName());
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use += on variable of type boolean");
                    }
                case SUBEQ:
                    switch (c.namesToTypes.peek().get(id.getName()).uType) {
                        case CHAR:
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((char)c.namesToValues.peek().get(id.getName())) - ((ReturnValuesChar) ex).value);
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)c.namesToValues.peek().get(id.getName()) - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)c.namesToValues.peek().get(id.getName()) - ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = (double)c.namesToValues.peek().get(id.getName()) - ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)c.namesToValues.peek().get(id.getName()) - ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)c.namesToValues.peek().get(id.getName()) - ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use -= on variable of type boolean");
                    }
                case TIMESEQ:
                    switch (c.namesToTypes.peek().get(id.getName()).uType) {
                        case CHAR:
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value * ((char)c.namesToValues.peek().get(id.getName())));
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value * (int)c.namesToValues.peek().get(id.getName());
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value * (int)c.namesToValues.peek().get(id.getName());
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value  * (double)c.namesToValues.peek().get(id.getName());
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value  * (double)c.namesToValues.peek().get(id.getName());
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value  * (double)c.namesToValues.peek().get(id.getName());
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use *= on variable of type boolean");
                    }
                default: // DIVEQ
                    switch (c.namesToTypes.peek().get(id.getName()).uType) {
                        case CHAR:
                            if (ex.getType().uType != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((char)c.namesToValues.peek().get(id.getName())) / ((ReturnValuesChar) ex).value);
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getType().uType == PrimType.BOOLEAN || ex.getType().uType == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    i = (int)c.namesToValues.peek().get(id.getName()) / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = (int)c.namesToValues.peek().get(id.getName()) / ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), i);
                            return new ReturnValuesInt(i);
                        case DOUBLE:
                            if (ex.getType().uType == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getType().uType) {
                                case CHAR:
                                    d = (double)c.namesToValues.peek().get(id.getName()) / ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    d = (double)c.namesToValues.peek().get(id.getName()) / ((ReturnValuesInt) ex).value;
                                    break;
                                case DOUBLE:
                                    d = (double)c.namesToValues.peek().get(id.getName()) / ((ReturnValuesDouble) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            c.namesToValues.peek().put(id.getName(), d);
                            return new ReturnValuesDouble(d);
                        default:
                            throw new TypeException("Cannot use /= on variable of type boolean");
                    }
            }
        }
    }
}
