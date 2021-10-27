import sun.net.www.content.text.plain;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //监听类 鼠标左键点击窗口中的按钮可触发
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; //下拉列表，选谁谁显示
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//画图面板菜单
public class drawboard extends JFrame implements  ActionListener{
    private JToolBar button_panel;// 按钮面板
    private JMenuBar menuBar;// 菜单条
    private JMenu  color, stroke;// 菜单（颜色，编辑）
    private JMenuItem colorchoice, cancel,narrow,enlarge;//颜色，编辑，菜单项
    private JLabel startbar;// 状态栏
    private DrawArea drawArea;// 画布


    private String[] icon_path = {
            "src/icons/pan.png", "src/icons/rect.png", "src/icons/frect.png", "src/icons/oval.png",
            "src/icons/foval.png", "src/icons/circle.png", "src/icons/fcircle.png", "src/icons/roundrect.png",
            "src/icons/froundrect.png", "src/icons/color.png", "src/icons/stroke.png" };
    private Icon[] icons;
    private String Prompt_message[] = {  "铅笔",  "空心矩形", "实心矩形", "空心椭圆", "实心椭圆",
            "空心圆", "实心圆", "空心圆角矩形", "实心圆角矩形", "颜色", "线条粗细" };
    JButton[] button;// 工具条中的按钮组
    private JButton bold, italic, plain;// 字体格式

    public drawboard(String string){
        super(string);

        //
        color=new JMenu("颜色");
        stroke=new JMenu("编辑");

        //生成菜单条
        menuBar=new JMenuBar();
        menuBar.add(color);
        menuBar.add(stroke);

        this.setJMenuBar(menuBar);
        //标题传入
        this.setTitle(string);

        //菜单项注册监听
        //颜色
        colorchoice = new JMenuItem("调色板");
        color.add(colorchoice);
        colorchoice.addActionListener(this);
        //编辑
        cancel = new JMenuItem("撤回");
        stroke.add(cancel);
        cancel.addActionListener(this);

        enlarge = new JMenuItem("放大");
        narrow = new JMenuItem("缩小");
        stroke.add(enlarge);
        stroke.add(narrow);
        enlarge.addActionListener(this);
        narrow.addActionListener(this);

        //工具栏
        button_panel = new JToolBar("工具箱",JToolBar.HORIZONTAL);
        button_panel.setBackground(Color.black);
        icons = new ImageIcon[icon_path.length];//按钮图标数组
        button = new JButton[icon_path.length];


        for (int i = 0; i < icon_path.length; i++) {
            icons[i] = new ImageIcon(icon_path[i]);
            button[i] = new JButton(icons[i]);
            button[i].setToolTipText(Prompt_message[i]);

            button_panel.add(button[i]);
            button[i].setBackground(Color.white);
            button[i].addActionListener(this);
        }






        startbar = new JLabel("坐标");
        startbar.setFont(new Font("Serief", Font.ITALIC + Font.BOLD, 25));
        startbar.setForeground(Color.red);

        drawArea = new DrawArea(this);

        Container con = getContentPane();
        con.add(button_panel, BorderLayout.NORTH);
        con.add(drawArea, BorderLayout.CENTER);
        con.add(startbar, BorderLayout.SOUTH);

        Toolkit tool = getToolkit();
        Dimension dim = tool.getScreenSize();
        setBounds(100, 100, dim.width - 200, dim.height - 200);
        setVisible(true);
        validate();// 参数校验
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    //给图片传入方法
    public void setStratBar(String s) {
        startbar.setText(s);
    }//鼠标状态标签栏

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <= 8; i++) {
            if (e.getSource() == button[i]) {
                drawArea.setCurrentchoice(i);
                drawArea.createNewitem();
                drawArea.repaint();
            }
        }
          if (e.getSource() == colorchoice || e.getSource() == button[9]) {
            drawArea.chooseColor();
        } else if (e.getSource() == button[10]) {
            drawArea.setStroke();
        } else if (e.getSource() == button[11]) {
            drawArea.setCurrentchoice(11);
            drawArea.createNewitem();
            drawArea.repaint();
        }else if (e.getSource()==cancel){
            drawArea.ReturnIndex();
            drawArea.createNewitem();
            drawArea.repaint();
        }else if (e.getSource()==enlarge){
            drawArea.enlarge();
            drawArea.createNewitem();
            drawArea.repaint();

        }else if (e.getSource()==narrow){
            drawArea.narrow();
            drawArea.createNewitem();
            drawArea.repaint();
        }

    }

 }




