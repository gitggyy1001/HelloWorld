package com.gy.transaction.dao;

import com.gy.transaction.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/5/22.
 */

@Repository
public interface IUserDao {
    public void addUser(User user);
    public void deleteUser();
    public void updateUser(Map params);
    public List queryUser(Map params);
}
