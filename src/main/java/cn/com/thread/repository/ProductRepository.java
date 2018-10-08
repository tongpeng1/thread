package cn.com.thread.repository;

import cn.com.thread.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

    @Query(value = "select product_num from Products where product_id=?1")
    String findProductNumById(String productId);

    @Modifying
    @Transactional
    @Query(value = "update Products set product_num = ?2 where product_id = ?1")
    int updateProductNumById(String productId,String productNum);
}
