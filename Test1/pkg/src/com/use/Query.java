package com.use;

import com.sql.Renewal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Query {
    public static  Vector<String> QueryMsg(String str0,String str,String S[],String name) {
        Vector<String> v=new Vector<String>(5);
        Renewal r = new Renewal();
        Connection con = r.getConnection();
        String sql = "select * from "+name+" WHERE "+str0+"="+" ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, str);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                for(int i=0;i<S.length;i++){
                    v.add(rs.getString(S[i]));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return v;
    }

    public static void main(String[] args) {


    }
}
