package LowLevelDesign.JobScheduler;

public class JobExecutor implements Runnable {

    private final Job job;

    private final JobScheduler scheduler;

    private final RetryPolicy retryPolicy;

    public JobExecutor(Job job,
                       JobScheduler scheduler,
                       RetryPolicy retryPolicy) {

        this.job = job;
        this.scheduler = scheduler;
        this.retryPolicy = retryPolicy;
    }

    @Override
    public void run() {

        try {

            job.setStatus(JobStatus.RUNNING);

            job.execute();

            job.setStatus(JobStatus.SUCCESS);

        } catch (Exception e) {

            job.incrementRetryCount();

            if (retryPolicy.shouldRetry(job)) {

                job.reschedule(
                        retryPolicy.nextDelay(job));

                scheduler.schedule(job);

            } else {

                job.setStatus(JobStatus.FAILED);
            }
        }
    }
}
