package com.Stu;
import com.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryAll extends JFrame{
    JButton jbexit=new JButton("退出");
    Container c = getContentPane();
    public QueryAll(){

        setTitle("学生全体信息");
        setSize(1000, 800);// 窗体大小
        setLayout(null);

        String[] columnNames = { "学号", "姓名", "年龄", "系", "班级", "宿舍" };// 定义表格列
        String[][] tableValues = new String[23][7];
        tableValues[0][0]="学号";
        tableValues[0][1]="姓名";
        tableValues[0][2]="年龄";
        tableValues[0][3]="系";
        tableValues[0][4]="班级";
        tableValues[0][5]="宿舍";
        Renewal r=new Renewal();
        int i=1;
        Connection con =r.getConnection();
        try{
            PreparedStatement sql=con.prepareStatement("select * from Stu");
            ResultSet res=sql.executeQuery();
            while(res.next()){
                String Sno =res.getString("Sno");
                String Sname=res.getString("Sname");
                String Sage=res.getString("Sage");
                String Sdept=res.getString("Sdept");
                String Sclass=res.getString("Sclass");
                String Sdorm=res.getString("Sdorm");
                tableValues[i][0]=Sno;
                tableValues[i][1]=Sname;
                tableValues[i][2]=Sage;
                tableValues[i][5]=Sdorm;
                tableValues[i][3]=Sdept;
                tableValues[i][4]=Sclass;
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JTable table = new JTable(tableValues, columnNames);

        c.add(table);
        table.setBounds(0,0,1000,700);
        c.add(jbexit);
        jbexit.setBounds(900,700,60,30);
        //c.add(jbexit);
        //jbexit.setSize(6,3);
        table.setGridColor(Color.GREEN);
        table.setSelectionForeground(Color.RED);// 设置前景色，字体颜色
        table.setBackground(Color.PINK);
        table.setSelectionBackground(Color.yellow);// 背景色
        table.setRowHeight(30);// 设置行高30像素
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式
        int width=1000;
        int height=800;
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenWidth=screenSize.width;
        int screenHeight=screenSize.height;
        setLocation(screenWidth/2-width/2,screenHeight/2-height/2);
        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Choose c1=new Choose();
                setVisible(false);
            }
        });
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        QueryAll r=new QueryAll();
    }

}
