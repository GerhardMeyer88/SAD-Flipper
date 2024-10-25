package SAD.Flipper.visitor;

import SAD.Flipper.FlipperElements.*;

public interface Visitor {
    public void visit(BumperLeft element);
    public void visit(BumperRight element);
    public void visit(Hole element);
    public void visit(Kicker element);
    public void visit(Ramp element);
    public void visit(SlingShot element);
}
