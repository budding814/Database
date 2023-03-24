package com.SU;

import com.frame.MenuFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    public Menu(){
        JFrame cur=new JFrame();
        cur.setTitle("功能菜单");
        cur.setSize(260,380);
        cur.setLayout(null);
        cur.setLocationRelativeTo(null);
        cur.setVisible(true);
        JButton JQueryAll=new JButton("查询所有学会");
        JButton JQuery=new JButton("查询学会信息");
        JButton JAdd=new JButton("增加学会信息");
        JButton JChange=new JButton("修改学会信息");
        JButton JDelete=new JButton("删除学会信息");
        JButton JExit=new JButton("退出");
        cur.add(JQueryAll);
        cur.add(JQuery);
        cur.add(JAdd);
        cur.add(JChange);
        cur.add(JDelete);
        cur.add(JExit);
        JQueryAll.setBounds(50,20,150,30);
        JQuery.setBounds(50,60,150,30);
        JAdd.setBounds(50,100,150,30);
        JChange.setBounds(50,140,150,30);
        JDelete.setBounds(50,180,150,30);
        JExit.setBounds(90,230,60,40);
        JQueryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cur.setVisible(false);
                QueryAll qa=new QueryAll();
            }
        });
        JQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cur.setVisible(false);
                Query q=new Query();
            }
        });
        JAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cur.setVisible(false);
                Add a=new Add();
            }
        });
        JChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Change c=new Change();
            }
        });
        JDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cur.setVisible(false);
                Delete d=new Delete();
            }
        });
        JExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame M=new MenuFrame();
                cur.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        Menu m=new Menu();
    }
}
