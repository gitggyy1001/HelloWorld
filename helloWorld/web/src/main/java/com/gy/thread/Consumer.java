package com.gy.thread;

import static com.gy.thread.Test.queue;

/**
 * Created by hello on 2018/4/21.
 */
public class Consumer extends Thread {
    @Override
    public void run(){
        consume();
    }

    private void consume(){
        while (true){
            synchronized (queue){
                while(queue.size()==0){
                    System.out.println("队列为空，等待生产者放入");
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
                queue.poll();
                System.out.println("出队，当前剩余"+queue.size());
            }
        }
    }
}
