package com.test.dao;
import com.test.bean.User;

public interface UserMapper {
    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;
}
