package com.test.mapper;

import com.test.bean.Orders;

import java.util.List;

public interface OrdersMapper {
    public List<Orders> findOrdersUser() throws Exception;
}
