package com.test.service;

import com.test.bean.User;
import com.test.bean.UserExample;
import com.test.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    public List<User> findUserList() throws Exception {
        UserExample userExample = new UserExample();
        userExample.setDistinct(true);
        List<User> userList = userMapper.selectByExample(userExample);
        return userList;
    }

    public User findUserById(Integer id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }



}
