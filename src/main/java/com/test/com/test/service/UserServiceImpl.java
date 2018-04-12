package com.test.com.test.service;

import com.test.bean.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserById(int id) throws Exception {
        return userDao.findUserById(id);
    }

    public void updateUserNameById(User user) throws Exception {
        userDao.updateUserNameById(user);
    }

}
