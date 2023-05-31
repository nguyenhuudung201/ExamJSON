package com.class2.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/api"
                    ,"root","");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
