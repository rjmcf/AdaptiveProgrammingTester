import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String t = "miniJAST.expressions.assignment.AssignExpr cannot be cast to miniJAST.statements.BlockStatement";
        Pattern p = Pattern.compile(".*\\.(.*) cannot be cast to .*\\.(.*)");
        Matcher m = p.matcher(t);
        if (m.matches()) {
            System.out.println(m.group(2));
        } else {
            System.out.println("No match");
        }
    }
}