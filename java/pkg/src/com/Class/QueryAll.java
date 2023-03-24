package com.Class;
import com.Stu.Choose;
import com.Stu.Query;
import com.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryAll extends  JFrame{
    QueryAll(){
        JButton jbexit=new JButton("退出");
        //初始化界面
        JFrame cur=new JFrame();
        cur.setTitle("所有班级信息");
        cur.setVisible(true);
        cur.setSize(1000,800);
        cur.setLayout(null);
        cur.setLocationRelativeTo(null);
        //初始化定义表格
        String[][] tableValues = new String[23][5];
        String[] columnNames = { "班号", "系名", "专业名", "人数", "入校年份"};
        tableValues[0][0]="班号";
        tableValues[0][1]="系名";
        tableValues[0][2]="专业名";
        tableValues[0][3]="人数";
        tableValues[0][4]="入校年份";

         //与数据库进行联系
        Renewal r=new Renewal();
        Connection conn=r.getConnection();
        int index=1;
        try{
            PreparedStatement sql=conn.prepareStatement("select * from Class");
            ResultSet res=sql.executeQuery();
            while(res.next()){
                String Cno =res.getString("Cno");
                String Cis=res.getString("Cis");
                String Cdept=res.getString("Cdept");
                String Cnumber= String.valueOf(res.getInt("Cnumber"));
                String Ctime=res.getString("Ctime");
                tableValues[index][0]=Cno;
                tableValues[index][1]=Cis;
                tableValues[index][2]=Cdept;
                tableValues[index][3]=Cnumber;
                tableValues[index][4]=Ctime;
                index++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JTable JT=new JTable(tableValues,columnNames);
        cur.add(JT);
        JT.setBounds(0,0,1000,700);
        cur.add(jbexit);
        jbexit.setBounds(900,700,60,30);
        JT.setGridColor(Color.GREEN);
        JT.setSelectionForeground(Color.RED);// 设置前景色，字体颜色
        JT.setBackground(Color.PINK);
        JT.setSelectionBackground(Color.yellow);// 背景色
        JT.setRowHeight(30);// 设置行高30像素
        JT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cur.setVisible(false);
                Menu c1=new Menu();
            }
        });
    }

    public static void main(String[] args) {
        QueryAll a=new QueryAll();
    }

}
