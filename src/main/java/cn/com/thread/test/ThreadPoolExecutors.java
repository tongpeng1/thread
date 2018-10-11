package cn.com.thread.test;

import cn.com.thread.util.RunnableUtil;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutors {

    private static ThreadPoolExecutor  executor = new ThreadPoolExecutor(40,64,0L, TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(999999));

    public static void main(String args[]){
        for(int i = 0; i < 900000; i++){
            int index = i;
            executor.execute(new RunnableUtil(index));
        }
        executor.shutdown();
    }


}
