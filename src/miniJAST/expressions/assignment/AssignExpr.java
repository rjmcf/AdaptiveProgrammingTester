package miniJAST.expressions.assignment;

import miniJAST.Context;
import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.ReturnValues;
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

        Id id = ((Id)lhs);
        ReturnValues current = id.evaluate(c);
        ReturnValues ex = expr.evaluate(c);

        if (UnannType.canBeAssigned(id.getType(), expr.getType())) {
            type = id.getType();
            switch (op) {
                case EQ:
                    c.namesToValues.put(id.getName(), ex.objectVal(expr.getType()));
                    return null;
                case PLUSEQ:
                    if (type == UnannType.BOOLEAN)
                        throw new Exception("Cannot use += on type boolean");
                    else c.namesToValues.put(id.getName(), plusEq(current, type, ex, expr.getType()));
                    return null;
                default:
                    throw new Exception("Only = and += are yet implemented");
            }
        } else
            throw new Exception(expr.getType() + " cannot be assigned to a variable of type " + id.getType() +".");
    }

    private Object plusEq(ReturnValues l, UnannType lt, ReturnValues r, UnannType rt) throws Exception{
        switch (lt) {
            case BYTE:
                switch (rt) {
                    case BYTE:
                        return l.byteVal + r.byteVal;
                    case CHAR:
                        return l.byteVal + r.cVal;
                    case SHORT:
                        return l.byteVal + r.sVal;
                    case INT:
                        return l.byteVal + r.iVal;
                    case LONG:
                        return l.byteVal + r.lVal;
                    case FLOAT:
                        return l.byteVal + r.fVal;
                    case DOUBLE:
                        return l.byteVal + r.dVal;
                }
                break;
            case CHAR:
                switch (rt) {
                    case CHAR:
                        return l.cVal + r.cVal;
                    case SHORT:
                        return l.cVal + r.sVal;
                    case INT:
                        return l.cVal + r.iVal;
                    case LONG:
                        return l.cVal + r.lVal;
                    case FLOAT:
                        return l.cVal + r.fVal;
                    case DOUBLE:
                        return l.cVal + r.dVal;
                }
                break;
            case SHORT:
                switch (rt) {
                    case SHORT:
                        return l.sVal + r.sVal;
                    case INT:
                        return l.sVal + r.iVal;
                    case LONG:
                        return l.sVal + r.lVal;
                    case FLOAT:
                        return l.sVal + r.fVal;
                    case DOUBLE:
                        return l.sVal + r.dVal;
                }
                break;
            case INT:
                switch(rt) {
                    case INT:
                        return l.iVal + r.iVal;
                    case LONG:
                        return l.iVal + r.lVal;
                    case FLOAT:
                        return l.iVal + r.fVal;
                    case DOUBLE:
                        return l.iVal + r.dVal;
                }
                break;
            case LONG:
                switch (rt) {
                    case LONG:
                        return l.lVal + r.lVal;
                    case FLOAT:
                        return l.lVal + r.fVal;
                    case DOUBLE:
                        return l.lVal + r.fVal;
                }
                break;
            case FLOAT:
                switch (rt) {
                    case FLOAT:
                        return l.fVal + r.fVal;
                    case DOUBLE:
                        return l.fVal + r.dVal;
                }
                break;
            case DOUBLE:
                switch (rt) {
                    case DOUBLE:
                        return l.dVal + r.dVal;
                }
                break;
            default:
                throw new Exception("LHS type was not one of possible UnannTypes.");
        }
        throw new Exception("RHS type was not one of possible UnannTypes");
    }
}
