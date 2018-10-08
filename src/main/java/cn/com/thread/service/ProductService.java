package cn.com.thread.service;

import cn.com.thread.entity.Products;
import cn.com.thread.repository.ProductRepository;
import cn.com.thread.util.ProductSynUtil;
import cn.com.thread.util.ThreadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Products> getSelectAll(){

        List<Products> list = productRepository.findAll();
        return list;
    }

    public String bugGoods(int num,String productId){

        ProductSynUtil productSynUtil = new ProductSynUtil(productRepository);

        ThreadUtil t1 = new ThreadUtil(productSynUtil,num,productId);

        ThreadUtil t2 = new ThreadUtil(productSynUtil,num,productId);

        ThreadUtil t3 = new ThreadUtil(productSynUtil,num,productId);

        t1.start();
        t2.start();
        t3.start();

        return "";
    }
}
