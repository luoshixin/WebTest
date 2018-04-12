package com.test.com.test.service;

import com.test.bean.User;

public interface UserService {
    public User findUserById(int id) throws Exception;
    public void updateUserNameById(User user) throws Exception;
}
