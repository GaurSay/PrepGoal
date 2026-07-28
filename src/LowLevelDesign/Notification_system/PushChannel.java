package LowLevelDesign.Notification_system;

public class PushChannel implements Channel {

    @Override
    public void send(Notification notification) {

        System.out.println("Push sent : " + notification.getMessage());
    }
}
