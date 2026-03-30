package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class multithread {
    public static void main(String[] args) {

        Task t1 = new Task("task1");
        Task t2 = new Task("task2");
        Task t3 = new Task("task3");
        Task t4 = new Task("task4");
        Task t5 = new Task("task5");


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);
        executorService.shutdown();

    }

    private static void printnum(int x) {

        for(int i=x;i<x+10;i++){
            System.out.println(i+""+Thread.currentThread().getName());
        }
        System.out.println();
    }


}

class Task implements Runnable{
    String name;

    public Task(String name){
        this.name= name;
    }


    @Override
    public void run() {
        System.out.println("Starting  "+ name +" " + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed task "+ name +" " + Thread.currentThread().getName());
    }
}
