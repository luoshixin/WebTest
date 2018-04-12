package com.test.dao;

import com.test.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("com.test.bean.User.findUserById", 1);
        //这里不用关闭，当方法执行完了之后由Spring来关闭
        //sqlSession.close();
        return user;
    }

    public void updateUserNameById(User user) throws Exception {
        SqlSession sqlSession = getSqlSession();
        sqlSession.update("com.test.bean.User.updateUserNameById", user);
    }
}
