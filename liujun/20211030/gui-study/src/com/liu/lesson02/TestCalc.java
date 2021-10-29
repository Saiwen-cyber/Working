package com.liu.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 简易计算器
public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();

    }
}
// 计算器类
class Calculator extends Frame{
    // 属性
    TextField num1,num2,num3;
    // 方法
    public void loadFrame(){
        // 3个文本框
        num1 = new TextField(10);    // 字符数
        num2 = new TextField(10);    // 字符数
        num3 = new TextField(20);    // 字符数
        // 1个按钮
        Button button = new Button("=");
        button.addActionListener(new MyCalculatorListener());
        // 1个标签
        Label label = new Label("+");

        // 布局
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        // 样式
        pack();
        setVisible(true);
        setLocation(400,350);
        setSize(500,100);
        setTitle("简易计算器");
    }
    // 监听器类
    private class MyCalculatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 1.获得加数和被加数
            int n1=Integer.parseInt(num1.getText());
            int n2=Integer.parseInt(num2.getText());
            // 2.将这个值+法运算后，放到第三个框
            num3.setText(""+(n1+n2));
            // 3.清除前两个框
            num1.setText("");
            num2.setText("");
        }
    }
}

