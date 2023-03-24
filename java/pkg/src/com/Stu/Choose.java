package com.Stu;

import com.frame.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.Cleaner;
import java.time.temporal.JulianFields;

public class Choose extends JFrame {
    public Choose(){
        setTitle("功能");
        setLayout(null);
        Container c=getContentPane();
        JButton jb1=new JButton("查询全体学生");
        JButton jb2=new JButton("查询学生信息");
        JButton jb3=new JButton("修改学生信息");
        JButton jb4=new JButton("增加一位学生");
        JButton jb5=new JButton("删除学生信息");
        JButton jb6=new JButton("加入一个学会");
        JButton jbexit=new JButton("退出");
        c.add(jb1);
        c.add(jb2);
        c.add(jb3);
        c.add(jb4);
        c.add(jb5);
        c.add(jb6);
        c.add(jbexit);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                QueryAll ql=new QueryAll();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Query q=new Query();
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Change a=new Change();

            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Add a=new Add();


            }
        });
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Delete d=new Delete();
            }
        });
        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Delete d=new Delete();
            }
        });
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuFrame m=new MenuFrame();
            }
        });
        setSize(260,380);
        jb1.setBounds(50,20,150,30);
        jb2.setBounds(50,60,150,30);
        jb3.setBounds(50,100,150,30);
        jb4.setBounds(50,140,150,30);
        jb5.setBounds(50,180,150,30);
        jb6.setBounds(50,220,150,30);
        jbexit.setBounds(100,270,60,40);
        int width=260,height=380;
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
        Choose c=new Choose();
    }
}
