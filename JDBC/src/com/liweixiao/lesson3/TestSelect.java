package com.liweixiao.lesson3;

import com.liweixiao.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:LiWeixiao
 * @date:2022/9/9
 * @description:
 */
public class TestSelect {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn = JdbcUtils.getConnection();
            String sql="SELECT * FROM student WHERE id = ?";
            ps = conn.prepareStatement(sql);
            // 手动赋值
            ps.setInt(1,1005);
            // 执行
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("name:"+rs.getString("name"));
                System.out.println("--------------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,ps,rs);
        }
    }
}
