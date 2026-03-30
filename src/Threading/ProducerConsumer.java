package Threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Item> blockingQueue = new ArrayBlockingQueue<>(10);

        //Producer
        final Runnable producer = () -> {
            while(true){
                try {
                    blockingQueue.put(createItem());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();


        //Consumer
        final Runnable consumer = () -> {
            while(true){
                Item i = blockingQueue.poll();
                process(i);
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();


    }

    private static void process(Item i) {
    }

    private static Item createItem() {
       return new Item();
    }
}
