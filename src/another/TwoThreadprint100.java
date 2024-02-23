package another;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//两个线程交替打印0-100
public class TwoThreadprint100 {

    static volatile int num=0;
    static Object lock=new Object();
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                2,
                10,
                TimeUnit.DAYS,
                new ArrayBlockingQueue<>(5)
        );
        threadPoolExecutor.submit(new Task1());
        threadPoolExecutor.submit(new Task2());
    }
    static class Task1 implements Runnable{
        @Override
        public void run() {
            while(num<100){
                synchronized (lock){
                    while(num%2==0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num++);
                    lock.notifyAll();
                }
            }

        }
    }
    static class Task2 implements Runnable{
        @Override
        public void run() {
            while(num<100){
                synchronized (lock){
                    while(num%2==1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num++);
                    lock.notifyAll();
                }
            }

        }
    }
}



