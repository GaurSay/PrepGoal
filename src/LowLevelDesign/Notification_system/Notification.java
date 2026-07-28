package LowLevelDesign.Notification_system;

import LowLevelDesign.Notification_system.Enum.ChannelType;
import LowLevelDesign.Notification_system.Enum.NotificationType;
import LowLevelDesign.Notification_system.Enum.Priority;
import LowLevelDesign.Notification_system.Enum.Status;
import lombok.Data;

import java.util.UUID;

@Data
public class Notification {

    private final String id;
    private final String userId;
    private final String message;

    private final ChannelType channelType;
    private final Priority priority;
    private final NotificationType type;

    private Status status;

    public Notification(String userId,
                        String message,
                        ChannelType channelType,
                        Priority priority,
                        NotificationType type) {

        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.message = message;
        this.channelType = channelType;
        this.priority = priority;
        this.type = type;
        this.status = Status.PENDING;
    }
};
