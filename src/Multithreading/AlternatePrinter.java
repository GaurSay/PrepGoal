package Multithreading;

public class AlternatePrinter {

    private final Object lock = new Object();

    private boolean numberTurn = true;

    public static void main(String[] args) {
        AlternatePrinter printer = new AlternatePrinter();

        Thread numberThread = new Thread(()-> printer.printNumbers());
        Thread albhabetThread = new Thread(printer::printLetters);
        albhabetThread.start();
        numberThread.start();

    }

    public void printNumbers() {
        for (int i = 1; i <= 26; i++) { // Adjust the range as needed
            synchronized (lock) {
                while (!numberTurn) {
                    try {
                        lock.wait(); // Wait until it's this thread's turn
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i + " ");
                numberTurn = false; // Pass the turn to the letter thread
                lock.notifyAll(); // Notify the waiting thread
            }
        }
    }


    public void printLetters() {
        for (char c = 'A'; c <= 'Z'; c++) { // Adjust the range as needed
            synchronized (lock) {
                while (numberTurn) {
                    try {
                        lock.wait(); // Wait until it's this thread's turn
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(c + " ");
                numberTurn = true; // Pass the turn to the number thread
                lock.notifyAll(); // Notify the waiting thread
            }
        }
    }



}
