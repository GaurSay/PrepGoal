package LowLevelDesign.Notification_system;

public class SmsChannel implements Channel {

    @Override
    public void send(Notification notification) {

        System.out.println("SMS sent : " + notification.getMessage());
    }
}
