package com.ssm.cas.service;

import com.ssm.cas.domain.Orders;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/24 20:09
 **/
public interface OrdersService {
    List<Orders> findAll(int page, int pageSize) throws Exception;

    Orders findById(String id) throws Exception;
}
