package LowLevelDesign.Notification_system;

public class NotificationWorker implements Runnable {

    private final NotificationDispatcher dispatcher;

    public NotificationWorker(NotificationDispatcher dispatcher) {

        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {

        while (true) {

            try {

                Notification notification = dispatcher.take();

                RetryExecutor.execute(notification);

                System.out.println(notification.getStatus());

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
