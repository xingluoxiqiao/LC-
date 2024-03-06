package another;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalExample {
        private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        public static void main(String[] args) {
            // 在主线程设置 ThreadLocal 变量
            threadLocal.set(42);
            // 启动两个新线程，它们会访问各自独立的 ThreadLocal 变量副本
            new HashMap<>();
            Thread thread1 = new Thread(() -> {
                threadLocal.set(100);
                System.out.println("Thread 1: " + threadLocal.get());
            });

            Thread thread2 = new Thread(() -> {
                System.out.println("Thread 2: " + threadLocal.get());
            });

            thread1.start();
            thread2.start();

            // 在主线程获取 ThreadLocal 变量
            System.out.println("Main Thread: " + threadLocal.get());
        }
    }
