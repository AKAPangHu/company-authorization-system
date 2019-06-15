package com.ssm.cas.service;

import com.ssm.cas.domain.Product;

import java.util.List;

/**
 * @author 胖虎
 * @date 2019-5-23
 */
public interface ProductService {

    /**
     * 返回所有商品的列表
     * @return 所有商品
     * @throws Exception
     * @param page
     * @param pageSize
     */
    List<Product> findAll(Integer page, Integer pageSize) throws Exception;


    /**
     * 储存商品
     * @param product
     */
    void save(Product product);

    void deleteByProductIds(List<String> productIds);
}
