package MultiThreading_questions.Semaphore;

import java.util.concurrent.Semaphore;

public class ABCSemaphore {

    private static final int TIMES = 10;

    public static void main(String[] args) {
        Semaphore ASemaphore = new Semaphore(1);
        Semaphore BSemaphore = new Semaphore(0);
        Semaphore CSemaphore = new Semaphore(0);

        Thread AThread = new Thread(() -> {
            for(int i=1;i<TIMES;i++){
                try {
                    ASemaphore.acquire();
                    System.out.print("A" + " ");
                    BSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"A thread");


        Thread BThread = new Thread(() -> {
            for(int i=1;i<TIMES;i++){
                try {
                    BSemaphore.acquire();
                    System.out.print("B" +" ");
                    CSemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"B thread");

        Thread CThread = new Thread(() -> {
            for(int i=1;i<TIMES;i++){
                try {
                    CSemaphore.acquire();
                    System.out.print("C" +" ");
                    ASemaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"C thread");



        AThread.start();
        BThread.start();
        CThread.start();

    }
}
