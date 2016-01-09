import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dong.entity.User;
import com.dong.sesrvice.UserService;


public class SpringBatis {

	ApplicationContext context = null;
    UserService userService = null;
    
    @Before
    public void initContext(){
    	this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //this.context = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
        this.userService = (UserService) context.getBean("userService");
        }
    
    
    @Test
    public void countAll(){
        System.out.println("数据库中的记录条数:"  + userService.countAll());
    }
    
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("董兆琦2");
        user.setPassword("passtest");
        user.setEmail("dennisit@163.com");
        user.setSex("男");
        user.setAge(23);
        userService.insert(user);
    }
    
    @Test
    public void selectAll(){
        List<User> list = userService.selectAll();
        for(int i=0; i<list.size(); i++){
            User user = list.get(i);
            System.out.println("用户名:" + user.getUsername() + "\t密码:" + user.getPassword() + "\t邮箱：" + user.getEmail());
        }
    }
    
    @Test
    public void update(){
        User user = new User();
        user.setUsername("董兆琦2");
        user.setPassword("xxxxxxxx");
        user.setEmail("xxxxxx@163xxx");
        user.setSex("男");
        user.setAge(25);
        userService.update(user);
    }
    
    @Test
    public void delete(){
        userService.delete("苏若年");
    }
    
    @Test
    public void findByName(){
        User user = userService.findByUserName("苏若年");
        System.out.println("用户名:" + user.getUsername() + "\t密码:" + user.getPassword() + "\t邮箱：" + user.getEmail());

    }
}
