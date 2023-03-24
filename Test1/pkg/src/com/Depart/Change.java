package com.Depart;

import com.sql.Renewal;
import com.use.error;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Change extends  JFrame {

    public Change() {
        com.use.Query q = new com.use.Query();
        JFrame cur = new JFrame();
        cur.setTitle("修改");
        cur.setSize(320, 180);
        cur.setLocationRelativeTo(null);
        cur.setLayout(null);
        cur.setVisible(true);
        JLabel j1 = new JLabel("系号:");
        JTextField jtf1 = new JTextField(10);

        JButton jbexit = new JButton("退出");
        JButton jback = new JButton("确认");

        cur.add(j1);
        j1.setBounds(20, 10, 70, 30);
        cur.add(jtf1);
        jtf1.setBounds(60, 10, 200, 30);

        cur.add(jback);
        jback.setBounds(85, 60, 60, 40);
        cur.add(jbexit);
        jbexit.setBounds(165, 60, 60, 40);
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
                String[] S={"DepartNo","DepartName","DepartLocation","DepartSum"};
                Vector<String> s = q.QueryMsg("DepartNo",jtf1.getText().trim(),S,"Depart");
                String[] array = s.toArray(new String[s.size()]);
                cur.setVisible(false);
                if (array.length == 0) {
                    jtf1.setText("");
                    error er = new error();
                    er.err(cur);
                } else {
                    JFrame nj1 = new JFrame();
                    nj1.setTitle("修改为");
                    nj1.setLayout(null);
                    nj1.setSize(260, 380);
                    nj1.setVisible(true);
                    nj1.setLocationRelativeTo(null);
                    JLabel j1 = new JLabel("系号:");
                    JLabel j2 = new JLabel("系名:");
                    JLabel j3 = new JLabel("地点:");
                    JLabel j4 = new JLabel("人数:");
                    JTextField jtf1 = new JTextField(5);
                    JTextField jtf2 = new JTextField(5);
                    JTextField jtf3 = new JTextField(5);
                    JTextField jtf4 = new JTextField(5);
                    JButton jbexit1 = new JButton("退出");
                    JButton jback1 = new JButton("确认");
                    nj1.add(j1);
                    nj1.add(j2);
                    nj1.add(j3);
                    nj1.add(j4);
                    nj1.add(jtf1);
                    nj1.add(jtf2);
                    nj1.add(jtf3);
                    nj1.add(jtf4);
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
                    jback1.setBounds(50, 250, 60, 40);
                    jbexit1.setBounds(120, 250, 60, 40);

                    jbexit1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            nj1.setVisible(false);
                            cur.setVisible(true);
                        }
                    });
                    jback1.addActionListener(new ActionListener() {
                        Renewal r = new Renewal();
                        Connection con = r.getConnection();

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String Cno = jtf1.getText().trim();
                            String Cis = jtf2.getText().trim();
                            String SUdate= jtf3.getText().trim();
                            int SUlocation = Integer.parseInt(jtf4.getText().trim());
                            try {
                                Statement stmt = null;
                                stmt = con.createStatement();
                                String sql;
                                sql = "UPDATE Depart SET DepartNo=? ,DepartName=?,DepartLocation=?,DepartSum=? WHERE DepartNo=?";
                                PreparedStatement ps = null;
                                ps = con.prepareStatement(sql);//添加数据预处理
                                ps.setString(1, Cno);
                                ps.setString(2, Cis);
                                ps.setString(3, SUdate);
                                ps.setInt(4, SUlocation);
                                ps.setString(5, array[0]);
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
                }

            }
        });
    }

    public static void main(String[] args) {

        Change c=new Change();
    }

}



