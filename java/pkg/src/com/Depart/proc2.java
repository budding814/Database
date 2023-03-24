package com.Depart;

import com.sql.Renewal;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class proc2 {
    proc2(){
        Renewal r = new Renewal();
        Connection con = r.getConnection();
        CallableStatement statement = null;
        try {
            CallableStatement stmt = null;
            String sql;
            sql = "{call proc_2(?)}";

            stmt = con.prepareCall(sql);
            stmt.setInt(1, 0);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        proc2 p2=new proc2();
    }
}
