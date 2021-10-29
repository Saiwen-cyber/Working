package com.liu.lesson01;

import java.awt.*;

public class TestGridLayout {
    public static void main(String[] args){
        Frame frame=new Frame("TestGridLayout");

        // 新建按钮对象
        Button btn1=new Button("btn1");
        Button btn2=new Button("btn2");
        Button btn3=new Button("btn3");
        Button btn4=new Button("btn4");
        Button btn5=new Button("btn5");
        Button btn6=new Button("btn6");

        frame.setLayout(new GridLayout(3,2));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

        frame.pack();   // java的函数 将布局选择最优位置来确定
        frame.setVisible(true);
    }
}
