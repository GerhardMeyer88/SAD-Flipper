package SAD.Flipper.Printer;

public class SubZeroPrinterFactory implements IPrinterFactory {
    @Override
    public Printer create() {
        return new StarWarsPrinter(PrinterType.SubZero);
    }
}
