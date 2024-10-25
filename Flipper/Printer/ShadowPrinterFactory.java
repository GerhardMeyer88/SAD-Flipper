package SAD.Flipper.Printer;

public class ShadowPrinterFactory implements IPrinterFactory {
    @Override
    public Printer create() {
        return new ShadowPrinter(PrinterType.Shadow);
    }
}
