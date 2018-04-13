package com.test.dao;

import com.test.bean.User;

public interface UserMapper {
    public User findUserById(int id) throws Exception;
    public void updateUserNameById(User user) throws Exception;
}
