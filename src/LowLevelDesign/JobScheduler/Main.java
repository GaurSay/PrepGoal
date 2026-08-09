package LowLevelDesign.JobScheduler;

public class Main {

    public static void main(String[] args) {

        JobScheduler scheduler =
                new JobScheduler(4);

        RetryPolicy retryPolicy =
                new FixedRetryPolicy(3, 5000);

        Thread schedulerThread =
                new Thread(
                        new Worker(
                                scheduler,
                                retryPolicy));

        schedulerThread.start();

        scheduler.schedule(
                new EmailJob(
                        "abc@gmail.com",
                        3000));

        scheduler.schedule(
                new ReportJob(
                        6000));
    }
}