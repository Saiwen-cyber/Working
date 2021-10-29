package com.liu.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestExersize {
    public static void main(String[] args){
        // 总窗口布局
        Frame frame=new Frame("练习");
        frame.setVisible(true);
        frame.setSize(400,300);
        frame.setLocation(400,300);
        frame.setBackground(Color.blue);
        frame.setLayout(new GridLayout(2,1));

        // 4个面板
        Panel p1=new Panel(new BorderLayout());
        Panel p2=new Panel(new GridLayout(2,1));
        Panel p3=new Panel(new BorderLayout());
        Panel p4=new Panel(new GridLayout(2,2));

        // 把按钮放到面板
        p1.add(new Button("East-1"),BorderLayout.EAST);
        p1.add(new Button("West-1"),BorderLayout.WEST);
        p2.add(new Button("p2-btn-1"));
        p2.add(new Button("p2-btn-2"));
        // 把p2装到p1
        p1.add(p2,BorderLayout.CENTER);

        p3.add(new Button("East-2"),BorderLayout.EAST);
        p3.add(new Button("West-2"),BorderLayout.WEST);
        for(int i=0;i<4;i++){
            p4.add(new Button("for-"+i));
        }
        // 把p4装到p3
        p3.add(p4,BorderLayout.CENTER);

        // 把面板放到窗口
        frame.add(p1);
        frame.add(p3);

        // 监听窗口关闭
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
