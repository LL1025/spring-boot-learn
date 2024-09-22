package com.example.springbootlearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author linW2
 * @date 2024/9/15 00:10
 * @description TODO: 描述类的功能
 */
public class ThreadJdbc {

    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static final String url = "jdbc:mysql://127.0.0.1:3306/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                // 加载 MySQL 驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                threadLocal.set(connection);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                threadLocal.remove();
            }
        }
    }
}
