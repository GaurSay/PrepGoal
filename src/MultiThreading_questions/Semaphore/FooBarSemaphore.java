package MultiThreading_questions.Semaphore;

import java.util.concurrent.Semaphore;

public class FooBarSemaphore {

    private static final int TIMES = 10;

    public static void main(String[] args) {
        Semaphore fooSemaphore = new Semaphore(1);
        Semaphore barSemaphore = new Semaphore(0);

        Thread fooThread = new Thread(() -> {
            for(int i=1;i<TIMES;i++){
                try {
                    fooSemaphore.acquire();
                    System.out.println("Foo");
                    barSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Foo thread");

        fooThread.start();
        Thread barThread = new Thread(() -> {
            for(int i=1;i<TIMES;i++){
                try {
                    barSemaphore.acquire();
                    System.out.println("Bar");
                    fooSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        },"Bar thread");

        barThread.start();

    }
}
