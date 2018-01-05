package Concurrent.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String produce = queue.take();

            System.out.println("消费者 " + Thread.currentThread().getName() + " 获取: " + produce);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
