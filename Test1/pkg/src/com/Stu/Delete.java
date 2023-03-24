package com.Stu;

import com.sql.Renewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends JFrame {
    Delete(){
        JButton jbexit=new JButton("退出");
        JButton jback=new JButton("确认");
        setTitle("删除");
        Container c=getContentPane();
        setSize(320, 180);// 窗体大小
        int width=320;
        int height=180;
        setLayout(null);

        JLabel j1=new JLabel("学号:");
        JTextField jtf1=new JTextField(5);

        Renewal r=new Renewal();
        Connection con =r.getConnection();
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        setLocation(screenWidth/2-width/2,screenHeight/2-height/2);

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
                try {
                    String Sno1=jtf1.getText();
                    String sql;
                    sql="delete from Stu where Sno=?";
                    PreparedStatement ps=null;
                    ps=con.prepareStatement(sql);//添加数据预处理
                    ps.setString(1,Sno1);
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }}
        });
    }
    public static void main(String[] args) {
        Delete d=new Delete();

    }
}


