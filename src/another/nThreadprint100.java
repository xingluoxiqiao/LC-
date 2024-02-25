package another;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class nThreadprint100 {
    private static final int MAX_NUMBER = 100;
    private static int currentNumber = 1;

    public static void main(String[] args) {
        int numberOfThreads = 5; // 你可以根据需要指定线程数

        Object lock = new Object();
        for (int i = 1; i <= numberOfThreads; i++) {
            Thread thread = new Thread(new PrintTask(lock, i, numberOfThreads));
            thread.start();
        }
    }

    static class PrintTask implements Runnable {
        private final Object lock;
        private final int threadId;
        private final int numberOfThreads;

        public PrintTask(Object lock, int threadId, int numberOfThreads) {
            this.lock = lock;
            this.threadId = threadId;
            this.numberOfThreads = numberOfThreads;
        }

        @Override
        public void run() {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    while (currentNumber % numberOfThreads != (threadId - 1)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if (currentNumber <= MAX_NUMBER) {
                        System.out.println("Thread " + threadId + ": " + currentNumber);
                        currentNumber++;
                    }

                    lock.notifyAll();
                }
            }
        }
    }

}
