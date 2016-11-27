package miniJAST;

import miniJAST.types.UnannType;

import java.util.HashMap;

public class Context {
    public HashMap<String, UnannType> namesToTypes;
    public HashMap<String, Object> namesToValues;
}
