package SAD.Flipper.visitor;

import SAD.Flipper.FlipperElements.*;

public class ResetVisitor implements Visitor {
    @Override
    public void visit(BumperLeft element) {
        element.reset();
    }

    @Override
    public void visit(BumperRight element) {
        element.reset();
    }

    @Override
    public void visit(Hole element) {
        element.reset();
    }

    @Override
    public void visit(Kicker element) {
        element.reset();
    }

    @Override
    public void visit(Ramp element) {
        element.reset();
    }

    @Override
    public void visit(SlingShot element) {
        element.reset();
    }
}