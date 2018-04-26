package com.test.service;

import com.test.bean.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    public List<User> findUserList() throws Exception;
}
