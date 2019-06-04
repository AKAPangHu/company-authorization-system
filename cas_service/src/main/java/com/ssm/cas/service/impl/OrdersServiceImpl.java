package com.ssm.cas.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.cas.dao.OrdersDao;
import com.ssm.cas.domain.Orders;
import com.ssm.cas.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/24 20:13
 **/

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    private final OrdersDao ordersDao;

    public OrdersServiceImpl(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }


    @Override
    public List<Orders> findAll(int page, int pageSize) throws Exception{
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
