package cn.rabbit;

import static org.junit.Assert.assertTrue;

import cn.rabbit.dao.UserDAO;
import cn.rabbit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJDBCTest
{
    //将 UserDAO 对象注入
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    //下面的两个test方法是使用 jdbcTemplate 来进行 jdbc操作的
    @Test
    public void addUser() {
        userDAO.add();
    }

    @Test
    public void queryUser() {
        System.out.println(userDAO.query("6"));
    }

    //=================spring 的事务管理 ===========================
    //没有事务前调用的方法：
    @Test
    public void addTwoUsers() {
        //在 UserService 类中的 add 方法调用两次 userDAO 的add方法，
        //在方法之间跑出异常。没有事务前，一个添加成功，一个没有添加到数据库中
        userService.add();
    }

    //有事务管理后的方法，两个方法是一样的，只不过为了区分下
    @Test
    public void addTwoUsers2() {
        userService.add();
    }
}
