package com.liu.lesson01;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args){
        Frame frame=new Frame();

        // 组件-按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button1");
        Button button3 = new Button("button1");

        // 设置为流式布局时
        // frame.setLayout(new FlowLayout());
        // 按钮靠窗口的左边
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // 设置窗口样式
        frame.setSize(200,200);
        frame.setVisible(true);

        // 添加按钮到窗口
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
    }

}
