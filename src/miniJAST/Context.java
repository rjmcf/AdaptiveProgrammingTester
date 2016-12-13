package miniJAST;

import miniJAST.types.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class Context {
    public HashMap<String, Type> namesToTypes;
    public HashMap<String, Object> namesToValues;

    public Context() {
        namesToTypes = new HashMap<>();
        namesToValues = new HashMap<>();
    }
}
