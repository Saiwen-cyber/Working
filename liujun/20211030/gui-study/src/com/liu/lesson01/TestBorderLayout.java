package com.liu.lesson01;

import java.awt.*;

public class TestBorderLayout {
    public static void main(String[] args){
        Frame frame=new Frame("TestBorderLayout");

        // 新建按钮对象
        Button east=new Button("East");
        Button west=new Button("West");
        Button south=new Button("South");
        Button north=new Button("North");
        Button center=new Button("Center");

        // 添加按钮到窗口上
        frame.add(east,BorderLayout.EAST);
        frame.add(west,BorderLayout.WEST);
        frame.add(south,BorderLayout.SOUTH);
        frame.add(north,BorderLayout.NORTH);
        frame.add(center,BorderLayout.CENTER);

        // 设置窗口样式
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
