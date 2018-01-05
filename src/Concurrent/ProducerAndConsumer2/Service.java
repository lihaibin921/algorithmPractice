package Concurrent.ProducerAndConsumer2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁机制 和 单例模式设计简单货架
 */
public class Service {

    //代表货架上商品数量
    private int value;

    private Lock lock = new ReentrantLock();

    //唤醒生产者
    private Condition condition = lock.newCondition();

    //唤醒消费者
    private Condition condition2 = lock.newCondition();

    private Service() {
        this.value = 0;
    }

    private static class shevles {
        private static Service service = new Service();
    }

    public static Service newInstance() {
        return shevles.service;
    }

    public void set() {
        try {
            lock.lock();
            if (value < 10) {
                value++;
                System.out.println("生产者 " +  Thread.currentThread().getName() + " 生产一个产品 " + value);
                condition2.signalAll();
            } else {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            if(value > 0){
                value --;
                System.out.println("消费者 " + Thread.currentThread().getName() + " 消费一个产品" + value);
                condition.signalAll();
            }else{
                condition2.await();
            }
        }catch (InterruptedException e ){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
