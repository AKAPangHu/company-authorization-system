package com.ssm.cas.dao;

import com.ssm.cas.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/6/12 22:39
 **/
@Repository
public interface ProductDao {

    @Select("select * from product where id=#{pid}")
    Product findById(String pid) throws Exception;

    /**
     * 查找所有商品
     * @return List<Product>
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * @param product
     */
    @Insert("INSERT INTO product(id, productNum, productName, departureCity, departureTime, productPrice, productDesc, open)" +
            "values(uuid(), #{productNum}, #{productName}, #{departureCity}, #{departureTime}, #{productPrice}, #{productDesc}, #{open})")
    void saveOne(Product product);

    @Delete("delete from product where id = {productId}")
    void deleteByProductId(String productId);
}
