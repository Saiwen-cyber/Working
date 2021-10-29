package com.liu.lesson04;

import javax.swing.*;

public class JFrameDemo {
    // init（）：初始化
    public void init(){
        // 顶级窗口
        JFrame jframe = new JFrame("这是一个JFrame窗口");
        jframe.setVisible(true);
        jframe.setBounds(100,100,200,200);

        // 设置文字 JLabel
        JLabel label = new JLabel("欢迎来到我的世界");
        jframe.add(label);

        // 关闭事件
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // 建立一个窗口
        new JFrameDemo().init();
    }
}
