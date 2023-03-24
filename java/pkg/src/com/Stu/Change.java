package com.Stu;

import com.sql.Renewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Change extends JFrame{
    JButton jbexit=new JButton("退出");
    JButton jback=new JButton("确认");
    String Sno1=null;
    Change(){
        setTitle("修改");
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
                Sno1=jtf1.getText().trim();
                String sql="select * from Stu WHERE Sno=?";
                try {

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setObject(1, Sno1);
                    ResultSet rs = ps.executeQuery();
                    JButton jback1 = new JButton("确认");
                    JButton jbexit1 = new JButton("退出");
                    String s1 = null, s2 = null, s4 = null, s5 = null, s6 = null;
                    int s3 = 0;
                    while (rs.next()) {
                        s1 = rs.getString("Sno");
                        s2 = rs.getString("Sname");
                        s3 = rs.getInt("Sage");
                        s4 = rs.getString("Sdept");
                        s5 = rs.getString("Sclass");
                        s6 = rs.getString("Sdorm");
                    }
                    if (s1 == null) {
                        JFrame error = new JFrame();
                        error.setTitle("错误");
                        error.setVisible(true);

                        error.setSize(300, 170);
                        JButton exit = new JButton("确定");
                        JLabel j = new JLabel("您输入的信息有误，请重新输入");

                        error.setLayout(null);
                        error.setLocationRelativeTo(null);
                        error.add(exit);
                        error.add(j);
                        j.setBounds(20, 10, 200, 30);
                        exit.setBounds(120, 50, 60, 40);
                        exit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                error.setVisible(false);
                                jtf1.setText("");
                            }
                        });
                        }
                        JFrame nj1 = new JFrame();
                        if(s1!=null){
                            setVisible(false);
                        }
                        nj1.setTitle("修改为");
                        nj1.setLayout(null);
                        nj1.setSize(260, 380);
                        int width = 260;
                        int height = 380;
                        JLabel j1 = new JLabel("学号:");
                        JLabel j2 = new JLabel("姓名:");
                        JLabel j3 = new JLabel("年龄:");
                        JLabel j4 = new JLabel("系名:");
                        JLabel j5 = new JLabel("班级:");
                        JLabel j6 = new JLabel("宿舍:");
                        JTextField jtf1 = new JTextField(5);
                        JTextField jtf2 = new JTextField(5);
                        JTextField jtf3 = new JTextField(5);
                        JTextField jtf4 = new JTextField(5);
                        JTextField jtf5 = new JTextField(5);
                        JTextField jtf6 = new JTextField(5);
                        nj1.add(j1);
                        nj1.add(j2);
                        nj1.add(j3);
                        nj1.add(j4);
                        nj1.add(j5);
                        nj1.add(j6);
                        nj1.add(jtf1);
                        nj1.add(jtf2);
                        nj1.add(jtf3);
                        nj1.add(jtf4);
                        nj1.add(jtf5);
                        nj1.add(jtf6);
                        nj1.add(jback1);
                        nj1.add(jbexit1);
                        j1.setBounds(20, 10, 100, 30);
                        jtf1.setBounds(100, 10, 100, 30);
                        j2.setBounds(20, 50, 100, 30);
                        jtf2.setBounds(100, 50, 100, 30);
                        j3.setBounds(20, 90, 100, 30);
                        jtf3.setBounds(100, 90, 100, 30);
                        j4.setBounds(20, 130, 100, 30);
                        jtf4.setBounds(100, 130, 100, 30);
                        j5.setBounds(20, 170, 100, 30);
                        jtf5.setBounds(100, 170, 100, 30);
                        j6.setBounds(20, 210, 100, 30);
                        jtf6.setBounds(100, 210, 100, 30);
                        jback1.setBounds(50, 250, 60, 40);
                        jbexit1.setBounds(120, 250, 60, 40);
                        nj1.setLocation(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2);
                        if(s1!=null){
                            nj1.setVisible(true);
                        }
                        jbexit1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                nj1.setVisible(false);
                                setVisible(true);

                            }
                        });
                        jback1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String Sno = jtf1.getText().trim();
                                String Sname = jtf2.getText().trim();
                                int Sage = Integer.parseInt(jtf3.getText());
                                String Sdept = jtf4.getText().trim();
                                String Sclass = jtf5.getText().trim();
                                String Sdrom = jtf6.getText().trim();
                                try {
                                    Statement stmt = null;
                                    stmt = con.createStatement();
                                    String sql;
                                    sql = "UPDATE Stu SET Sno=? ,Sname=?,Sage=?,Sdept=?,Sclass=?,Sdorm=? WHERE Sno=?";
                                    PreparedStatement ps = null;
                                    ps = con.prepareStatement(sql);//添加数据预处理
                                    ps.setString(1, Sno);
                                    ps.setString(2, Sname);
                                    ps.setInt(3, Sage);
                                    ps.setString(4, Sdept);
                                    ps.setString(5, Sclass);
                                    ps.setString(6, Sdrom);
                                    ps.setString(7, Sno1);
                                    System.out.printf(sql);
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
                    } catch(SQLException ex){
                        throw new RuntimeException(ex);
                    }
            }



        });
        c.add(j1);
        j1.setBounds(20,10,70,30);
        c.add(jtf1);
        jtf1.setBounds(60,10,200,30);

        c.add(jback);
        jback.setBounds(85,60,60,40);
        c.add(jbexit);
        jbexit.setBounds(165,60,60,40);
        setVisible(true);
    }

    public static void main(String[] args) {

        Change c=new Change();
    }
}
