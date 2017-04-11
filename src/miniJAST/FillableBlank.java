package miniJAST;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class FillableBlank {
    private static AtomicInteger nextId = new AtomicInteger(0);
    private int id;
    protected int nodesReplaced;

    public int getId() { return id; }
    public FillableBlank(int nReplaced) { id = nextId.incrementAndGet(); nodesReplaced = nReplaced; }
}
