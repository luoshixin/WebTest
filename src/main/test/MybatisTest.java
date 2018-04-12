import com.test.bean.User;
import com.test.com.test.service.UserService;
import com.test.com.test.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisTest {
    private ApplicationContext ac;

    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void test() throws Exception {
        UserService userService = ac.getBean("userService", UserService.class);
        User user = new User();
        user.setId(1);
        user.setUsername("王五");
        userService.updateUserNameById(user);
    }

}
