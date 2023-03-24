package com.SU;

import com.sql.Renewal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class view {
    view(){
        String[][] tableValues = new String[23][2];
        String[] columnNames = { "学会名", "人数"};
        tableValues[0][0]="学会名";
        tableValues[0][1]="人数";
        JFrame cur =new JFrame();
        cur.setSize(500,800);
        cur.setLayout(null);
        cur.setVisible(true);
        cur.setLocationRelativeTo(null);
        cur.setTitle("视图信息");
        Renewal r=new Renewal();
        Connection con=r.getConnection();
        try{
            PreparedStatement sql=con.prepareStatement("select * from view1");
            ResultSet res=sql.executeQuery();
            int index=1;
            while(res.next()){
                String Cno =res.getString("name1");
                String Cname= String.valueOf(res.getInt("num"));


                tableValues[index][0]=Cno;
                tableValues[index][1]=Cname;
                index++;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        JButton jbexit=new JButton("退出");
        JTable JT=new JTable(tableValues,columnNames);
        cur.add(JT);
        JT.setBounds(0,0,500,700);
        cur.add(jbexit);
        jbexit.setBounds(400,700,60,30);
        JT.setGridColor(Color.GREEN);
        JT.setSelectionForeground(Color.RED);// 设置前景色，字体颜色
        JT.setBackground(Color.PINK);
        JT.setSelectionBackground(Color.yellow);// 背景色
        JT.setRowHeight(30);// 设置行高30像素
        JT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JT.setVisible(false);
                cur.setVisible(false);
                Menu m=new Menu();
            }
        });

    }

    public static void main(String[] args) {
        view v=new view();
    }

}
