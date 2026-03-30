package LowLevelDesign.Rate_limiter.limiters;

import LowLevelDesign.Rate_limiter.SlidingWindowRL_question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest {

    public static void main(String[] args) throws InterruptedException {

        SlidingWindowRL_question limiter =
                new SlidingWindowRL_question(5, 3);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                boolean allowed = limiter.allow();
                System.out.println("Time : " + System.currentTimeMillis()/1000 + " " + Thread.currentThread().getName()
                        + " -> " + allowed);
            });
        }

        executor.shutdown();
    }
}
