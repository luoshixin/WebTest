package com.test.mapper;

import com.test.bean.Orders;
import com.test.bean.User;

import java.util.List;

public interface OrdersMapper {
    public void updateUserName(User user) throws Exception;
    public User findUserById(int id) throws Exception;
    public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
