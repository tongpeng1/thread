package cn.com.thread.util;

import cn.com.thread.repository.ProductRepository;

/**
 * 购买商品类
 */
public class ProductSynUtil  {
    int total ;
    ProductRepository productRepository;

    public ProductSynUtil(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    /**
     * 购买同步方法
     * @param number    购买数量
     */
    public synchronized void buyGoods(int number,String productId){
        try {
            Thread.sleep(100);
            total = Integer.parseInt(productRepository.findProductNumById(productId));
            total -= number;
            Thread.sleep(100);
            int count = productRepository.updateProductNumById(productId, String.valueOf(total));
            System.out.println(Thread.currentThread().getName()+"购买结束,数量为："+number+",剩余数量为："+total);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
