package com.liu.snake;

import javax.swing.*;

// 游戏的主启动类
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(200,150,700,520);
        frame.setResizable(false);  // 窗口大小不可变
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 正常游戏界面都应该在面上
        frame.add(new GamePanel());

        frame.setVisible(true);
    }
}
