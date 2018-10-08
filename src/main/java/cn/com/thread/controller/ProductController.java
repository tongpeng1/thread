package cn.com.thread.controller;

import cn.com.thread.entity.Products;
import cn.com.thread.service.ProductService;
import cn.com.thread.util.ReturnMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 查询所有产品列表
     * @return
     */
    @RequestMapping("getSelectAll")
    public Map<String,Object> getSelectAll(){

        Map<String,Object> map= new HashMap();
        List<Products> list = productService.getSelectAll();

        if(list.size() > 0){
            map.put("dataList",list);
            map.put("message", ReturnMessageUtil.MESSAGE_SUCCESS);
            map.put("code",ReturnMessageUtil.MESSAGE_SUCCESS_CODE);
        }else{
            map.put("message", ReturnMessageUtil.MESSAGE_ERROR);
            map.put("code",ReturnMessageUtil.MESSAGE_ERROR_CODE);
        }
        return map;
    }

    /**
     *  购买商品
     * @param number 购买数量
     * @param productId 购买商品Id
     * @return
     */
    @RequestMapping("/buyGood")
    public String buyGood(@RequestParam int number, @RequestParam String productId){

        String message = productService.bugGoods(number,productId);

        return message;
    }
}
