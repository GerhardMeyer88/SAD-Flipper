package SAD.Flipper.Printer;

public class PrinterFactory {

    StarWarsPrinterFactory swPF;
    SubZeroPrinterFactory szPF;

    public PrinterFactory() {
        swPF = new StarWarsPrinterFactory();
        szPF = new SubZeroPrinterFactory();
    }

    public Printer create(String type) {

        switch (PrinterType.valueOf(type)) {
            case PrinterType.StarWars:
                return swPF.create();
            case PrinterType.SubZero:
                return szPF.create();
        }

        return swPF.create();
    }
}
