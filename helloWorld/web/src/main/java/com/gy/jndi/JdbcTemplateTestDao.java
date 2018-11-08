package com.gy.jndi;

import java.util.List;
import java.util.Map;

/**
 * Created by hello on 2018/3/24.
 */
public interface JdbcTemplateTestDao {
    public void selectCount();
    public List<Map<String,Object>> queryCustomerByCustId(Long custId);
    public void updateUser();
}
