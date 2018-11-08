package com.gy.thread;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hello on 2018/4/21.
 */
public class Test {
    public  static final int queueSize = 10;
    public  static PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    public static Lock lock = new ReentrantLock();
    public static Condition notFull = lock.newCondition();
    public static Condition notEmpty = lock.newCondition();



    public static void main(String[] args) {
        Test test = new Test();

//        Consumer consumer = new Consumer();
//        Producer producer = new Producer();
//        producer.start();
//        consumer.start();

        ConditionConsumer consumer = new ConditionConsumer();
        ConditionProducer producer = new ConditionProducer();
        producer.start();
        consumer.start();
    }

}
