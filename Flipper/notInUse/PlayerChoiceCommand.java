package SAD.Flipper.notInUse;

import SAD.Flipper.Command;

public class PlayerChoiceCommand implements Command {
    private int correctPlayer;

    public PlayerChoiceCommand(int correctPlayer) {
        this.correctPlayer = correctPlayer;
    }

    @Override
    public void execute() {
        int chosenPlayer = (int) (Math.random() * 3) +1;
        System.out.println("Spieler " + chosenPlayer + " wurde gewählt.");

        if (chosenPlayer == correctPlayer) {
            System.out.println("Richtige Wahl! Bonuspunkte!!!");
            //Weitere Punkte Logik...
        }
    }
}
