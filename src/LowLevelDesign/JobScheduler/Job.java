package LowLevelDesign.JobScheduler;

import java.util.UUID;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public abstract class Job implements Delayed {

    private final String id;

    private long scheduledTime;

    private JobStatus status;

    private int retryCount;

    protected Job(long delayMillis) {

        this.id = UUID.randomUUID().toString();

        this.scheduledTime =
                System.currentTimeMillis() + delayMillis;

        this.status = JobStatus.NEW;
    }

    public abstract void execute();

    @Override
    public long getDelay(TimeUnit unit) {

        long diff =
                scheduledTime - System.currentTimeMillis();

        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {

        Job job = (Job) other;

        return Long.compare(
                this.scheduledTime,
                job.scheduledTime
        );
    }

    public void reschedule(long delayMillis) {

        this.scheduledTime =
                System.currentTimeMillis() + delayMillis;
    }

    public String getId() {
        return id;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void incrementRetryCount() {
        retryCount++;
    }
}
