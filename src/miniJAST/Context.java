package miniJAST;

import miniJAST.types.Type;

import java.util.HashMap;
import java.util.Stack;

public class Context {
    public Stack<HashMap<String, Type>> namesToTypes;
    public Stack<HashMap<String, Object>> namesToValues;

    public Context() {
        namesToTypes = new Stack<>();
        namesToTypes.push(new HashMap<>());
        namesToValues = new Stack<>();
        namesToValues.push(new HashMap<>());
    }
}
