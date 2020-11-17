package com.captain.demo.study.mysql.chapter1;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Captain Wang
 * @time2020/6/23
 */
public interface DeadLockInterface {
    void insert(Connection connection) throws SQLException;

    void select(Connection connection) throws SQLException;
}
