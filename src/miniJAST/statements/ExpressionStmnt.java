package miniJAST.statements;

import miniJAST.Context;
import miniJAST.exceptions.MiniJASTException;
import miniJAST.expressions.returnValues.ReturnValues;

public interface ExpressionStmnt extends StmntNoTrailSubstmnt{
    ReturnValues evaluate(Context c) throws MiniJASTException;
}
