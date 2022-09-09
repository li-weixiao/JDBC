package com.liweixiao.lesson02.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author:LiWeixiao
 * @date:2022/9/7
 * @description:
 */
public class JdbcUtils {
    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;

    static {
        try{
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            // 1.加载驱动，只用加载一次
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 2.获取连接
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }

    // 3.释放连接
    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
