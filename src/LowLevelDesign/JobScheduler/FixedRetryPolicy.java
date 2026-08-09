package LowLevelDesign.JobScheduler;

public class FixedRetryPolicy implements RetryPolicy {

    private final int maxRetries;

    private final long retryDelayMillis;

    public FixedRetryPolicy(int maxRetries,
                            long retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public boolean shouldRetry(Job job) {
        return job.getRetryCount() < maxRetries;
    }

    @Override
    public long nextDelay(Job job) {
        return retryDelayMillis;
    }
}
