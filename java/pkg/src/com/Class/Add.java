package com.Class;
import com.Stu.Choose;
import com.sql.Renewal;
import com.use.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add extends JFrame{
    Add(){
        JFrame cur=new JFrame();
        cur.setTitle("添加班级信息");
        cur.setSize(320, 400);// 窗体大小
        cur.setLayout(null);
        cur.setLocationRelativeTo(null);
        cur.setVisible(true);
        JLabel j1=new JLabel("班号:");
        JTextField jtf1=new JTextField(5);
        JLabel j2=new JLabel("系号:");
        JTextField jtf2=new JTextField(5);
        JLabel j3=new JLabel("专业:");
        JTextField jtf3=new JTextField(5);
        JLabel j4=new JLabel("人数:");
        JTextField jtf4=new JTextField(5);
        JLabel j5=new JLabel("入校日期:");
        JTextField jtf5=new JTextField(15);
        JButton jbexit=new JButton("退出");
        JButton jback=new JButton("确认");
        Renewal r=new Renewal();
        Connection con =r.getConnection();
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
                String Cno=jtf1.getText().trim();
                String Cis=jtf2.getText().trim();
                String Cdept=jtf3.getText().trim();
                int Cnumber=Integer.parseInt(jtf4.getText());
                Date Ctime= Date.valueOf(jtf5.getText().trim());
                try {
                    Statement stmt=null;
                    stmt=con.createStatement();
                    String sql;
                    sql="INSERT INTO Class(Cno,Cis,Cdept,Cnumber,Ctime) VALUES(?,?,?,?,?)";
                    PreparedStatement ps=null;
                    ps=con.prepareStatement(sql);//添加数据预处理
                    ps.setString(1, Cno);
                    ps.setString(2, Cis);
                    ps.setString(3, Cdept);
                    ps.setInt(4,Cnumber);
                    ps.setDate(5, Ctime);
                    ps.executeUpdate();//执行添加数据
                    // 完成后关闭
                    ps.close();
                    stmt.close();
                    con.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cur.add(j1);
        j1.setBounds(20,10,70,30);
        cur.add(jtf1);
        jtf1.setBounds(90,10,200,30);
        cur.add(j2);
        j2.setBounds(20,50,70,30);
        cur.add(jtf2);
        jtf2.setBounds(90,50,200,30);
        cur.add(j3);
        j3.setBounds(20,90,70,30);
        cur.add(jtf3);
        jtf3.setBounds(90,90,200,30);
        cur.add(j4);
        j4.setBounds(20,130,70,30);
        cur.add(jtf4);
        jtf4.setBounds(90,130,200,30);
        cur.add(j5);
        j5.setBounds(20,170,70,30);
        cur.add(jtf5);
        jtf5.setBounds(90,170,200,30);
        cur.add(jback);
        jback.setBounds(85,250,60,40);
        cur.add(jbexit);
        jbexit.setBounds(155,250,60,40);
    }

    public static void main(String[] args) {
        Add a=new Add();
    }
}
