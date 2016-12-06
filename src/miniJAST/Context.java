package miniJAST;

import miniJAST.types.Type;

import java.util.HashMap;

public class Context {
    public HashMap<String, Type> namesToTypes;
    public HashMap<String, Object> namesToValues;
}
