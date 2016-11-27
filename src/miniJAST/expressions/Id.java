package miniJAST.expressions;

import miniJAST.expressions.assignment.AssignLHS;
import miniJAST.types.UnannType;

public class Id extends GroundExpr implements AssignLHS{
    private UnannType type;
    private int dims; // Allows array types;
    private String name;
}
