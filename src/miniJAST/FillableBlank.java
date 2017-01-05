package miniJAST;

import java.util.concurrent.atomic.AtomicInteger;

public class FillableBlank {
    private static AtomicInteger nextId = new AtomicInteger(0);
    private int id;

    public int getId() { return id; }
    public FillableBlank() { id = nextId.incrementAndGet(); }
}
