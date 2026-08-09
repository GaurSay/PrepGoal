package LowLevelDesign.Practice.notification_practice;

import LowLevelDesign.Notification_system.Notification;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationDispatcher {

    private final BlockingQueue<Notification> queue;

    private ExecutorService executorService;

    public NotificationDispatcher(){
        queue = new LinkedBlockingQueue<>();
        executorService = Executors.newFixedThreadPool(10);
    }

    public void send(Notification notification){
        queue.offer(notification);
    }

    public Notification take(Notification notification) throws InterruptedException {
        return queue.take();
    }


    public void start(){

        try{
            new Thread(()-> {
                while(true){
                    Notification n = queue.poll();
                    executorService.submit(()-> RetryExecutor.execute(n));

                }
            });
        }catch (Exception e){

        }

    }



}
