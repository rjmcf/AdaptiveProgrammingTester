package miniJAST.statements.arrays;

import miniJAST.statements.VarDeclarator;

public abstract class ArrayCreation extends VarDeclarator{
    protected boolean hasInitList;

    public ArrayCreation() { isArray = true; }
    public boolean getHasInitList() { return hasInitList; }
}
