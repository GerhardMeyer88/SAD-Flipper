package SAD.Flipper;

public class ScoreManager {

    private static int totalScore = 0;

    public static void addScore(int score) {
        totalScore += score;
        System.out.println("Total-Score: " + totalScore);
    }

    public static int getTotalScore() {
        return totalScore;
    }

    public static void resetScore() {
        totalScore = 0;
    }
}
