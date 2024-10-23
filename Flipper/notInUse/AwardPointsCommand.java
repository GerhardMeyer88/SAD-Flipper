package SAD.Flipper.notInUse;

import SAD.Flipper.Command;

public class AwardPointsCommand implements Command {
    private int points;

    public AwardPointsCommand(int points) {
        this.points = points;
    }

    @Override
    public void execute() {
        System.out.println("Hole getroffen! Punkte: " + points);
        //Punkte Logik folgt hier
    }
}