package com.gy.thread;

import static com.gy.thread.Test.*;
import static com.gy.thread.Test.lock;

/**
 * Created by hello on 2018/4/21.
 */
public class ConditionProducer extends Thread {
    @Override
    public void run(){
        produce();
    }

    private void produce(){
        try{
            lock.lock();
            while(true){
                    while (queue.size()==queueSize){
                        System.out.println("队列已满，等待消费");
                        try {
                            notEmpty.signal();
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Thread.sleep(1000L);
                    queue.offer(1);
                    System.out.println("入队，当前剩余"+queue.size());
                }
            }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
