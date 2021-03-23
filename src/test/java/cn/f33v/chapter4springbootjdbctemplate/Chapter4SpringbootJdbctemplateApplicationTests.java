package cn.f33v.chapter4springbootjdbctemplate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Chapter4SpringbootJdbctemplateApplicationTests {
    @Autowired
    private UserService userService;
    @Before
    public void setUp(){
        userService.deleteAllUsers();
    }
    @Test
    void contextLoads() {
        userService.addUser("aaa",1);
        userService.addUser("bbb",2);
        userService.addUser("ccc",3);
        userService.addUser("ddd",4);
        userService.addUser("eee",5);
        List<User> users=userService.getByName("aaa");
        Assert.assertEquals(1,users.get(0).getAge().intValue());
        Assert.assertEquals(5,userService.listAll().size());
        userService.deleteById(2);
        userService.deleteById(1);
        Assert.assertEquals(3,userService.listAll().size());
    }

}
