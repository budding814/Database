package com.Class;
import com.Stu.Choose;
import com.sql.Renewal;
import com.use.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class Query extends JFrame {
    Query(){
        JFrame cur=new JFrame();
        cur.setTitle("查询");
        cur.setSize(320, 180);
        cur.setLocationRelativeTo(null);
        cur.setLayout(null);
        cur.setVisible(true);
        JLabel j1=new JLabel("学会号:");
        JTextField jtf1=new JTextField(10);

        JButton jbexit=new JButton("退出");
        JButton jback=new JButton("确认");

        cur.add(j1);
        j1.setBounds(20,10,70,30);
        cur.add(jtf1);
        jtf1.setBounds(60,10,200,30);

        cur.add(jback);
        jback.setBounds(85,60,60,40);
        cur.add(jbexit);
        jbexit.setBounds(165,60,60,40);
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

                cur.setVisible(false);
                com.use.Query q=new com.use.Query();
                String ss=jtf1.getText().trim();
                String[] S={"Cno","Cis","Cdept","Cnumber","Ctime"};
                Vector<String> s=q.QueryMsg("Cno",ss,S,"Class");
                String[] array = s.toArray(new String[s.size()]);
                if(array.length==0){
                    jtf1.setText("");
                    error er=new error();
                    er.err(cur);
                }else {
                    JFrame nj1 = new JFrame();
                    nj1.setTitle("查询结果");
                    nj1.setVisible(true);
                    nj1.setLayout(null);
                    nj1.setSize(260, 380);
                    nj1.setLocationRelativeTo(null);
                    JLabel ss1 = new JLabel("班号: ");
                    JLabel ss2 = new JLabel("系号: ");
                    JLabel ss3 = new JLabel("专业号: ");
                    JLabel ss4 = new JLabel("人数: ");
                    JLabel ss5 = new JLabel("入校时间: ");
                    JLabel sss1 = new JLabel(array[0]);
                    JLabel sss2 = new JLabel(array[1]);
                    JLabel sss3 = new JLabel(array[2]);
                    JLabel sss4 = new JLabel(array[3]);
                    JLabel sss5 = new JLabel(array[4]);
                    JButton jbexit1 = new JButton("退出");
                    JButton jback1 = new JButton("确认");
                    nj1.add(ss1);
                    nj1.add(ss2);
                    nj1.add(ss3);
                    nj1.add(ss4);
                    nj1.add(ss5);
                    nj1.add(sss1);
                    nj1.add(sss2);
                    nj1.add(sss3);
                    nj1.add(sss4);
                    nj1.add(sss5);
                    nj1.add(jback1);
                    nj1.add(jbexit1);
                    ss1.setBounds(20, 10, 100, 30);
                    sss1.setBounds(100, 10, 100, 30);
                    ss2.setBounds(20, 50, 100, 30);
                    sss2.setBounds(100, 50, 100, 30);
                    ss3.setBounds(20, 90, 100, 30);
                    sss3.setBounds(100, 90, 100, 30);
                    ss4.setBounds(20, 130, 100, 30);
                    sss4.setBounds(100, 130, 100, 30);
                    ss5.setBounds(20, 170, 100, 30);
                    sss5.setBounds(100, 170, 100, 30);
                    jbexit1.setBounds(90, 250, 60, 40);

                    jbexit1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            nj1.setVisible(false);
                            cur.setVisible(true);

                        }
                    });
                }

            }
        });

    }

    public static void main(String[] args) {
        Query q=new Query();
    }
}
