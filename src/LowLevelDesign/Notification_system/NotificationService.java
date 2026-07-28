package LowLevelDesign.Notification_system;

public class NotificationService {

        private final NotificationDispatcher dispatcher;

        public NotificationService(NotificationDispatcher dispatcher) {

            this.dispatcher = dispatcher;
        }

        public void send(Notification notification) {

            dispatcher.submit(notification);
        }
}
