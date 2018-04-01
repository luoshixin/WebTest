import com.test.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void test0() throws IOException {
        // 获取mybatis的全局配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建会话工厂， 传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        User user = sqlSession.selectOne("test.findUserById", 4);
        System.out.println("查询结果：" + user);
        // 释放资源
        sqlSession.close();

    }

    @Test
    public void test1() throws IOException {
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
        // 获取会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 操作数据库
        User user = new User("赵大", "女", new Date(), "中国山东");
        sqlSession.insert("test.insertUser1", user);
        System.out.println("新插入数据的id：" + user.getId());
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }


}
