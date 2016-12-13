package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.IncorrectEvaluationException;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.exceptions.TypeException;
import miniJAST.exceptions.VariableScopeException;
import miniJAST.expressions.Expression;
import miniJAST.expressions.returnValues.*;
import miniJAST.statements.arrays.ArrayCreation;
import miniJAST.statements.arrays.ArrayCreationWithInitList;
import miniJAST.statements.arrays.ArrayCreationWithSize;
import miniJAST.types.Type;
import miniJAST.types.UnannType;

import java.util.ArrayList;

public class LocalVarDec implements BlockStatement {
    protected UnannType type;
    private ArrayList<VarDeclarator> vars;

    public LocalVarDec() { vars = new ArrayList<>(); }

    public void setUp(UnannType t) { type = t; }
    public void addVarDec(VarDeclarator v) { vars.add(v); }

    @Override
    public FlowControl execute(Context c) throws MiniJASTException {
        for (VarDeclarator v : vars) {
            if (c.namesToTypes.containsKey(v.getName()))
                throw new VariableScopeException(v.getName(), true);

            switch (type) {
                case BOOLEAN:
                    if (!v.isArray) {
                        if (v.getExpr() != null) {
                            ReturnValues rb = v.getExpr().evaluate(c);
                            if (rb.getType().uType != UnannType.BOOLEAN)
                                throw new TypeException("boolean variable can only be initialised with boolean value");
                            if (rb.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            c.namesToTypes.put(v.getName(), rb.getType());
                            c.namesToValues.put(v.getName(), ((ReturnValuesBool) rb).value);
                        } else {
                            c.namesToTypes.put(v.getName(), new Type(type, 1));
                        }
                    } else {
                        ArrayCreation ac = (ArrayCreation) v;
                        if (ac.getHasInitList()) {
                            ArrayCreationWithInitList acwil = (ArrayCreationWithInitList) ac;
                            ArrayList<Boolean> vals = new ArrayList<>();
                            for (Expression e : acwil.getValues()) {
                                ReturnValues r = e.evaluate(c);
                                if (r.getType().uType != UnannType.BOOLEAN)
                                    throw new TypeException("boolean array must be initialised with boolean values");
                                if (r.getIsArray())
                                    throw new TypeException("Can not operate on arrays!");
                                vals.add(((ReturnValuesBool)r).value);
                            }
                            c.namesToTypes.put(v.getName(), new Type(type, vals.size()));
                            c.namesToValues.put(v.getName(), vals);
                        } else {
                            ArrayCreationWithSize acws = (ArrayCreationWithSize) ac;
                            ReturnValues s = acws.getSize().evaluate(c);
                            if (s.getType().uType != UnannType.INT)
                                throw new TypeException("Size must be an integer");
                            if (s.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            int size = ((ReturnValuesInt)s).value;
                            c.namesToTypes.put(v.getName(), new Type(UnannType.BOOLEAN, size));
                            c.namesToValues.put(v.getName(), new ArrayList<>(size));
                        }
                    }
                    break;
                case CHAR:
                    if (!v.isArray) {
                        if (v.getExpr() != null) {
                            ReturnValues rc = v.getExpr().evaluate(c);
                            if (rc.getType().uType != UnannType.CHAR)
                                throw new TypeException("char variable can only be initialised with char value");
                            if (rc.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            c.namesToTypes.put(v.getName(), rc.getType());
                            c.namesToValues.put(v.getName(), ((ReturnValuesChar) rc).value);
                        } else {
                            c.namesToTypes.put(v.getName(), new Type(type, 1));
                        }
                    } else {
                        ArrayCreation ac = (ArrayCreation) v;
                        if (ac.getHasInitList()) {
                            ArrayCreationWithInitList acwil = (ArrayCreationWithInitList) ac;
                            ArrayList<Character> vals = new ArrayList<>();
                            for (Expression e : acwil.getValues()) {
                                ReturnValues r = e.evaluate(c);
                                if (r.getType().uType != UnannType.CHAR)
                                    throw new TypeException("char array must be initialised with char values");
                                if (r.getIsArray())
                                    throw new TypeException("Can not operate on arrays!");
                                vals.add(((ReturnValuesChar)r).value);
                            }
                            c.namesToTypes.put(v.getName(), new Type(type, vals.size()));
                            c.namesToValues.put(v.getName(), vals);
                        } else {
                            ArrayCreationWithSize acws = (ArrayCreationWithSize) ac;
                            ReturnValues s = acws.getSize().evaluate(c);
                            if (s.getType().uType != UnannType.INT)
                                throw new TypeException("Size must be an integer");
                            if (s.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            int size = ((ReturnValuesInt)s).value;
                            c.namesToTypes.put(v.getName(), new Type(UnannType.CHAR, size));
                            c.namesToValues.put(v.getName(), new ArrayList<>(size));
                        }
                    }
                    break;
                case INT:
                    if (!v.isArray) {
                        if (v.getExpr() != null) {
                            ReturnValues rc = v.getExpr().evaluate(c);
                            if (rc.getType().uType != UnannType.CHAR && rc.getType().uType != UnannType.INT)
                                throw new TypeException("int variable can only be initialised with char or int value");
                            if (rc.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            c.namesToTypes.put(v.getName(), rc.getType());
                            switch (rc.getType().uType) {
                                case CHAR:
                                    c.namesToValues.put(v.getName(), ((ReturnValuesChar)rc).value);
                                    break;
                                case INT:
                                    c.namesToValues.put(v.getName(), ((ReturnValuesInt)rc).value);
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("What are you doing here?");
                            }
                        } else {
                            c.namesToTypes.put(v.getName(), new Type(UnannType.INT, 1));
                        }
                    } else {
                        ArrayCreation ac = (ArrayCreation) v;
                        if (ac.getHasInitList()) {
                            ArrayCreationWithInitList acwil = (ArrayCreationWithInitList) ac;
                            ArrayList<Integer> vals = new ArrayList<>();
                            for (Expression e : acwil.getValues()) {
                                ReturnValues r = e.evaluate(c);
                                if (r.getType().uType != UnannType.INT)
                                    throw new TypeException("int array must be initialised with int values");
                                if (r.getIsArray())
                                    throw new TypeException("Can not operate on arrays!");
                                vals.add(((ReturnValuesInt)r).value);
                            }
                            c.namesToTypes.put(v.getName(), new Type(type, vals.size()));
                            c.namesToValues.put(v.getName(), vals);
                        } else {
                            ArrayCreationWithSize acws = (ArrayCreationWithSize) ac;
                            ReturnValues s = acws.getSize().evaluate(c);
                            if (s.getType().uType != UnannType.INT)
                                throw new TypeException("Size must be an integer");
                            if (s.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            int size = ((ReturnValuesInt)s).value;
                            c.namesToTypes.put(v.getName(), new Type(UnannType.INT, size));
                            c.namesToValues.put(v.getName(), new ArrayList<>(size));
                        }
                    }
                    break;
                default: // DOUBLE
                    if (!v.isArray) {
                        if (v.getExpr() != null) {
                            ReturnValues rc = v.getExpr().evaluate(c);
                            if (rc.getType().uType == UnannType.BOOLEAN)
                                throw new TypeException("double variable cannot be initialised with boolean value");
                            if (rc.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            c.namesToTypes.put(v.getName(), rc.getType());
                            switch (rc.getType().uType) {
                                case CHAR:
                                    c.namesToValues.put(v.getName(), ((ReturnValuesChar)rc).value);
                                    break;
                                case INT:
                                    c.namesToValues.put(v.getName(), ((ReturnValuesInt)rc).value);
                                    break;
                                case DOUBLE:
                                    c.namesToValues.put(v.getName(), ((ReturnValuesDouble)rc).value);
                                    break;
                                default:
                                    throw new IncorrectEvaluationException("What are you doing here?");
                            }
                        } else {
                            c.namesToTypes.put(v.getName(), new Type(UnannType.INT, 1));
                        }
                    } else {
                        ArrayCreation ac = (ArrayCreation) v;
                        if (ac.getHasInitList()) {
                            ArrayCreationWithInitList acwil = (ArrayCreationWithInitList) ac;
                            ArrayList<Double> vals = new ArrayList<>();
                            for (Expression e : acwil.getValues()) {
                                ReturnValues r = e.evaluate(c);
                                if (r.getType().uType != UnannType.DOUBLE)
                                    throw new TypeException("double array must be initialised with double values");
                                if (r.getIsArray())
                                    throw new TypeException("Can not operate on arrays!");
                                vals.add(((ReturnValuesDouble)r).value);
                            }
                            c.namesToTypes.put(v.getName(), new Type(type, vals.size()));
                            c.namesToValues.put(v.getName(), vals);
                        } else {
                            ArrayCreationWithSize acws = (ArrayCreationWithSize) ac;
                            ReturnValues s = acws.getSize().evaluate(c);
                            if (s.getType().uType != UnannType.INT)
                                throw new TypeException("Size must be an integer");
                            if (s.getIsArray())
                                throw new TypeException("Can not operate on arrays!");
                            int size = ((ReturnValuesInt)s).value;
                            c.namesToTypes.put(v.getName(), new Type(UnannType.DOUBLE, size));
                            c.namesToValues.put(v.getName(), new ArrayList<>(size));
                        }
                    }
                    break;
            }
        }

        return FlowControl.NONE;
    }
}
