package com.use;

import com.Class.Menu;
import com.sql.Renewal;
import com.SU.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class Table extends JFrame {
    public void ShowTable(String str,String sql_str,String tableValues[][],String[] columnNames){
        JFrame cur =new JFrame();
        cur.setSize(1000,800);
        cur.setLayout(null);
        cur.setVisible(true);
        cur.setLocationRelativeTo(null);
        cur.setTitle(str+"信息");
        Renewal r=new Renewal();
        Connection con=r.getConnection();
        try{
            String sql;
            sql="select * from ?";
            PreparedStatement ps=null;
            ps=con.prepareStatement(sql);//添加数据预处理
            ps.setString(1,sql_str);
            ResultSet res=ps.executeQuery();
            int index=1;
            while(res.next()){
                String Cno =res.getString("SUno");
                String Cnumber= String.valueOf(res.getInt("SUnumber"));
                tableValues[index][0]=Cno;
                tableValues[index][1]=Cnumber;
                index++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JButton jbexit=new JButton("退出");
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
                com.SU.Menu c1= new com.SU.Menu();

            }
        });
    }
}
