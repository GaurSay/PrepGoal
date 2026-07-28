package LowLevelDesign.Notification_system;

import LowLevelDesign.Notification_system.Enum.Status;

public class RetryExecutor {

    private static final int MAX_RETRY = 3;


    public static void execute(Notification notification) {

        Channel channel = ChannelFactory.getChannel(notification.getChannelType());

        int retry = 0;

        while (retry < MAX_RETRY) {

            try {

                notification.setStatus(Status.PROCESSING);

                channel.send(notification);

                notification.setStatus(Status.SENT);

                return;

            } catch (Exception e) {

                retry++;

                System.out.println("Retry : " + retry);
            }
        }

        notification.setStatus(Status.FAILED);
    }
}
