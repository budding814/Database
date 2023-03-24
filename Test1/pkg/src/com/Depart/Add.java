package com.Depart;

import com.sql.Renewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add extends JFrame{
    JButton jbexit=new JButton("退出");
    JButton jback=new JButton("确认");

    Add(){
        setTitle("添加系信息");
        Container c=getContentPane();
        setSize(320, 400);// 窗体大小
        setLayout(null);

        JLabel j1=new JLabel("系号:");
        JTextField jtf1=new JTextField(5);
        JLabel j2=new JLabel("系名:");
        JTextField jtf2=new JTextField(5);
        JLabel j3=new JLabel("地点:");
        JTextField jtf3=new JTextField(5);
        JLabel j4=new JLabel("人数:");
        JTextField jtf4=new JTextField(5);
        Renewal r=new Renewal();
        Connection con =r.getConnection();

        int width=320;
        int height=300;
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        setLocation(screenWidth/2-width/2,screenHeight/2-height/2);

        setVisible(true);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu m=new Menu();
                setVisible(false);
            }
        });
        jback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Sno=jtf1.getText().trim();
                String Sname=jtf2.getText().trim();
                String Sage= jtf3.getText().trim();
                int Sdept= Integer.parseInt(jtf4.getText().trim());
                try {
                    Statement stmt=null;
                    stmt=con.createStatement();
                    String sql;
                    sql="INSERT INTO Depart(DepartNo,DepartName,DepartLocation,DepartSum) VALUES(?,?,?,?)";
                    PreparedStatement ps=null;
                    ps=con.prepareStatement(sql);//添加数据预处理
                    ps.setString(1, Sno);
                    ps.setString(2, Sname);
                    ps.setString(3, Sage);
                    ps.setInt(4, Sdept);
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
        c.add(j1);
        j1.setBounds(20,10,70,30);
        c.add(jtf1);
        jtf1.setBounds(80,10,200,30);
        c.add(j2);
        j2.setBounds(20,50,70,30);
        c.add(jtf2);
        jtf2.setBounds(80,50,200,30);
        c.add(j3);
        j3.setBounds(20,90,70,30);
        c.add(jtf3);
        jtf3.setBounds(80,90,200,30);
        c.add(j4);
        j4.setBounds(20,130,70,30);
        c.add(jtf4);
        jtf4.setBounds(80,130,200,30);
        c.add(jback);
        jback.setBounds(85,250,60,40);
        c.add(jbexit);
        jbexit.setBounds(155,250,60,40);

    }

    public static void main(String[] args) {
        Add a=new Add();

    }
}
