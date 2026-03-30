package Multithreading;

public class OddEvenPrinterTask {

    private final Object lock = new Object();
    private volatile boolean isEvenTurn = false; // Start with odd numbers

    public static void main(String[] args) {
        OddEvenPrinterTask printer = new OddEvenPrinterTask();

        Thread oddThread = new Thread(() -> printer.printNumbers(false), "OddThread");
        Thread evenThread = new Thread(() -> printer.printNumbers(true), "EvenThread");

        oddThread.start();
        evenThread.start();
    }

    public void printNumbers(boolean isEven) {
        for (int i = isEven ? 2 : 1; i <= 30; i += 2) {
            synchronized (lock) {
                while (isEven != isEvenTurn) { // Ensure correct thread prints
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(i + " " + Thread.currentThread().getName());
                isEvenTurn = !isEvenTurn; // Toggle turn
                lock.notifyAll();
            }
        }
    }
}

