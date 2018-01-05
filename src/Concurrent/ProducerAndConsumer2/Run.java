package Concurrent.ProducerAndConsumer2;

public class Run {

    public static void main(String[] args) {

        Service service = Service.newInstance();

        Producer p = new Producer(service);
        Consumer c = new Consumer(service);

        for (int i = 0 ; i < 10 ; i ++){

            new Thread(p, "生产者" + (i + 1)).start();

            new Thread(c , "消费者" + (i + 1)).start();

        }
    }

}
