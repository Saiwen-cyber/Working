package com.liu.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String[] args){
        // 按下按钮，触发一些事件
        Frame frame = new Frame();
        Button button = new Button();

        // 因为addActionListener()需要一个MyActionListenter，所以我们需要构造一个MyActionListenter
        MyActionListenter myActionListenter = new MyActionListenter();
        button.addActionListener(myActionListenter);

        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        windowClose(frame); // 关闭窗口
        frame.setVisible(true);


    }
    // 关闭窗口的事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
// 事件监听
class MyActionListenter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}