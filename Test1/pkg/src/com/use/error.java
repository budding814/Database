package com.use;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class error extends JFrame {
    public void err(JFrame cur){
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
                cur.setVisible(true);
            }
        });
    }
}
