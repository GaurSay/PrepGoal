package Threading;

import java.util.HashMap;

public class PrintNumbers {

    static volatile boolean odd = true;
    private static Object object = new Object();

    public static void main(String[] args) throws Exception{
        HashMap<String, String> map = new HashMap<>();

        // Two threads updating same HashMap (unsafe)
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put(Thread.currentThread().getName() + i, "value" + i);
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        t1.start();
        t2.start();






    }


    private void printEven(boolean even) throws InterruptedException {
        for(int i=0;i<50;i=i+2){
            while(even){
                object.wait();
            }

            System.out.println(i + "even thread " );
            even = !even;
            object.notify();
        }
    }

    private void printOdd(boolean odd) throws InterruptedException {

        for(int i=1;i<50;i=i+2){
            while(!odd){
                object.wait();
            }

            System.out.println(i + "odd thread " );
            odd = !odd;
            object.notify();
        }

    }
}
