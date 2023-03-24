package com.sql;

import com.frame.enterFrame;

import java.sql.*;

public class Renewal {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=MyDatabase1";

    String userName = "sa";


    String userPwd = "yml456123";

    public Connection getConnection() {

        try {
            System.out.println("连接成功");
            Class.forName(driverName);

            con = DriverManager.getConnection(dbURL, userName, userPwd);
            //System.out.println("连接成功");

        } catch (Exception e) {

            e.printStackTrace();

            System.out.print("连接失败");

        }
        return con;
    }

    public static void main(String[] args) {
        Renewal r=new Renewal();
        Connection con =r.getConnection();
    }

}
