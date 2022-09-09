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
public class TestDelete {
    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql="DELETE FROM student WHERE `id`=1004";
            int i = st.executeUpdate(sql);
            if(i>0){
                System.out.println("删除成功。");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
