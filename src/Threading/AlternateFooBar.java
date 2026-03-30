package Threading;

import java.util.concurrent.Semaphore;

public class AlternateFooBar {

    public static void main(String[] args) {

        Semaphore fooSemaphore = new Semaphore(1);
        Semaphore barSemaphore = new Semaphore(0);

        new Thread(()-> {
            for (int i=0;i<10;i++){
//            while (true) {
                try {
                    fooSemaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Foo printed by " + Thread.currentThread().getName());
                barSemaphore.release();

            }
        }).start();


        new Thread(()-> {
            for (int i=0;i<10;i++){
//            while (true) {
                try {
                    barSemaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Bar printed by " + Thread.currentThread().getName());
                fooSemaphore.release();
            }
        }).start();






    }
}
