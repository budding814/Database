package com.frame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddFrame extends JFrame implements  ActionListener{
    JTextField jtf1,jtf2,jtf3;//文本框，显示数字
    JButton jbAdd;
    JButton jbClear;
    //Java构造方法
    public AddFrame(){
        jtf1=new JTextField(5);//长度为5
        JLabel j1=new JLabel("+");//文字标签
        jtf2=new JTextField(5);
        jtf3=new JTextField(6);
        jtf3.setEditable(false);
        jbAdd=new JButton("=");
        jbAdd.addActionListener(this);
        jbClear=new JButton("清除");
        jbClear.addActionListener(this);
        add(jtf1);
        add(j1);
        add(jtf2);
        add(jbAdd);
        add(jtf3);
        add(jbClear);
        //窗口属性
        setLayout(new FlowLayout());
        setSize(180,200);
        setLocationRelativeTo(null);
        setTitle("加法计数器");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JButton jbTemp=(JButton) e.getSource();
        if(jbTemp==jbAdd){
            int x=Integer.parseInt(jtf1.getText());
            int y=Integer.parseInt(jtf2.getText());
            jtf3.setText(x+y+"");
        }else if(jbTemp==jbClear){
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
        }

    }
    public static void main(String[] args){
        new AddFrame();
    }
}
