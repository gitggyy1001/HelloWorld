package com.gy.jndi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hello on 2018/3/23.
 */
@Repository
public class JndiTest {

    //@Autowired
    //@Qualifier("dataSource")
    public  DataSource ds;

    public void test() throws NamingException, SQLException{
        Context context = new InitialContext();
        ds = (DataSource)context.lookup("java:comp/env/jdbc/demoDB");

        Connection con = ds.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select t.cust_id from customer t where t.cust_id=123 ";
        ResultSet rs = null;
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            Long custId = rs.getLong(1);
            System.out.println(custId);
        }
    }

    public static void main(String[] args) throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/demoDB");
        Connection con = ds.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select * from client where username='gy' ";
        ResultSet rs = null;
        rs = stmt.executeQuery(sql);
        boolean flag = rs.next();
    }

}
