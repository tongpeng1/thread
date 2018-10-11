package cn.com.thread.test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String args[]){

        Date date1 = new Date();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(40);
        for (int i = 0; i < 1000000; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
        Date date2 = new Date();
        long diff = date2.getTime() - date1.getTime();
        System.out.println("时间："+diff);
    }

}
