package com.Stu;

import com.Depart.Menu;
import com.sql.Renewal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_u extends JFrame {
    Add_u(){
        JFrame cur=new JFrame();
        cur.setTitle("添加学会");
        cur.setVisible(true);
        cur.setLayout(null);
        cur.setLocationRelativeTo(null);
        cur.setSize(300,200);
        JLabel j1=new JLabel("学号");
        JLabel j2=new JLabel("学会");
        JTextField jtf1=new JTextField(5);
        JTextField jtf2=new JTextField(5);
        JButton jback=new JButton("确定");
        JButton jbexit=new JButton("退出");
        cur.add(j1);
        cur.add(j2);
        cur.add(jtf1);
        cur.add(jtf2);
        cur.add(jbexit);
        j1.setBounds(20,10,70,30);
        jtf1.setBounds(60,10,200,30);
        j2.setBounds(20,50,70,30);
        jtf2.setBounds(60,50,200,30);
        cur.add(jback);
        jback.setBounds(85,90,60,40);
        cur.add(jbexit);
        jbexit.setBounds(155,90,60,40);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu m=new Menu();
                cur.setVisible(false);
            }
        });
        jback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Renewal r=new Renewal();
                Connection con=r.getConnection();
                String s1=jtf1.getText().trim();
                String s2=jtf2.getText().trim();
                try{
                    String sql="insert into S_U1 (Stu, u) VALUES (?,?)";
                    PreparedStatement ps=null;
                    ps=con.prepareStatement(sql);//添加数据预处理
                    ps.setString(1, s1);
                    ps.setString(2,s2);
                    ps.executeUpdate();
                    ps.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        Add_u a=new Add_u();
    }
}
