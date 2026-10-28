package Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice implements Runnable , Callable<String> {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);



        for (int i = 0; i < 10; i++) {
            int taskId = i;

            executorService.submit(() -> {
                try {
                    System.out.println("Task: " + taskId);
                    // Business logic
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

    @Override
    public void run() {

    }

    @Override
    public String call() throws Exception {
        return null;
    }
}
