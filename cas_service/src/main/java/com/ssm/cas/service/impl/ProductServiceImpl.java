package com.ssm.cas.service.impl;

import com.ssm.cas.dao.ProductDao;
import com.ssm.cas.domain.Product;
import com.ssm.cas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.saveOne(product);
    }

    @Override
    public void deleteByProductIds(List<String> productIds) {
        for (String productId : productIds) {
            productDao.deleteByProductId(productId);
        }
    }
}
