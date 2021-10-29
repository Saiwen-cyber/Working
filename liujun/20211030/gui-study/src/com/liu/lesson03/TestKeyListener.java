package com.liu.lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}
class KeyFrame extends Frame{
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            // 键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                // 获得键盘按下的键
                int keyCode = e.getKeyCode();// 获得当前键盘的值，不需要去记录这个值，直接使用静态属性 VK_XXX
                System.out.println(keyCode);
                if(keyCode==KeyEvent.VK_UP){
                    System.out.println("你按下了上键");
                }
                // 根据按下的不同操作，产生不同的结果
            }
        });
    }
}