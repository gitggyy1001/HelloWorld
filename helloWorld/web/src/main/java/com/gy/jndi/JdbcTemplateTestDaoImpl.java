package com.gy.jndi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/3/24.
 */
@Repository
public class JdbcTemplateTestDaoImpl implements JdbcTemplateTestDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Autowired
    //protected RedisTemplate<Serializable, Serializable> redisTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void selectCount() {
        String sql="select count(1) from dual";
        Object []params = new Object[]{1};
        List rs = jdbcTemplate.queryForList(sql);
        System.out.println(rs.size());
    }


    //@Cacheable("CustomerCache")
    public List<Map<String,Object>> queryCustomerByCustId(Long custId){
        String sql="select * from user_test t for update";
        Object []params = new Object[]{custId};
        //List<Map<String,Object>> result =  jdbcTemplate.queryForList(sql,params);
        List<Map<String,Object>> result =  jdbcTemplate.queryForList(sql);
        System.out.println("=============no-cached==================");
        return result;
    }

    @Override
    public void updateUser() {
        String sql="update  user_test t set t.user_name='123123' ";
        jdbcTemplate.update(sql);
    }


}
