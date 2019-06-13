package com.ssm.cas.dao;

import com.ssm.cas.domain.Member;
import com.ssm.cas.domain.Orders;
import com.ssm.cas.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/24 19:16
 **/
@Repository
public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    javaType = Product.class,
                    one = @One(select =
                            "com.ssm.cas.dao.ProductDao.findById"))
            })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.ssm.cas.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "com.ssm.cas.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = List.class,
                    many = @Many(select = "com.ssm.cas.dao.TravellerDao.findByOrdersId"))

    })
    Orders findById(String ordersId) throws Exception;
}
