package com.frame;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LoadingFrame extends JFrame{
    public LoadingFrame(){
        setTitle("登录窗口");
        setLayout(null);//设置绝对布局
        Container c=getContentPane();

        final JTextField jtf1=new JTextField();
        final JPasswordField jpf1=new JPasswordField();
        JLabel jl1=new JLabel("用户名: ");
        JLabel jl2=new JLabel("密码: ");
        JButton jb1=new JButton("确定");
        JButton jb2=new JButton("取消");
        String LoginName="moon";
        String LoginPassword="Yml456123@";
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=jtf1.getText().trim();
                String psw=new String(jpf1.getPassword());
                if(jtf1.getText().trim().length()==0||new String(jpf1.getPassword()).trim().length()==0){
                    JOptionPane.showMessageDialog(null,"不能为空！");
                }else{
                    if(name.equals(LoginName)&&psw.equals(LoginPassword)){
                        System.out.println("欢迎来到SQL");
                        setVisible(false);
                        MenuFrame M=new MenuFrame();
                    }else{
                        JFrame error=new JFrame();
                        error.setTitle("错误");
                        error.setVisible(true);

                        error.setSize(300,170);
                        JButton exit=new JButton("确定");
                        JLabel j=new JLabel("您输入的信息有误，请重新输入");

                        error.setLayout(null);
                        error.setLocationRelativeTo(null);
                        error.add(exit);
                        error.add(j);
                        j.setBounds(20,10,200,30);
                        exit.setBounds(120,50,60,40);
                        exit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                error.setVisible(false);
                                jtf1.setText("");
                                jpf1.setText("");

                            }
                        });
                    }

                }


            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=JOptionPane.showConfirmDialog(null,"你确定要退出本系统吗？");
                if(i==0){
                    System.exit(0);
                }

            }
        });
        c.add(jl1);
        c.add(jtf1);
        c.add(jl2);
        c.add(jpf1);
        c.add(jb1);
        c.add(jb2);
        jl1.setBounds(10,20,50,30);
        jtf1.setBounds(60,20,210,30);
        jl2.setBounds(25,60,90,30);
        jpf1.setBounds(60,60,210,30);
        jb1.setBounds(80,100,70,50);
        jb2.setBounds(150,100,70,50);
        int width=300;
        int height=200;
        setSize(300,200);
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
        LoadingFrame lf=new LoadingFrame();
    }
}
