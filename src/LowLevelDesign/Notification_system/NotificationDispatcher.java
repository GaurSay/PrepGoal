package LowLevelDesign.Notification_system;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationDispatcher {

    private final BlockingQueue<Notification> queue =
            new LinkedBlockingQueue<>();

    public void submit(Notification notification) {

        queue.offer(notification);
    }

    public Notification take() throws InterruptedException {

        return queue.take();
    }
}
