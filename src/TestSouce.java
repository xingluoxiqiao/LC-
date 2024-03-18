//这个类用来看源码

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestSouce {
    public static void main(String[] args) {
        new ThreadPoolExecutor(
                1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()
        );

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        new ReentrantLock();
        new ThreadPoolExecutor(
                1, 1, 0L, TimeUnit.MILLISECONDS
                , new LinkedBlockingQueue<Runnable>()
        );





    }


}
