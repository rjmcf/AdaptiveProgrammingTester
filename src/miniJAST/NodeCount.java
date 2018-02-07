package miniJAST;

public class NodeCount {
    public int filled;
    public int empty;

    public NodeCount() { filled = 0; empty = 0; }
    public NodeCount(int f, int e) { filled = f; empty = e; }
    public void add(NodeCount other) {
        filled += other.filled;
        empty += other.empty;
    }
}
