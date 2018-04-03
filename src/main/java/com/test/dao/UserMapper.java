package com.test.dao;
import com.test.bean.User;

import java.util.List;

public interface UserMapper {
    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;
    public List<User> findUserByName(User user) throws Exception;
}
