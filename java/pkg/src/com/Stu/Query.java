package com.Stu;

import com.sql.Renewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Query extends JFrame{
    JButton jbexit=new JButton("退出");
    JButton jback=new JButton("确认");

    Query(){
        setTitle("查询");
        Container c=getContentPane();
        setSize(320, 180);// 窗体大小
        int width=320;
        int height=180;
        setLayout(null);

        JLabel j1=new JLabel("学号:");
        JTextField jtf1=new JTextField(10);

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
                String Sno=jtf1.getText().trim();
                String s11="Sno";
                    String sql="select * from Stu WHERE "+s11+"="+"?";
                    try{
                        PreparedStatement ps=con.prepareStatement(sql);
                        //ps.setString(1,s11);
                        ps.setString(1,Sno);
                        ResultSet rs=ps.executeQuery();
                        String s1=null,s2=null,s4=null,s5=null,s6=null;
                        int s3=0;
                        while(rs.next()){
                            s1=rs.getString("Sno");
                            s2=rs.getString("Sname");
                            s3=rs.getInt("Sage");
                            s4=rs.getString("Sdept");
                            s5=rs.getString("Sclass");
                            s6=rs.getString("Sdorm");
                        }
                        if(s1==null){
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
                        if(s1!=null){
                            setVisible(false);
                        }
                        JFrame nj1=new JFrame();
                        nj1.setTitle("查询结果");
                        nj1.setLayout(null);
                        nj1.setSize(260,380);
                        int width=260;
                        int height=380;
                        JLabel ss1=new JLabel("学号: ");
                        JLabel ss2=new JLabel("姓名: ");
                        JLabel ss3=new JLabel("年龄: ");
                        JLabel ss4=new JLabel("系名: ");
                        JLabel ss5=new JLabel("班级: ");
                        JLabel ss6=new JLabel("宿舍: ");
                        JLabel sss1=new JLabel(s1);
                        JLabel sss2=new JLabel(s2);
                        JLabel sss3=new JLabel(String.valueOf(s3));
                        JLabel sss4=new JLabel(s4);
                        JLabel sss5=new JLabel(s5);
                        JLabel sss6=new JLabel(s6);
                        JButton jbexit1=new JButton("退出");
                        JButton jback1=new JButton("确认");
                        nj1.add(ss1);
                        nj1.add(ss2);
                        nj1.add(ss3);
                        nj1.add(ss4);
                        nj1.add(ss5);
                        nj1.add(ss6);
                        nj1.add(sss1);
                        nj1.add(sss2);
                        nj1.add(sss3);
                        nj1.add(sss4);
                        nj1.add(sss5);
                        nj1.add(sss6);
                        nj1.add(jback1);
                        nj1.add(jbexit1);
                        ss1.setBounds(20,10,100,30);
                        sss1.setBounds(100,10,100,30);
                        ss2.setBounds(20,50,100,30);
                        sss2.setBounds(100,50,100,30);
                        ss3.setBounds(20,90,100,30);
                        sss3.setBounds(100,90,100,30);
                        ss4.setBounds(20,130,100,30);
                        sss4.setBounds(100,130,100,30);
                        ss5.setBounds(20,170,100,30);
                        sss5.setBounds(100,170,100,30);
                        ss6.setBounds(20,210,100,30);
                        sss6.setBounds(100,210,100,30);
                        jbexit1.setBounds(90,250,60,40);
                        nj1.setLocation(screenWidth/2-width/2,screenHeight/2-height/2);
                        if(s1!=null){
                            nj1.setVisible(true);
                        }
                        nj1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jbexit1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                nj1.setVisible(false);
                                setVisible(true);
                            }
                        });

                    } catch (SQLException ex) {
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
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {

        Query q=new Query();
    }
}
