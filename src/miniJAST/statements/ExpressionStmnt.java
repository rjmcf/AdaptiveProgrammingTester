package miniJAST.statements;

import miniJAST.Context;
import miniJAST.expressions.returnValues.ReturnValues;

public interface ExpressionStmnt extends StmntNoTrailSubstmnt{
    ReturnValues evaluate(Context c) throws Exception;
}
