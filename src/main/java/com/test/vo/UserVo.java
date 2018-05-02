package com.test.vo;

import com.test.bean.User;
import sun.tools.jstat.Literal;

import java.util.List;
import java.util.Map;

public class UserVo {
    private List<User> userList;
    private Map<String, String[]> map;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
