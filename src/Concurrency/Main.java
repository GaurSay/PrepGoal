package Concurrency;

public class Main {
    public static void main(String[] args) {
        State state = State.builder().nextToPrint(PrintType.ODD).build();

        Printer oddPrinter = Printer.builder().currValue(1).state(state).maxValue(10).step(2).currPrintType(PrintType.ODD)
                .nextToPrintType(PrintType.EVEN).build();

        Printer evenPrinter = Printer.builder().currValue(2).state(state).maxValue(10).step(2).currPrintType(PrintType.EVEN)
                .nextToPrintType(PrintType.ODD).build();

        Thread oddThread = new Thread(oddPrinter);
        Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();

    }
}
