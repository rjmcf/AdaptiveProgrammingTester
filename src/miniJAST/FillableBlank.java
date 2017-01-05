package miniJAST;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class FillableBlank {
    private static AtomicInteger nextId = new AtomicInteger(0);
    private int id;

    public int getId() { return id; }
    public FillableBlank() { id = nextId.incrementAndGet(); }
    public boolean fillBlank(int blankId, MiniJASTNode replacement) {
        return false;
    }
}
