import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawFrame extends JFrame implements ActionListener {
    private JToolBar buttonPanel; //选择面板（存放button）
    private DrawPanel drawPanel;  //画板区域
    private JLabel statusBar;     //鼠标状态栏

    private String[] iconPath = {
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\pencil.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\line.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\rectangle.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\roundrectangle.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\oval.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\triangle.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\cancel.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\width.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\colorchooce.png",
        "D:\\workspace\\IdeaProjects\\Draw\\DrawDemo\\src\\icons\\removeall.png"
    };
    private Icon[] icons;
    private String promptMessage[] = { "铅笔","直线", "矩形","圆角矩形", "椭圆", "三角形", "撤回","线宽", "颜色", "清空" };
    private JButton[] buttons;// 工具条中的按钮组

    public DrawFrame(String str) {
        //标题
        super(str);
        this.setTitle(str);

         // 菜单初始化
        buttonPanel = new JToolBar("工具栏",JToolBar.HORIZONTAL);
        buttonPanel.setBackground(Color.lightGray);
        icons = new ImageIcon[iconPath.length];
        buttons = new JButton[iconPath.length];

        for (int i = 0; i < iconPath.length; i++) {
            icons[i] = new ImageIcon(iconPath[i]);
            buttons[i] = new JButton(icons[i]);
            buttons[i].setToolTipText(promptMessage[i]);

            buttonPanel.add(buttons[i]);
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener( this);
        }

        statusBar = new JLabel("鼠标位置");
        statusBar.setOpaque(true);
        statusBar.setBackground(Color.lightGray);

        drawPanel = new DrawPanel(this);

        Container con = getContentPane();
        con.add(buttonPanel, BorderLayout.NORTH);
        con.add(drawPanel, BorderLayout.CENTER);
        con.add(statusBar,BorderLayout.SOUTH);

        Toolkit tool = getToolkit();
        Dimension dim = tool.getScreenSize();
        setBounds(400, 220, dim.width - 900, dim.height - 400);
        setVisible(true);
        validate();// 参数校验
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //actionListener
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < iconPath.length-4; i++) {
            if (e.getSource() == buttons[i]) {
                drawPanel.setCurrentChoice(i);
                drawPanel.createNewShape();
                drawPanel.repaint();
            }
        }
        if(e.getSource()==buttons[iconPath.length-4]){  //撤回
            drawPanel.ReturnIndex();
            drawPanel.createNewShape();
            drawPanel.repaint();
        }else if(e.getSource()==buttons[iconPath.length-3]){   // 选择线条粗细
            drawPanel.setWidth();
            drawPanel.createNewShape();
            drawPanel.repaint();
        }else if(e.getSource()==buttons[iconPath.length-2]){   // 选颜色
            drawPanel.chooseColor();
            drawPanel.createNewShape();
            drawPanel.repaint();
        }else if(e.getSource()==buttons[iconPath.length-1]){   // 全部清除
            drawPanel.RemoveAll();
            drawPanel.createNewShape();
            drawPanel.repaint();
        }
    }

    //鼠标状态栏
    public void setStatusBar(String s) {
        statusBar.setText(s);
    }
}
