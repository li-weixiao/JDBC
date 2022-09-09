package com.liweixiao.lesson02;

import com.liweixiao.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author:LiWeixiao
 * @date:2022/9/7
 * @description:
 */
public class TestSelect {
    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql="SELECT * FROM student WHERE id=1001";
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println("name:"+rs.getString("name"));
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
