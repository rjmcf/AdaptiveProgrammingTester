package miniJAST.statements;

import miniJAST.types.Type;

import java.util.ArrayList;

public class LocalVarDec implements BlockStatement {
    protected Type type;
    private int size;
    private ArrayList<VarDeclarator> vars;
}
