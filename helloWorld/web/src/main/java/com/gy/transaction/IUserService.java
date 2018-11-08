package com.gy.transaction;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/5/22.
 */

public interface IUserService {

    public abstract void addUser(User user);

    public abstract void deleteUser();

    public abstract void updateUser(Map params);

    public abstract List<User> queryUser(Map params);

    public  abstract void transactionTest();

    public void transactionTest2();

}
