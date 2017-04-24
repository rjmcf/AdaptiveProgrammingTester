package miniJAST.statements.LVD;

import miniJAST.Context;
import miniJAST.MiniJASTNode;
import miniJAST.exceptions.*;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.Statement;
import miniJAST.statements.FillableBlankStmnt;
import miniJAST.statements.FlowControl;
import miniJAST.statements.StatementBase;
import miniJAST.types.Type;
import miniJAST.types.PrimType;

public class LocalVarDec extends StatementBase {
    protected PrimType type;

    public void setUpLVD(PrimType t) { subNodes.clear(); type = t; }
    public void addVarDec(Statement v) { subNodes.add(v); }

    @Override
    public String stringRepr(int blocksDeep) {
        String result = pad(blocksDeep) +  type.name + " ";
        boolean oneTime = true;
        for (MiniJASTNode v : subNodes) {
            if (oneTime)
                oneTime = false;
            else
                result += ", ";
            result += ((Statement) v).stringRepr(0);
        }
        result += ";";
        return result;
    }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        for (MiniJASTNode vB : subNodes) {
            checkType((Statement)vB, VarDeclarator.class);
            VarDeclarator v;
            try {
                if (vB instanceof FillableBlankStmnt) {
                    v = (VarDeclarator)((FillableBlankStmnt)vB).getStudentStmnt();
                } else {
                    v = (VarDeclarator)vB;
                }
            } catch (ClassCastException e) {
                throw new TypeException("VarDeclarator submitted to LVD must be of type VarDeclarator");
            }

            if (c.namesToTypes.peek().containsKey(v.getName()))
                throw new VariableDecException(v.getName(), true);

            if (type == null) {
                throw new TypeException("You didn't specify a type for the LVD!");
            }

            switch (type) {
                case BOOLEAN:
                    if (v.getHasExpr()) {
                        if (v.getIsArray()) {
                            ReturnValues rvBA = v.getExpr().evaluate(c);
                            if (rvBA.getPType() != type && rvBA.getPType() != null)
                                throw new TypeException("Can only initialise with Booleans.");
                            if (!rvBA.getIsArray())
                                throw new TypeException("Must be array.");
                            c.namesToTypes.peek().put(v.getName(), new Type(PrimType.BOOLEAN, rvBA.getIsArray()));
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesArray)rvBA).getArray());
                        } else {
                            ReturnValues rvB = v.getExpr().evaluate(c);
                            if (rvB.getPType() != type)
                                throw new TypeException("Can only initialise with Boolean.");
                            if (rvB.getIsArray())
                                throw new TypeException("Must not be array.");
                            c.namesToTypes.peek().put(v.getName(), rvB.getType());
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesBool)rvB).value);
                        }
                    } else {
                        c.namesToTypes.peek().put(v.getName(), v.getIsArray() ? new Type(type, true) : new Type(type, false));
                    }
                    break;
                case CHAR:
                    if (v.getHasExpr()) {
                        if (v.getIsArray()) {
                            ReturnValues rvCA = v.getExpr().evaluate(c);
                            if (rvCA.getPType() != type && rvCA.getPType() != null)
                                throw new TypeException("Can only initialise with Characters.");
                            if (!rvCA.getIsArray())
                                throw new TypeException("Must be array.");
                            c.namesToTypes.peek().put(v.getName(), new Type(PrimType.CHAR, rvCA.getIsArray()));
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesArray)rvCA).getArray());
                        } else {
                            ReturnValues rvC = v.getExpr().evaluate(c);
                            if (rvC.getPType() != type)
                                throw new TypeException("Can only initialise with Character.");
                            if (rvC.getIsArray())
                                throw new TypeException("Must not be array.");
                            c.namesToTypes.peek().put(v.getName(), rvC.getType());
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesChar)rvC).value);
                        }
                    } else {
                        c.namesToTypes.peek().put(v.getName(), v.getIsArray() ? new Type(type, true) : new Type(type, false));
                    }
                    break;
                case INT:
                    if (v.getHasExpr()) {
                        if (v.getIsArray()) {
                            ReturnValues rvIA = v.getExpr().evaluate(c);
                            if (rvIA.getPType() != type && rvIA.getPType() != null)
                                throw new TypeException("Can only initialise with Integers.");
                            if (!rvIA.getIsArray())
                                throw new TypeException("Must be array.");
                            c.namesToTypes.peek().put(v.getName(), new Type(PrimType.INT, rvIA.getIsArray()));
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesArray)rvIA).getArray());
                        } else {
                            ReturnValues rvI = v.getExpr().evaluate(c);
                            if (rvI.getPType() != type)
                                throw new TypeException("Can only initialise with Integer.");
                            if (rvI.getIsArray())
                                throw new TypeException("Must not be array.");
                            c.namesToTypes.peek().put(v.getName(), rvI.getType());
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesInt)rvI).value);
                        }
                    } else {
                        c.namesToTypes.peek().put(v.getName(), v.getIsArray() ? new Type(type, true) : new Type(type, false));
                    }
                    break;
                default: // DOUBLE
                    if (v.getHasExpr()) {
                        if (v.getIsArray()) {
                            ReturnValues rvDA = v.getExpr().evaluate(c);
                            if (rvDA.getPType() != type && rvDA.getPType() != null)
                                throw new TypeException("Can only initialise with Doubles.");
                            if (!rvDA.getIsArray())
                                throw new TypeException("Must be array.");
                            c.namesToTypes.peek().put(v.getName(), new Type(PrimType.DOUBLE, rvDA.getIsArray()));
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesArray)rvDA).getArray());
                        } else {
                            ReturnValues rvD = v.getExpr().evaluate(c);
                            if (rvD.getPType() != type)
                                throw new TypeException("Can only initialise with Double.");
                            if (rvD.getIsArray())
                                throw new TypeException("Must not be array.");
                            c.namesToTypes.peek().put(v.getName(), rvD.getType());
                            c.namesToValues.peek().put(v.getName(), ((ReturnValuesDouble)rvD).value);
                        }
                    } else {
                        c.namesToTypes.peek().put(v.getName(), v.getIsArray() ? new Type(type, true) : new Type(type, false));
                    }
            }
        }
        return FlowControl.NONE;
    }
}
