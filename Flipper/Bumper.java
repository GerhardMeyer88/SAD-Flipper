package SAD.Flipper;

public class Bumper implements Command {
    private int score = 100;

    @Override
    public void execute() {
        System.out.println("Bumper getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
