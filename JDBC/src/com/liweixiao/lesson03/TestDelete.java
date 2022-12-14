package com.liweixiao.lesson03;

import com.liweixiao.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author:LiWeixiao
 * @date:2022/9/9
 * @description:
 */
public class TestDelete {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn = JdbcUtils.getConnection();
            String sql="DELETE FROM student WHERE `id`=?";
            ps = conn.prepareStatement(sql);
            // 手动赋值
            ps.setInt(1,1005);
            // 执行
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("delete 成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,ps,null);
        }
    }
}
