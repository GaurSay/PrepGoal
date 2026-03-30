import Threading.EvenTask;
import Threading.OddTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        // submit the task for execution

        Thread oddThread = new Thread(new OddTask());
        oddThread.setName("odd Thread");
        Thread evenThread = new Thread(new EvenTask());
        evenThread.setName("Even Thread");
        oddThread.start();
        evenThread.start();


//        for(int i=0;i<100;i++){
//            service.execute(new Task());
//        }

        //curr thread
        System.out.println("Thread name : " + Thread.currentThread().getName());



    }
}