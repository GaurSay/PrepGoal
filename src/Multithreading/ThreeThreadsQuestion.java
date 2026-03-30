package Multithreading;

public class ThreeThreadsQuestion implements Runnable{

    private static final int MAX = 10;
    private static int counter = 1;
    private int threadId;
    private static final Object lock = new Object();

    public ThreeThreadsQuestion(int threadId) {
        this.threadId = threadId;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreeThreadsQuestion(1));
        Thread t2 = new Thread(new ThreeThreadsQuestion(2));
        Thread t3 = new Thread(new ThreeThreadsQuestion(3));
           t1.start();
           t2.start();
           t3.start();

    }
    //1-1,4,7
    //2-2,5,8
    //3-3,6,9
    @Override
    public void run() {
        while (counter <= MAX) {
            synchronized (lock) {
                while (counter <= MAX && (counter - 1) % 3 != threadId - 1) {
                    try {
                        lock.wait();  // Wait for its turn
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (counter <= MAX) {
                    System.out.println("T" + threadId + " " + counter);
                    counter++;
                    lock.notifyAll();  // Notify waiting threads
                }
            }
        }
    }
}
