package LowLevelDesign.Notification_system;

import LowLevelDesign.Notification_system.Enum.ChannelType;
import LowLevelDesign.Notification_system.Enum.NotificationType;
import LowLevelDesign.Notification_system.Enum.Priority;

public class Main {


//    How to Impress the Interviewer (Senior/Lead Level)
//
//    After implementing the above, discuss production-grade enhancements:
//
//    Priority Queues: Use separate BlockingQueues for HIGH and LOW priority so OTPs are processed before marketing messages.
//    Thread Pool: Replace a single worker thread with an ExecutorService to process notifications concurrently.
//    Rate Limiting: Prevent exceeding provider limits (e.g., SMS gateway TPS limits).
//    Idempotency: Include an idempotency key so duplicate requests don't send multiple notifications.
//    Dead Letter Queue (DLQ): Move permanently failed notifications to a DLQ after max retries for later inspection.
//    Provider Failover: If one email/SMS provider is down, automatically switch to a secondary provider.
//    Template Engine: Store templates with placeholders (e.g., "Hi {{name}}, your OTP is {{otp}}") instead of raw messages.
//    Persistence: Save notifications in a database so status (PENDING, SENT, FAILED) survives service restarts.
//    Scheduling: Support delayed notifications using a DelayQueue or scheduler.
//    Observability: Add metrics, structured logging, and tracing to monitor throughput, latency, retry rates, and failures.

    public static void main(String[] args) {

        NotificationDispatcher dispatcher =
                new NotificationDispatcher();

        NotificationService service =
                new NotificationService(dispatcher);

        Thread worker =
                new Thread(new NotificationWorker(dispatcher));

        worker.start();

        Notification n1 =
                new Notification(
                        "user1",
                        "OTP : 123456",
                        ChannelType.SMS,
                        Priority.HIGH,
                        NotificationType.TRANSACTIONAL
                );

        Notification n2 =
                new Notification(
                        "user2",
                        "Flat 50% OFF",
                        ChannelType.EMAIL,
                        Priority.LOW,
                        NotificationType.PROMOTIONAL
                );

        Notification n3 =
                new Notification(
                        "user3",
                        "Order Delivered",
                        ChannelType.PUSH,
                        Priority.HIGH,
                        NotificationType.TRANSACTIONAL
                );

        service.send(n1);
        service.send(n2);
        service.send(n3);
    }
}
