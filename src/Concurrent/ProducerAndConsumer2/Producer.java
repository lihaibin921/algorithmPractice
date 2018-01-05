package Concurrent.ProducerAndConsumer2;

public class Producer implements Runnable{

    private Service service;

    public Producer(Service service) {
        this.service = service;
    }

    @Override
    public void run() {

            service.set();

    }
}
