package SAD.Flipper;

import java.util.Scanner;

public class CountdownInputEvent {

    public static void letterGame() {
        Scanner scanner = new Scanner(System.in);
        String[] letters = {"f", "l", "i", "p", "p", "e", "r"};
        int score = 100;
        int index = 0;

        System.out.println("Der Pinball verschwindet im Hole!");
        System.out.println("Ein Countdown-Event hat begonnen!");
        System.out.println("Du hast zwei Sekunden pro Eingabe.");

        while (index < letters.length) {
            String lastLetter = letters[index];
            System.out.println("Tippe mir nach, bevor die Zeit abläuft: " + lastLetter + " ");

            long startTime = System.currentTimeMillis();
            String input = FlipperInput.readInput(scanner);
            long endTime = System.currentTimeMillis();

            if (input.equals(lastLetter) && endTime - startTime <= 2000) {
                System.out.println("Gut gemacht!");
                ScoreManager.addScore(score);
            } else {
                System.out.println("Das war wohl nix!");
            }
            index++;
        }
    }
}
