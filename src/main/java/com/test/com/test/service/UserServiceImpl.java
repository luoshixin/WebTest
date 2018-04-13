package com.test.com.test.service;

import com.test.bean.User;
import com.test.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public User findUserById(int id) throws Exception {
        return userMapper.findUserById(id);
    }

    public void updateUserNameById(User user) throws Exception {
        userMapper.updateUserNameById(user);
    }

}
