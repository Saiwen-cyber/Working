package com.liu.lesson06;

import javax.swing.*;
import java.awt.*;

public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){
        Container container = this.getContentPane();

        JTextField textField1 = new JTextField("hello");
        JTextField textField2 = new JTextField("world",20);

        container.add(textField1,BorderLayout.NORTH);
        container.add(textField2,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500,250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
