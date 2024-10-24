package SAD.Flipper;

public class Kicker implements CommandElement {
    private int score = 70;

    @Override
    public void execute() {
        System.out.println("Kicker getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
