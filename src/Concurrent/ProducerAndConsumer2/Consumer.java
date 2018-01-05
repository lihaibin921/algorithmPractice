package Concurrent.ProducerAndConsumer2;

public class Consumer implements Runnable {

    private Service service;

    public Consumer(Service service) {
        this.service = service;
    }

    @Override
    public void run() {

            service.get();

    }

}
