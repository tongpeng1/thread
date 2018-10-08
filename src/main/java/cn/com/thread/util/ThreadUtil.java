package cn.com.thread.util;

public class ThreadUtil extends Thread {

    ProductSynUtil productSynUtil;
    String productId ;
    int number = 0;

    public ThreadUtil(ProductSynUtil productSynUtil, int number, String productId){
        this.productSynUtil = productSynUtil;
        this.number = number;
        this.productId = productId;
    }

    public void run(){
        productSynUtil.buyGoods(number,productId);
    }
}
