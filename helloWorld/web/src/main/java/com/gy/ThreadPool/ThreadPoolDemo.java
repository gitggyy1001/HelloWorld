package com.gy.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by hello on 2018/9/28.
 */

public class ThreadPoolDemo {
    public static void main (String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable () {
                public void run () {
                    System.out.println(index);
                }
            });
        }
    }

}



