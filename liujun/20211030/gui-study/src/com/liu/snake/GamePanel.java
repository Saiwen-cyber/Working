package com.liu.snake;

import javax.swing.*;
import java.awt.*;

// 游戏的面板
public class GamePanel extends JPanel {
    // 绘制的面板,我们游戏中的所有东西都用这个画笔
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);    // 清屏
        this.setBackground(Color.BLACK);
    }
}
