package com.use;

import com.Stu.Choose;
import com.Stu.Query;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.sql.Renewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Find extends JFrame{
    public  ResultSet Find_rs(String str1,String str2,String str3){

        ResultSet[] rs = {null};
        setTitle("查询");
        Container c=getContentPane();
        setSize(320, 180);// 窗体大小
        int width=320;
        int height=180;
        setLayout(null);
        JButton jbexit=new JButton("退出");
        JButton jback=new JButton("确认");
        JLabel j1=new JLabel(str3);
        JTextField jtf1=new JTextField(10);

        Renewal r=new Renewal();
        Connection con =r.getConnection();
        setLocationRelativeTo(null);
        setVisible(true);
        c.add(j1);
        j1.setBounds(20,10,70,30);
        c.add(jtf1);
        jtf1.setBounds(60,10,200,30);

        c.add(jback);
        jback.setBounds(85,60,60,40);
        c.add(jbexit);
        jbexit.setBounds(165,60,60,40);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Choose c1=new Choose();
                setVisible(false);
            }
        });
        jback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sno = jtf1.getText().trim();
                String sql = "select * from ? WHERE ?=?";
                try {

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setObject(1, str1);
                    ps.setObject(2,str2);
                    ps.setObject(3,Sno);
                    rs[0] = ps.executeQuery();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(true);
            }
        });
        return rs[0];
    }
}
