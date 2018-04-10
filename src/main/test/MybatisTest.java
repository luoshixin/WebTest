import com.test.bean.Orders;
import com.test.bean.User;
import com.test.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.ognl.enhance.OrderedReturn;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void test0() throws Exception {
        //第一次发起请求
        SqlSession sqlSession0 = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper0 = sqlSession0.getMapper(OrdersMapper.class);
        User user0 = ordersMapper0.findUserById(1);
        System.out.println("数据0：" + user0 + user0.getUsername());
        //当执行sqlSession的关闭操作之后，才会将sqlSession中的数据写入到二级缓存中（OrdersMapper的缓存区域）
        sqlSession0.close();


//        //第二次发起请求
//        SqlSession sqlSession1 = sqlSessionFactory.openSession();
//        OrdersMapper ordersMapper1 = sqlSession1.getMapper(OrdersMapper.class);
//        User user1 = new User();
//        user1.setId(1);
//        user1.setUsername("张三");
//        ordersMapper1.updateUserName(user1);
//        //清空一级缓存（sqlSession1中的HashMap）和 二级缓存（OrdersMapper的缓存区域）
//        //如果不清空，那么下面sqlSession2拿到的用户数据是sqlSession0拿到的用户数据（只是数据相同，POJO的对象不同）
//        sqlSession1.commit();
//        //当执行sqlSession的关闭操作之后，才会将sqlSession中的数据写入到二级缓存中（OrdersMapper的缓存区域）
//        sqlSession1.close();


        //第三次请求
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper2 = sqlSession2.getMapper(OrdersMapper.class);
        User user2 = ordersMapper2.findUserById(1);
        System.out.println("数据2：" + user2 + user2.getUsername());
        sqlSession2.close();
    }

    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

//第一次从数据库查询数据封装到对象，并将对象加入到一级缓存
        User user0 = ordersMapper.findUserById(1);
        System.out.println("数据0：" + user0 + user0.getUsername());
//更新用户
        User user1 = new User();
        user1.setUsername("张三");
        user1.setId(user0.getId());
        ordersMapper.updateUserName(user1);
//执行commit操作，清空一级缓存
        sqlSession.commit();

//一级缓存中没有id为1的用户信息，从新从数据库中查询并加入到一级缓存中
        User user2 = ordersMapper.findUserById(1);
        System.out.println("数据1：" + user2 + user2.getUsername());
        sqlSession.close();


    }

}
