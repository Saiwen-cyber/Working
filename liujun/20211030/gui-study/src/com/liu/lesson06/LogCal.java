package com.liu.lesson06;

//import java.awt.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//public class FrameTest {
//    public static void main(String[] args) {
//        Frame frame=new Frame("4题");
//        // 布局的概念
//        Panel panel1=new Panel();
//        Panel panel2=new Panel();
//
//        Button button1=new Button("1");
//        Button button2=new Button("2");
//        Button button3=new Button("3");
//        Button button4=new Button("4");
//
//        // 设置布局
//        frame.setLayout(null);
//
//        // 坐标
//        frame.setBounds(300,300,500,500);
//
//        // panel设置坐标，相对于frame
//        panel1.setBounds(50,50,400,200);
//        panel1.setBackground(new Color(235, 71, 51));
//        panel2.setBounds(50,250,400,200);
//        panel2.setBackground(new Color(65, 207, 178));
//
//        // frame.add(panel)
//        frame.add(panel1);
//        frame.add(panel2);
//
//        panel1.add(button1);
//        panel1.add(button2);
//        panel2.add(button3);
//        panel2.add(button4);
//
//        frame.setVisible(true);
//
//        // 监听事件，监听窗口关闭事件 System.exit(0)
//        // 适配器模式：
//        frame.addWindowListener(new WindowAdapter() {
//            // 窗口点击关闭时需要做的事情
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // 结束程序
//                System.exit(0);
//            }
//        });
//    }
//}


import java.util.Scanner;

public class LogCal{
    private double cal(double value,double base) {
        return Math.log(value)/Math.log(base);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入变量x：");
        double x=in.nextDouble();
        double log=new LogCal().cal(x,2);
        System.out.println("最终结果："+log);
    }
}