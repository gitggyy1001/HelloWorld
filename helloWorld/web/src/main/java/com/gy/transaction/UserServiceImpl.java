package com.gy.transaction;

import com.gy.jndi.JdbcTemplateTestDao;
import com.gy.transaction.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/5/22.
 */
@Repository

public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    JdbcTemplateTestDao jdbcTemplateTestDao;

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public void deleteUser() {
        this.userDao.deleteUser();
    }

    @Override
    public void updateUser(Map params) {
        this.userDao.updateUser(params);
    }

    @Override
    public List queryUser(Map params) {
        return this.userDao.queryUser(params);
    }

    @Override
    @Transactional(readOnly = true)
    public void transactionTest() {
//        PlatformTransactionManager txManager = ContextLoader.getCurrentWebApplicationContext().getBean(PlatformTransactionManager.class);
//        Map<String, Object> param = new HashMap<String, Object>();
//        List<User> userList = userDao.queryUser(param);
//        System.out.println("thread1-read-completed");
//        System.out.println("before:"+userList.get(0).getUserName());
//        System.out.println("before================"+userList.size());
//        try {
//            Thread.sleep(20000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        List<User> userList2 = userDao.queryUser(param);
//        System.out.println("after:"+userList2.get(0).getUserName());
//        System.out.println("after================"+userList2.size());
//        System.out.println("thread1--completed");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userName", "555");
        userDao.updateUser(param);
        System.out.println("thread2--completed");
    }

    @Override
    public void transactionTest2() {

//        List<Map<String,Object>> result= jdbcTemplateTestDao.queryCustomerByCustId(1L);
//        System.out.println("before================"+result.size());
//        try {
//            Thread.sleep(10000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        List<Map<String,Object>> result2= jdbcTemplateTestDao.queryCustomerByCustId(1L);
//        System.out.println("after================"+result2.size());

        caozuo1();

    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void caozuo1(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userName", "000000");
        jdbcTemplateTestDao.updateUser();
        System.out.println("thread2--completed");
        int i = 1/0;
    }
}