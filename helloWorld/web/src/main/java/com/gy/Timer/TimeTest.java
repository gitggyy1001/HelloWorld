package com.gy.Timer;



import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hello on 2018/4/23.
 */
public class TimeTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        myTask1 t1 = new myTask1();
        myTask2 t2 = new myTask2();
        timer.schedule(t1,1000L,2000L);
        timer.schedule(t2,1000L,2000L);

    }

    static class myTask1 extends TimerTask {
        @Override
        public void run() {
            System.out.println("myTask1-Begin");
            try {
                Thread.sleep(12000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("myTask1-End");
        }
    }

    static class myTask2 extends TimerTask {
        @Override
        public void run() {
            System.out.println("myTask2-Begin");
            try {
                Thread.sleep(12000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("myTask2-End");
        }
    }



}
