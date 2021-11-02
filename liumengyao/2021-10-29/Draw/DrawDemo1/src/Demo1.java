import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo1 extends JFrame {

    private static final long serialVersionUID = 1L;

    //创建绘图面板

    class Plot extends JPanel {

        public void paint(Graphics gp) {

            //笔画属性，

            BasicStroke bs = new BasicStroke(10.1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

            super.paint(gp);

            Graphics2D gp2d = (Graphics2D) gp;

            gp2d.setColor(Color.blue);

            //第一个点的x坐标，第一个点的y坐标，第二个点的x坐标，第二点的坐标

            gp2d.drawLine(30, 30, 80, 30);

            //绘制矩形的x坐标，绘制矩形的y坐标，矩形的宽度，矩形的高度

            gp2d.drawRect(10, 50, 100, 50);

            //绘制矩形的x坐标，绘制矩形的y坐标，矩形的宽度，矩形的高度,4个角弧度的水平直径，4个角弧度的垂直直径

            gp2d.drawRoundRect(10, 120, 100, 70, 12, 12);

            gp2d.setColor(Color.black);

            gp2d.fillOval(20, 130, 30, 20);

            gp2d.fillOval(70, 130, 30, 20);

            gp2d.setColor(Color.gray);

            gp2d.fillArc(35, 160, 40, 25, 100, 270);

            Color c1 = new Color(22, 147, 140);//创建红绿蓝不透明的srgb颜色

            gp2d.setColor(c1);

            gp2d.drawOval(10, 200, 100, 60);//绘制椭圆的边框。

            //Graphics2D d=(Graphics2D) gp;

            gp2d.fill3DRect(150, 30, 100, 80, false);

            gp2d.fillOval(150, 130, 100, 80);

            gp2d.setStroke(bs);//设置笔画属性

            gp2d.drawLine(300, 80, 300, 200);

        }

    }
    //初始化窗体

    private void initialize() {

        this.setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭模式

        setContentPane(new Plot());

        this.setTitle("绘图小Demo");

        this.setLocationRelativeTo(null);//窗体居中

        this.setVisible(true);//设置窗体的可见性


    }

    public Demo1() {

        super();

        initialize();

    }

    public static String getNum(int num1, int num2) {

        //返回num1到num2之间的随机数

        Integer rand = num1 + (int) (Math.random() * (num2 - num1));

        //System.out.println(rand);

        int a = (int) (Math.random() * 100);

        //返回a~z随机的字符

        char char1 = (char) ('a' + Math.random() * ('z' - 'a' + 1));

        //返回A~Z随机的字符

        char char2 = (char) ('a' + Math.random() * ('Z' - 'A'));

        return rand.toString() + char1 + char2;

    }


    public static void main(String[] args) throws FileNotFoundException, IOException {

        // TODO Auto-generated method stub

        //获取图片缓冲区

        BufferedImage bi = new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);

        //得到绘制坏境(这张图片的笔)

        Graphics gh = (Graphics) bi.getGraphics();

        gh.setColor(Color.WHITE);//设置颜色

        gh.fillRect(0, 0, 80, 40);//填充整张图片(其实就是设置背景色)

        gh.setColor(Color.lightGray);

        //gh.drawRoundRect(0, 0, 130, 70, 130, 70);//绘制一个圆形边框

        gh.drawRect(0, 0, 80 - 1, 40 - 1);//绘制一个四边形边框

        gh.setFont(new Font("Bernard MT", Font.BOLD, 18));//字体样式 字体格式 字体大小

        gh.setColor(Color.BLUE);//设置字体颜色

        gh.drawString(getNum(10, 100), 22, 25);//向图片上写随机字符串

        ImageIO.write(bi, "PNG", new FileOutputStream("D:/test.png"));//把图片输出到指定路径
    }
}

