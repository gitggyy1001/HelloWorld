package com.gy.zk.distributedSharedLock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hello on 2018/9/26.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            executorService.execute(new Runner(cyclicBarrier, "张三"));
            executorService.execute(new Runner(cyclicBarrier, "李四"));
            Thread.sleep(5000);
            executorService.execute(new Runner(cyclicBarrier, "王五"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    static class Runner implements Runnable{
        private String name;
        private CyclicBarrier cyclicBarrier;
        public Runner(CyclicBarrier cyclicBarrier,String name) {
            this.name = name;
            this.cyclicBarrier=cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000*new Random().nextInt(5));
                System.out.println(Thread.currentThread().getName() +"已经准备好");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +"出发！！");
        }

    }
}

