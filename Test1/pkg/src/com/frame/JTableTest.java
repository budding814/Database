package com.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.*;

public class JTableTest extends JFrame {
    private JTable table;

    public static void main(String[] args) {
        JTableTest frame = new JTableTest();
        frame.setVisible(true);
    }

    public JTableTest() {
        super();
        setTitle("操作表格");// 窗体名称
        setBounds(200, 200, 1000, 740);// 窗体大小
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();

        String[] columnNames = { "A1", "B1", "C", "D", "E", "F", "G" };// 定义表格列
        String[][] tableValues = new String[20][columnNames.length];// 定义数组，用来存储表格数据

        for (int row = 0; row < tableValues.length; row++) {
            for (int column = 0; column < columnNames.length; column++) {
                tableValues[row][column] = columnNames[column] + row;// 给表格赋值
            }
        }
        JTable table = new JTable(tableValues, columnNames);
        JScrollPane sc = new JScrollPane(table);
        c.add(table, BorderLayout.CENTER);

        table.setSelectionForeground(Color.RED);// 设置前景色，字体颜色
        table.setBackground(Color.PINK);
        table.setSelectionBackground(Color.yellow);// 背景色
        table.setRowHeight(30);// 设置行高30像素
        /*
         * ListSelectionModel.SINGLE_SELECTION 单选
         */
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 选择模式

        System.out.println("表格共有" + table.getRowCount() + "行" + table.getColumnCount() + "列");

    }

}