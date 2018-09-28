package cn.com.thread.service;

import cn.com.thread.entity.Products;
import cn.com.thread.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Products> getSelectAll(){

        List<Products> list = productRepository.findAll();
        return list;
    }
}
