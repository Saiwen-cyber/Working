package com.liu.lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestComboboxDemo02 extends JFrame {
    public TestComboboxDemo02(){
        Container container = this.getContentPane();

        // 生成列表的内容
//        String[] contents={"1","2","3"};

        Vector contents = new Vector();
        // 列表中放入内容
        JList jList = new JList(contents);
        contents.add("张三");
        contents.add("李四");
        contents.add("王五");

        container.add(jList);

        this.setVisible(true);
        this.setSize(500,250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboboxDemo02();
    }
}
