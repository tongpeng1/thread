package cn.com.thread.util;

public class BusyFlagUtil {

    protected Thread busyFalg = null;
    protected int busyCount = 0;
    //等待锁被释放
    public void getBusyFlag(){
        while(tryGetBusyFlag() == false){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean tryGetBusyFlag(){
        if(busyFalg == null){
            //返回对当前正在执行的线程对象的引用
            busyFalg = Thread.currentThread();
            busyCount = 1;
            return true;
        }
        if(busyFalg == Thread.currentThread()){
            busyCount++;
            return true;
        }
        return false;
    }
    //获取当前线程对象
    public synchronized Thread getBusyFlagOwner(){
        return busyFalg;
    }

}
