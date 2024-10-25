package SAD.Flipper.Printer;

public class StarWarsPrinterFactory implements IPrinterFactory {
    @Override
    public Printer create() {
        return new StarWarsPrinter(PrinterType.StarWars);
    }
}
