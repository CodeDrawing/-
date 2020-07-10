package top.zwzx.Test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.zwzx.mapper.UserMapper;
import top.zwzx.pojo.User;
import top.zwzx.service.IUserService;
import top.zwzx.untls.MybatisUtils;

/**
 * @author zx
 * @date 2020/7/9
 **/
public class test {

    @Test
    public void run01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService=(IUserService) context.getBean("userServiceImpl");
        Boolean book = userService.checkUserName("赵兴");
        System.out.println(book);
    }
    @Test
    public void run02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userServiceImpl = ac.getBean("userServiceImpl", IUserService.class);
        Boolean aa = userServiceImpl.checkUserName("zhaoxing");
        System.out.println (aa);
    }

    @Test
    public void run03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userServiceImpl = ac.getBean("userServiceImpl", IUserService.class);
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123345");
        user.setPhone("12345656785");
        user.setEmail("8345694@qq.com");


        int a = userServiceImpl.submitRegister(user);
        System.out.println (a);
    }
}
