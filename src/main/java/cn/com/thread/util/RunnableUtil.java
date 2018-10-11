package cn.com.thread.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableUtil implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(RunnableUtil.class);

    public int index;
    ProductSynUtil productSynUtil;

    public RunnableUtil(int index){
        this.index = index;
    }

    public RunnableUtil(ProductSynUtil productSynUtil, int index){
        this.productSynUtil = productSynUtil;
        this.index = index;
    }

    @Override
    public void run() {
        logger.info("线程："+index);
        //System.out.println("线程："+index);
    }
}
