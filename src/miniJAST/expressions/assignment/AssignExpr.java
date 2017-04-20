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
import miniJAST.types.Type;

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
            if (!arac.checkDefined(c)) {
                throw new VariableNotInitException(arac.getName());
            }
            Type arType = arac.getArType();
            int index = arac.evaluateIndex(c).value;
            ReturnValues ex = subNodes.get(expr).evaluate(c);

            switch (op) {
                case EQ:
                    switch (arType.pType) {
                        case BOOLEAN:
                            if (ex.getPType() != PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBool) ex).value;
                            ArrayList<Boolean> bs = (ArrayList<Boolean>)c.namesToValues.peek().get(arac.getName());
                            bs.set(index, b);
                            c.namesToValues.peek().put(arac.getName(), bs);
                            return new ReturnValuesBool(b);
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(arac.getName());
                            chs.set(index, ch);
                            c.namesToValues.peek().put(arac.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getPType()) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(arac.getName());
                            is.set(index, i);
                            c.namesToValues.peek().put(arac.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getPType()) {
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
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(arac.getName());
                            ds.set(index, d);
                            c.namesToValues.peek().put(arac.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case PLUSEQ:
                    switch (arType.pType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use += on Boolean");
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(arac.getName());
                            char cVal = chs.get(index);
                            char ch = (char)(((ReturnValuesChar) ex).value + cVal);
                            chs.set(index, ch);
                            c.namesToValues.peek().put(arac.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(arac.getName());
                            int iVal = is.get(index);
                            int i;
                            switch (ex.getPType()) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value + iVal;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value + iVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            is.set(index, i);
                            c.namesToValues.peek().put(arac.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(arac.getName());
                            double dVal = ds.get(index);
                            double d;
                            switch (ex.getPType()) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value + dVal;
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value + dVal;
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value + dVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ds.set(index, d);
                            c.namesToValues.peek().put(arac.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case SUBEQ:
                    switch (arType.pType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use += on Boolean");
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(arac.getName());
                            char cVal = chs.get(index);
                            char ch = (char)(((ReturnValuesChar) ex).value - cVal);
                            chs.set(index, ch);
                            c.namesToValues.peek().put(arac.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(arac.getName());
                            int iVal = is.get(index);
                            int i;
                            switch (ex.getPType()) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value - iVal;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value - iVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            is.set(index, i);
                            c.namesToValues.peek().put(arac.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(arac.getName());
                            double dVal = ds.get(index);
                            double d;
                            switch (ex.getPType()) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value - dVal;
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value - dVal;
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value - dVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ds.set(index, d);
                            c.namesToValues.peek().put(arac.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                case TIMESEQ:
                    switch (arType.pType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use += on Boolean");
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(arac.getName());
                            char cVal = chs.get(index);
                            char ch = (char)(((ReturnValuesChar) ex).value * cVal);
                            chs.set(index, ch);
                            c.namesToValues.peek().put(arac.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(arac.getName());
                            int iVal = is.get(index);
                            int i;
                            switch (ex.getPType()) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value * iVal;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value * iVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            is.set(index, i);
                            c.namesToValues.peek().put(arac.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(arac.getName());
                            double dVal = ds.get(index);
                            double d;
                            switch (ex.getPType()) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value * dVal;
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value * dVal;
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value * dVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ds.set(index, d);
                            c.namesToValues.peek().put(arac.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
                default: // DIVEQ
                    switch (arType.pType) {
                        case BOOLEAN:
                            throw new TypeException("Cannot use += on Boolean");
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            ArrayList<Character> chs = (ArrayList<Character>)c.namesToValues.peek().get(arac.getName());
                            char cVal = chs.get(index);
                            char ch = (char)(((ReturnValuesChar) ex).value / cVal);
                            chs.set(index, ch);
                            c.namesToValues.peek().put(arac.getName(), chs);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            ArrayList<Integer> is = (ArrayList<Integer>)c.namesToValues.peek().get(arac.getName());
                            int iVal = is.get(index);
                            int i;
                            switch (ex.getPType()) {
                                case CHAR:
                                    i = ((ReturnValuesChar) ex).value / iVal;
                                    break;
                                case INT:
                                    i = ((ReturnValuesInt) ex).value / iVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            is.set(index, i);
                            c.namesToValues.peek().put(arac.getName(), is);
                            return new ReturnValuesInt(i);
                        default: // DOUBLE
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            ArrayList<Double> ds = (ArrayList<Double>)c.namesToValues.peek().get(arac.getName());
                            double dVal = ds.get(index);
                            double d;
                            switch (ex.getPType()) {
                                case CHAR:
                                    d = ((ReturnValuesChar) ex).value / dVal;
                                    break;
                                case INT:
                                    d = ((ReturnValuesInt) ex).value / dVal;
                                    break;
                                case DOUBLE:
                                    d = ((ReturnValuesDouble) ex).value / dVal;
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("You shouldn't be here!");
                            }
                            ds.set(index, d);
                            c.namesToValues.peek().put(arac.getName(), ds);
                            return new ReturnValuesDouble(d);
                    }
            }
        } else {
            Id id = (Id) lhs;
            boolean defined = id.checkDefined(c);

            if (id.getIsArray()) {
                if (op != AssignOp.EQ)
                    throw new TypeException("Can only use = assignment operator with arrays");
                if (subNodes.get(expr) instanceof ArrayInit)
                    throw new TypeException("Cannot use Array Initialiser in assign expression");
                ReturnValues rV = subNodes.get(expr).evaluate(c);
                if (!rV.getIsArray())
                    throw new TypeException("You must assign an array to an array variable");
                if (rV.getPType() != id.getType().pType)
                    throw new TypeException("The types of the arrays do not match");
                c.namesToTypes.peek().put(id.getName(), rV.getType());
                c.namesToValues.peek().put(id.getName(), ((ReturnValuesArray)rV).getArray());
                return rV;
            }

            ReturnValues ex = subNodes.get(expr).evaluate(c);

            switch (op) {
                case EQ:
                    switch (id.getType().pType) {
                        case BOOLEAN:
                            if (ex.getPType() != PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign anything but a boolean value to a boolean variable");
                            boolean b = ((ReturnValuesBool) ex).value;
                            c.namesToValues.peek().put(id.getName(), b);
                            return new ReturnValuesBool(b);
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = ((ReturnValuesChar) ex).value;
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getPType()) {
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
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getPType()) {
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
                    if (!defined)
                        throw new VariableNotInitException(id.getName());
                    switch (id.getType().pType) {
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value + ((char)c.namesToValues.peek().get(id.getName())));
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getPType()) {
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
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getPType()) {
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
                    if (!defined)
                        throw new VariableNotInitException(id.getName());
                    switch (id.getType().pType) {
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((char)c.namesToValues.peek().get(id.getName())) - ((ReturnValuesChar) ex).value);
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getPType()) {
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
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getPType()) {
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
                    if (!defined)
                        throw new VariableNotInitException(id.getName());
                    switch (id.getType().pType) {
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((ReturnValuesChar) ex).value * ((char)c.namesToValues.peek().get(id.getName())));
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getPType()) {
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
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getPType()) {
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
                    if (!defined)
                        throw new VariableNotInitException(id.getName());
                    switch (id.getType().pType) {
                        case CHAR:
                            if (ex.getPType() != PrimType.CHAR)
                                throw new TypeException("Cannot assign anything but a char value to a char variable");
                            char ch = (char)(((char)c.namesToValues.peek().get(id.getName())) / ((ReturnValuesChar) ex).value);
                            c.namesToValues.peek().put(id.getName(), ch);
                            return new ReturnValuesChar(ch);
                        case INT:
                            if (ex.getPType() == PrimType.BOOLEAN || ex.getPType() == PrimType.DOUBLE)
                                throw new TypeException("Can only assign char or int to int variable");
                            int i;
                            switch (ex.getPType()) {
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
                            if (ex.getPType() == PrimType.BOOLEAN)
                                throw new TypeException("Cannot assign boolean to double variable");
                            double d;
                            switch (ex.getPType()) {
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
