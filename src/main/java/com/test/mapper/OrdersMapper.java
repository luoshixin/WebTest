package com.test.mapper;

import com.test.bean.Orders;
import com.test.bean.User;

import java.util.List;

public interface OrdersMapper {
    public List<Orders> findOrdersUserLazyLoading() throws Exception;
}