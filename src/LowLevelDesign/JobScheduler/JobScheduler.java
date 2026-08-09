package LowLevelDesign.JobScheduler;

import lombok.Getter;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {

    private final DelayQueue<Job> queue;

    @Getter
    private final ExecutorService executorService;

    public JobScheduler(int workers) {

        queue = new DelayQueue<>();

        executorService =
                Executors.newFixedThreadPool(workers);
    }

    public void schedule(Job job) {

        job.setStatus(JobStatus.SCHEDULED);

        queue.offer(job);
    }

    public Job take() throws InterruptedException {

        return queue.take();
    }

    public void shutdown() {

        executorService.shutdown();
    }
}