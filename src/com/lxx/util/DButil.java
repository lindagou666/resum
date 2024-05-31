package com.lxx.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///jianli?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "123456";
        return DriverManager.getConnection(url, username, password);
    }
}
