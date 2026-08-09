package LowLevelDesign.JobScheduler;

public interface RetryPolicy {

    boolean shouldRetry(Job job);

    long nextDelay(Job job);
}
