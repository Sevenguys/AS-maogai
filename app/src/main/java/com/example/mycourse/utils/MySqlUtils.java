package com.example.mycourse.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlUtils {
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://192.168.137.1/android";
    static String user="android";
    static String passwd="android";
    public static void saveMysql(String table,String username,String content){
        try{
            Class.forName(driver);
            Connection cn = DriverManager.getConnection(url,user,passwd);
            System.out.println("插入数据库Connection连接数据库成功");
            Statement st = cn.createStatement();
            String sql ="insert into "+table+" values('"+username+"','"+content+"')";
            System.out.println(sql);
            st.execute(sql);
            System.out.println("插入数据库成功");
        } catch (ClassNotFoundException  | SQLException e) {
            System.out.println("插入数据库失败");
            e.printStackTrace();
        }
    }
}
