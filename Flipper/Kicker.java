package SAD.Flipper;

public class Kicker implements Command {
    private int score = 70;

    @Override
    public void execute() {
        System.out.println("Kicker getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
