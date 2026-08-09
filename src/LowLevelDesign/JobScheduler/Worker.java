package LowLevelDesign.JobScheduler;

public class Worker implements Runnable {

    private final JobScheduler scheduler;

    private final RetryPolicy retryPolicy;

    public Worker(JobScheduler scheduler,
                  RetryPolicy retryPolicy) {

        this.scheduler = scheduler;
        this.retryPolicy = retryPolicy;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {

                Job job = scheduler.take();

                scheduler.getExecutorService()
                        .submit(new JobExecutor(
                                job,
                                scheduler,
                                retryPolicy));

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }
    }
}
