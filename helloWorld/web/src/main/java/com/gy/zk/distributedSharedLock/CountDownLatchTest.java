package com.gy.zk.distributedSharedLock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hello on 2018/9/26.
 */
public class CountDownLatchTest {

        private static final int N = 2;

        public static void main(String[] args) throws InterruptedException {
            CountDownLatch doneSignal = new CountDownLatch(N);
            for (int i = 0; i < N; ++i) // create and start threads
            {
                new Thread(new Worker(doneSignal,i)).start();
            }
            System.out.println("main is waiting....");
            doneSignal.await();
            doSomethingElse(); // don't let run yet
        }

        private static void doSomethingElse() {
            System.out.println("main 我在做事情.....");
        }

        static class Worker implements Runnable {
            private CountDownLatch doneSignal;
            private int i;
            public Worker( CountDownLatch doneSignal,int i) {
                this.doneSignal = doneSignal;
                this.i=i;
            }
            public void run() {
                try {
                    doWork();
                } catch (Exception e) {

                } finally {
                    doneSignal.countDown();
                }
            }
            private void doWork() {
                System.out.println("child thread 开始工作....."+i);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
