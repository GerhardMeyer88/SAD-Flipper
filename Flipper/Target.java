package SAD.Flipper;

public class Target {
    private boolean getHit;

    public void beHit() {
        getHit = true;
    }

    public void resetHit() {
        getHit = false;
    }

    public boolean isGetHit() {
        return getHit;
    }
}
