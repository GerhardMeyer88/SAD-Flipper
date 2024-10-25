package SAD.Flipper.Printer;

public abstract class Printer {

    PrinterType printerType;

    Printer(PrinterType printerType) {
        this.printerType = printerType;
    }

    public PrinterType getPrinterType() {
        return printerType;
    }

    public abstract void printStartGame();
    public abstract void printStopGame();
    public abstract void printBonusGame();
    public abstract void printBallIn();
    public abstract void printBallOut();
    public abstract void printCoinInserted();
    public abstract void printAuthors();
    public abstract void printEvent();

}
