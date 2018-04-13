import com.test.bean.User;
import com.test.com.test.service.UserService;
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
        User user = userService.findUserById(1);
        System.out.println(user);
    }

}
