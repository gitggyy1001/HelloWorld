package com.gy.web;


import com.gy.aop.AopTest;

import com.gy.aop.IAopTest;
import com.gy.aop.NoAop;
import com.gy.jndi.JdbcTemplateTestDao;
import com.gy.jndi.JndiTest;
import com.gy.spring_rmi.Client;
import com.gy.transaction.IUserService;
import com.gy.transaction.User;
import com.gy.transaction.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/3/23.
 */
@Controller
public class GenController extends HttpServlet {

    @Autowired
    JndiTest jndiTest;

    @Autowired
    JdbcTemplateTestDao jdbcTemplateTestDao ;

    @Autowired
    Client springRmiCliet;

    @Autowired
    JmsOperations jmsOperations;

    @Autowired
    IAopTest aopTest;

    @Autowired
    IUserDao userDao;

    @Autowired
    IUserService userService;

    @Autowired
    NoAop noAop;


//    public JdbcTemplateTestDao getTestDao() {
//        return testDao;
//    }
//
//    public void setTestDao(JdbcTemplateTestDao testDao) {
//        this.testDao = testDao;
//    }


    @RequestMapping("/transaction")
    public String test() throws SQLException, NamingException {
        //JndiTest jt = new JndiTest();
        //jt.test();
        //testDao.selectCount();
        //Jedis jedisCli;
        //jedisCli = new Jedis("127.0.0.1", 6379); //新建Jedis对象
        //jedisCli.select(0); //切换Redis数据库
        //jedisCli.set("firstJedis", "hello,Jedis"); //与Redis命令行操作基本一致

        //redis
        //Long custId = 3311350798220L;
        //List<Map<String,Object>> l = testDao.queryCustomerByCustId(custId);

        //httpinvoker
        //cliet.getUser();

        //activiMQ
        //jmsOperations.convertAndSend("test.queue","123");
        //jmsOperations.convertAndSend("test.queue","1234");



//        ActiveMQTextMessage om = (ActiveMQTextMessage)jmsOperations.receive("test.queue");
//        try {
//            String s = om.getText();
//            System.out.println("mq:get======="+s);
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }

//        System.out.println("test==================web");
//        //jndiTest.test();
//        jdbcTemplateTestDao.queryCustomerByCustId(2333L);


          //aopTest.test();

        //User user = springRmiCliet.getUser();
        //System.out.println(user.getUserName());

        //重复读
        //this.read1();
        //this.read2();

        userService.transactionTest();
        return "test";
    }

    @RequestMapping("/jndi")
    public String test2() throws SQLException, NamingException {
        userService.transactionTest2();
        return "test";
    }

    @RequestMapping("/aopTest")
    public String test3() throws SQLException, NamingException {
        //noAop.hello();

        aopTest.test();

        //aopTest.test2();

        return "test";
    }

}
