package com.liu.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJframe2().init();
    }
}
class MyJframe2 extends JFrame{
    public void init(){
        // 顶级窗口
        this.setVisible(true);
        this.setBounds(10,10,200,300);

        // 设置文字 JLabel
        JLabel label = new JLabel("欢迎来到我的世界");
        this.add(label);

        // 让文本标签居中
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // 获得一个容器
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.BLUE);
    }
}
