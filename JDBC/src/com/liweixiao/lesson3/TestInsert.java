package com.liweixiao.lesson3;

import com.liweixiao.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author:LiWeixiao
 * @date:2022/9/8
 * @description:
 */
public class TestInsert {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn = JdbcUtils.getConnection();
            String sql="INSERT INTO student(id,`name`,`age`) VALUES(?,?,?)";
            ps = conn.prepareStatement(sql);
            // 手动赋值
            ps.setInt(1,1005);
            ps.setString(2,"库七");
            ps.setInt(3,30);
            // 执行
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("update 成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,ps,null);
        }
    }
}
