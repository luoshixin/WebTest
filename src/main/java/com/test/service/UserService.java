package com.test.service;

import com.test.bean.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    public List<User> findUserList() throws Exception;
    public User findUserById(Integer id) throws Exception;
//    public void updateUserBatch(Integer[] ids) throws Exception;
}
