package com.liu.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame{
    public JButtonDemo02(){
        // 获取容器
        Container container = this.getContentPane();
        // 将一个图片变为图标
        URL resource = JButtonDemo02.class.getResource("tx.jpg");
        Icon icon=new ImageIcon(resource);

        // 单选框
        JRadioButton jRadioButton01 = new JRadioButton("JRadioButton01");
        JRadioButton jRadioButton02 = new JRadioButton("JRadioButton02");
        JRadioButton jRadioButton03 = new JRadioButton("JRadioButton03");

        // 由于单选框只能选择一个，分组
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton01);
        group.add(jRadioButton02);
        group.add(jRadioButton03);

        container.add(jRadioButton01,BorderLayout.CENTER);
        container.add(jRadioButton02,BorderLayout.NORTH);
        container.add(jRadioButton03,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
