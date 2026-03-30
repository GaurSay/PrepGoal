package Multithreading;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.concurrent.*;
import java.util.*;

public class ThreadPool {

    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final List<Worker> workers = new ArrayList<>();
    private volatile boolean isShutdown = false;


    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(3);
        pool.submit(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
        pool.submit(() -> System.out.println("Another task executed by " + Thread.currentThread().getName()));
        pool.shutdown();
    }


    public ThreadPool(int numThreads) {
        for (int i = 0; i < numThreads; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker, "Worker-" + i).start();
        }
    }

    public void submit(Runnable task) {
        if (!isShutdown) {
            taskQueue.offer(task);
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (Worker worker : workers) {
            worker.stop();
        }
    }

    private class Worker implements Runnable {
        private volatile boolean running = true;

        public void run() {
            while (running) {
                try {
                    Runnable task = taskQueue.poll(100, TimeUnit.MILLISECONDS);
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt
                            ();
                }
            }
        }

        public void stop() {
            running = false;
        }
    }

}

// For demonstration