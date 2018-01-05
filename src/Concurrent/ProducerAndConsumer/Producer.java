package Concurrent.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String product = "生产者 " + Thread.currentThread().getName() + " 的产品";

            System.out.println("老子生产了一件产品 嘿嘿 " + Thread.currentThread().getName());

            queue.put(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

