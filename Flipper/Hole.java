package SAD.Flipper;

public class Hole implements CommandElement {
    private int score = 150;

    @Override
    public void execute() {
        System.out.println("Der Pinball verschwindet im Hole: " + score + " Punkte");
        ScoreManager.addScore(score);
    }
}
