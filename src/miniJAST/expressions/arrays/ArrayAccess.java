package miniJAST.expressions.arrays;

import miniJAST.expressions.Expression;
import miniJAST.expressions.Id;
import miniJAST.expressions.PrimaryExpr;
import miniJAST.expressions.assignment.AssignLHS;

public class ArrayAccess extends PrimaryExpr implements AssignLHS {
    private Id id;
    private Expression index;


}
