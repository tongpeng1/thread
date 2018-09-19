package cn.com.thread.util;

public class BusyFlagUtil {

    protected Thread busyFalg = null;
    protected int busyCount = 0;
    //等待同步锁被释放
    public synchronized void  getBusyFlag(){
        if(tryGetBusyFlag() == false){
            try {
                wait();
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

    public synchronized void freeBusyFlag(){
        if(getBusyFlagOwner() == Thread.currentThread()){
            busyCount--;
            if(busyCount == 0){
                busyFalg = null;
                notify();
            }
        }
    }

    //获取当前线程对象
    public synchronized Thread getBusyFlagOwner(){
        return busyFalg;
    }

    public static void main(String args[]){
        BusyFlagUtil busyFlagUtil = new BusyFlagUtil();
        //System.out.println(busyFlagUtil.tryGetBusyFlag());
        System.out.println(busyFlagUtil.getBusyFlagOwner());
    }
}
