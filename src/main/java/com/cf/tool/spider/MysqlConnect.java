package com.cf.tool.spider;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @program: tool
 * @description: mysql数据库连接
 * @author: cf
 * @create: 2019-05-10 11:41
 */
public class MysqlConnect {

    private static Connection conn = null;

    public Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //加载数据库连接驱动
            String user = "root";
            String psw = "123456";
            String url = "jdbc:mysql://localhost:3306/tool?characterEncoding=utf-8&characterSetResults=utf-8&useUnicode=true&useSSL=true&serverTimezone=UTC";
            conn = DriverManager.getConnection(url, user, psw);  //获取连接
        } catch (Exception e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        return conn;
    }
}
