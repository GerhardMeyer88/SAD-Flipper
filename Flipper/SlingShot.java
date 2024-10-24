package SAD.Flipper;

public class SlingShot implements Command {
    private int score = 200;

    @Override
    public void execute() {
        System.out.println("Slingshot getroffen: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}