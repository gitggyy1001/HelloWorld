package com.gy.thread;

import static com.gy.thread.Test.queue;
import static com.gy.thread.Test.queueSize;

/**
 * Created by hello on 2018/4/21.
 */
public class Producer extends Thread {
    @Override
    public void run(){
        poduce();
    }

    private void poduce(){
        while(true){
            synchronized (queue){
                while (queue.size()==queueSize){
                    System.out.println("队列已满，等待消费");
                    try {
                        queue.notify();
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.offer(1);
                System.out.println("入队，当前剩余"+queue.size());
            }
        }
    }
}
