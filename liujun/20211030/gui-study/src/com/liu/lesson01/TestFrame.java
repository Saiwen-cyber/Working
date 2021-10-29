package com.liu.lesson01;

import java.awt.*;

// GUI的第一个界面
public class TestFrame {
    public static void main(String[] args){
        // Frame, JDK, 看源码！
        Frame frame = new Frame("我的第一个Java图形界面窗口");

        // 需要设置可见性  w h
        frame.setVisible(true);

        // 设置窗口大小
        frame.setSize(400,400);

        // 设置背景颜色   color
        frame.setBackground(new Color(65, 133, 73));

        // 弹出的初始位置
        frame.setLocation(200,200);

        // 设置大小固定
        frame.setResizable(false);

    }
}
