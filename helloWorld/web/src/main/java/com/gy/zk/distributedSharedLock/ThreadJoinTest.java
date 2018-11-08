package com.gy.zk.distributedSharedLock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hello on 2018/9/26.
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadJoinTest.Worker());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread 工作完成.....");
    }

    static class Worker implements Runnable {

        public Worker() {
        }

        public void run() {
            try {
                doWork();
            } catch (Exception e) {

            } finally {
                //doneSignal.countDown();
            }
        }
        private void doWork() {
            try {
                Thread.sleep(10000);
                System.out.println("child thread 工作完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
