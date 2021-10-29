package com.liu.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        // 启动！
        MyFrame myFrame = new MyFrame();

    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        // 监听文本框输入的信息
        MyActionListener myActionListener = new MyActionListener();
        // 按下Enter，就会触发这个输入框的事件
        textField.addActionListener(myActionListener);

        // 设置替换编码
        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}
class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField field=(TextField)e.getSource();  // 获得一些资源,返回的一个对象
        System.out.println(field.getText());    // 获得输入框中的文本
        field.setText("");  // 回车触发事件之后清除输入文本
    }
}