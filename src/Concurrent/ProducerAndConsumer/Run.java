package Concurrent.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用阻塞队列实现生产者消费者线程
 */
public class Run {

    private static final BlockingQueue<String> queue  = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        for (int i = 0 ; i < 5 ; i ++){

            new Thread(p , "producer" + (i + 1)).start();

            new Thread(c , "consumer" + (i + 1)).start();
        }
    }
}
