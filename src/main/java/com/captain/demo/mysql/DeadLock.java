package com.captain.demo.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.captain.demo.common.utils.JDBCUtils;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Captain Wang
 * @time2020/6/23
 */
public class DeadLock implements DeadLockInterface {
    @Transactional
    @Override
    public void T1() {

    }

    @Transactional
    @Override
    public void T2() {

    }

    public static void main(String[] args) throws Exception {
        final DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setMaxActive(200);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(100);
        dataSource.setMaxWait(5000);
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement prep = conn.prepareStatement("select * from d_user");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("openid"));
            }
            JDBCUtils.release(rs, prep, conn);
        }
    }
}
