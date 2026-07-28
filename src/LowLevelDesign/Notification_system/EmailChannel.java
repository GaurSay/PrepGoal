package LowLevelDesign.Notification_system;

public class EmailChannel implements Channel {

    @Override
    public void send(Notification notification) {

        System.out.println("Email sent : " + notification.getMessage());
    }
}
