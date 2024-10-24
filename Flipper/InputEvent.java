package SAD.Flipper;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class InputEvent {

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

    public static void followArrowGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] directions = {"w", "s", "a", "d"};

        final int[] score = {0};

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int index = random.nextInt(directions.length);
                String newDirection = directions[index];

                System.out.println("\r" + newDirection);

                String input = FlipperInput.readInput(scanner);

                if (input.equals(newDirection)) {
                    score[0] += 100;
                    System.out.println("Richtig, weiter so!");
                    System.out.println("Score; " + score[0]);
                }
                else {
                    System.out.println("Daneben!");
                    System.out.println("Event vorbei!");
                    System.out.println("Dein Score; " + score[0]);
                    timer.cancel();
                }
            }
        }, 0, 2000);
    }
}
