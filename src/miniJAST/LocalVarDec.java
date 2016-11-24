package miniJAST;

import java.util.ArrayList;

public class LocalVarDec extends Statement {
    private boolean isFinal;
    private UnannType type;
    private int arrayDims;
    private ArrayList<VarDeclarator> vars;
}
