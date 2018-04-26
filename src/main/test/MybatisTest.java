import com.test.bean.OrdersExample;
import com.test.bean.User;
import com.test.bean.UserExample;
import com.test.dao.OrdersMapper;
import com.test.dao.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MybatisTest {
    private ApplicationContext ac;

    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
    }

    @Test
    public void test() throws Exception {
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
//        OrdersMapper ordersMapper = ac.getBean("ordersMapper", OrdersMapper.class);
//
//        OrdersExample ordersExample = new OrdersExample();
//        OrdersExample.Criteria criteria = ordersExample.createCriteria();
//        criteria.andUserIdEqualTo(1);
//        criteria.like

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike("%王%");

        userMapper.selectByExample(userExample);



    }

}
