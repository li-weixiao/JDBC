package com.liweixiao.lesson01;

import java.sql.*;

/**
 * @author:LiWeixiao
 * @date:2022/9/7
 * @description:
 */
public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver"); //固定写法

        // 2.用户信息和url
        String url="jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username="root";
        String password="123456";

        // 3.连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4.执行SQL对象
        Statement statement = connection.createStatement();

        // 5.去执行SQL，查看返回结果
        String sql="select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.print("id:"+resultSet.getInt("id")+"\t");
            System.out.print("name:"+resultSet.getString("name")+"\t");
            System.out.println("age:"+resultSet.getInt("age"));
            System.out.println("----------------------------------------");
        }

        // 6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
