package com.Class;

import com.sql.Renewal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class proc1 extends JFrame {
    proc1() {
        JFrame cur = new JFrame();
        cur.setTitle("proc1");
        cur.setVisible(true);
        cur.setLayout(null);
        cur.setLocationRelativeTo(null);
        cur.setSize(250, 250);
        JLabel j1 = new JLabel("旧班号:");
        JTextField jtf1 = new JTextField(5);
        JLabel j2 = new JLabel("新班号:");
        JTextField jtf2 = new JTextField(5);
        cur.add(j1);
        j1.setBounds(20,10,70,30);
        cur.add(jtf1);
        jtf1.setBounds(90,10,100,30);
        cur.add(j2);
        j2.setBounds(20,50,70,30);
        cur.add(jtf2);
        jtf2.setBounds(90,50,100,30);
        JButton jbexit = new JButton("退出");
        JButton jback = new JButton("确认");
        cur.add(jback);
        jback.setBounds(60,130,60,40);
        cur.add(jbexit);
        jbexit.setBounds(135,130,60,40);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                Menu m = new Menu();
                cur.setVisible(false);
            }
        });
        jback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                Renewal r = new Renewal();
                Connection con = r.getConnection();
                CallableStatement statement = null;
                try {
                    CallableStatement stmt = null;
                    String sql;
                    sql = "{call proc_getStudentRecord(?,?,?)}";
                    String s1=jtf1.getText().trim();
                    String s2=jtf2.getText().trim();
                    stmt = con.prepareCall(sql);
                    stmt.setString(1, s1);
                    stmt.setString(2, s2);
                    stmt.registerOutParameter(3, Types.INTEGER);
                    stmt.executeUpdate();
                    String result = String.valueOf(stmt.getInt(3)); //getXX方法专门用于获取存储过程中的输出参数
                    cur.setVisible(false);
                    JFrame cur1=new JFrame();
                    cur1.setTitle("结果");
                    cur1.setVisible(true);
                    cur1.setSize(300,100);
                    cur1.setLayout(null);
                    cur1.setLocationRelativeTo(null);
                    JLabel j1 = new JLabel("该班级的人数为:"+result);
                    cur1.add(j1);
                    j1.setBounds(20,10,200,30);
                    // 完成后关闭
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        proc1 p1=new proc1();
    }
}
