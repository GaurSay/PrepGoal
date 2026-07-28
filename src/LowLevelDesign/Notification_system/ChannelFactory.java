package LowLevelDesign.Notification_system;

import LowLevelDesign.Notification_system.Enum.ChannelType;

public class ChannelFactory {

    public static Channel getChannel(ChannelType type) {

        switch (type) {

            case EMAIL:
                return new EmailChannel();

            case SMS:
                return new SmsChannel();

            case PUSH:
                return new PushChannel();

            default:
                throw new IllegalArgumentException();
        }
    }
}
