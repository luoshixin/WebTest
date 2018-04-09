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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper odersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = odersMapper.findOrdersUserLazyLoading();
        sqlSession.close();
    }
}
