package com.liu.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// panel可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args){
        Frame frame=new Frame();
        // 布局的概念
        Panel panel=new Panel();

        // 设置布局
        frame.setLayout(null);

        // 坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(64, 185, 49));

        // panel设置坐标，相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(235, 71, 51));

        // frame.add(panel)
        frame.add(panel);

        frame.setVisible(true);

        // 监听事件，监听窗口关闭事件 System.exit(0)
        // 适配器模式：
        frame.addWindowListener(new WindowAdapter() {
            // 窗口点击关闭时需要做的事情
            @Override
            public void windowClosing(WindowEvent e) {
                // 结束程序
                System.exit(0);
            }
        });

    }
}
