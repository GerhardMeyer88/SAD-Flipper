package SAD.Flipper;

public class Bumper implements CommandElement {
    private int score = 100;

    @Override
    public void execute() {
        System.out.println("Bumper getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
