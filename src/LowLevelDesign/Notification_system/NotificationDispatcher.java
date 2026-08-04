package LowLevelDesign.Notification_system;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationDispatcher {

    private final BlockingQueue<Notification> queue =
            new LinkedBlockingQueue<>();

    private final ExecutorService executor =
            Executors.newFixedThreadPool(10);

    public void submit(Notification notification) {
        queue.offer(notification);
    }

    public Notification take() throws InterruptedException {
        return queue.take();
    }

    //better approach than threads waiting on
    public void start() {

        new Thread(() -> {

            while (true) {

                try {

                    Notification notification = queue.take();

                    executor.submit(() ->
                            RetryExecutor.execute(notification));

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

            }

        }).start();
    }

}
