package miniJAST.statements;

import miniJAST.types.UnannType;

import java.util.ArrayList;

public class LocalVarDec implements BlockStatement {
    private boolean isFinal;
    private UnannType type;
    private int arrayDims;
    private ArrayList<VarDeclarator> vars;
}
