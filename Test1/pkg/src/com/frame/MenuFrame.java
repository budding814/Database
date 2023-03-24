package com.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.Class.*;
import com.Stu.*;
import com.mysql.cj.x.protobuf.MysqlxCursor;

public class MenuFrame extends JFrame {
    public MenuFrame(){
        setTitle("菜单");
        setLayout(null);
        Container c=getContentPane();
        JButton Stu1=new JButton("学生");
        JButton Class1=new JButton("班级");
        JButton Union1=new JButton("学生会");
        JButton Dept1=new JButton("系");
        JButton jbexit=new JButton("退出");
        Stu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Choose c=new com.Stu.Choose();
            }
        });
        Class1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                com.Class.Menu m=new com.Class.Menu();

            }
        });
        Union1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("欢迎来到Union");

            }
        });
        Dept1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                com.Depart.Menu m=new com.Depart.Menu();

            }
        });
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoadingFrame l=new LoadingFrame();

            }
        });
        c.add(Stu1);
        c.add(Class1);
        c.add(Union1);
        c.add(Dept1);
        c.add(jbexit);
        Stu1.setBounds(50,20,150,30);
        Class1.setBounds(50,60,150,30);
        Union1.setBounds(50,100,150,30);
        Dept1.setBounds(50,140,150,30);
        jbexit.setBounds(90,230,60,40);
        setSize(260,380);
        int width=260;
        int height=380;
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        setLocation(screenWidth/2-width/2,screenHeight/2-height/2);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        MenuFrame m=new MenuFrame();
    }
}
