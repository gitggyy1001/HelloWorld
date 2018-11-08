package com.gy.thread;

/**
 * Created by hello on 2018/4/21.
 */

import static com.gy.thread.Test.*;


public class ConditionConsumer extends Thread {
    @Override
    public void run(){
        comsume();
    }

    private void comsume(){
        try{
            lock.lock();
            while(true){
                    while (queue.size()==0){
                        System.out.println("队列为空，等待生产者放入");
                        try {
                            notFull.signal();
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Thread.sleep(1000L);
                    queue.poll();
                    System.out.println("出队，当前剩余"+queue.size());
                }
            }catch (Exception e){
                e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
