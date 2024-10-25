package SAD.Flipper.Printer;

public class PrinterFactory {

    StarWarsPrinterFactory swPF;
    ShadowPrinterFactory shPF;

    public PrinterFactory() {
        swPF = new StarWarsPrinterFactory();
        shPF = new ShadowPrinterFactory();
    }

    public Printer create(String type) {

        switch (PrinterType.valueOf(type)) {
            case PrinterType.StarWars:
                return swPF.create();
            case PrinterType.Shadow:
                return shPF.create();
        }

        return swPF.create();
    }
}
