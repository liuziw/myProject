import com.alibaba.fastjson.JSON;
import com.zw.domain.User;
import com.zw.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/9.
 */
public class TestMyBatis {

    private static Logger logger = Logger.getLogger(TestMyBatis.class);
     private ApplicationContext ac = null;
    //@Resource
    private UserServiceImpl userService = null;
    //  @Before
  public void before() {
      ac = new ClassPathXmlApplicationContext("spring-config.xml");
      userService = (UserServiceImpl) ac.getBean("userService");
  }
    @Test
    public void test1() {
        User user = userService.getUserById(1);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }

}
