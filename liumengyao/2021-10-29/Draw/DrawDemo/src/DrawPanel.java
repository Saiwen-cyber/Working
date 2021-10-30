import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawPanel extends JPanel {
    DrawFrame drawFrame;
    Shape[] shapes = new Shape[10000];  //图形数组
    int index = 0;                      //图形号码
    int R = 240, G = 150, B = 9;        //颜色，红绿蓝
    float width = 5;                    //线宽
    private int currentChoice = 1;      //默认为铅笔
    private Color col;                  //线条颜色

    DrawPanel(DrawFrame drawFrame) {    //构造函数
        this.drawFrame = drawFrame;
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));  //设置光标颜色
        setBackground(Color.WHITE);
        addMouseListener(new MouseAction());
        addMouseMotionListener(new MouseMotion());
        createNewShape();
    }

    //调用 shape 中的 draw
    void draw(Graphics2D g2d, Shape shape){
        shape.draw(g2d);
    }

    //绘制背景
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        int i = 0;
        while (i<=index){
            draw(g2d,shapes[i]);
            i++;
        }
    }

    void createNewShape(){
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        switch (currentChoice){
            case 1:shapes[index] = new pencil();break;
            case 2:shapes[index] = new Line();break;
            case 3:shapes[index] = new Rectangle();break;
            case 4:shapes[index] = new RoundRectangel();break;
            case 5:shapes[index] = new Oval();break;
            case 6:shapes[index] = new Triangle();break;
        }
        shapes[index].R = R;
        shapes[index].G = G;
        shapes[index].B = B;
        shapes[index].width = width;
    }

    //设置线条粗细
    public void setWidth(){
        String widthInput;
        widthInput = JOptionPane.showInputDialog("请输入线宽");//输入框
        try{
            width = Float.parseFloat(widthInput);             //转为float
        }catch (Exception e){
            width = 1.0f;
        }
        shapes[index].width = width;
    }

    public void chooseColor(){
        col = JColorChooser.showDialog(this,"请选择颜色",col);//选择颜色
        try{
            R = col.getRed();
            G = col.getGreen();
            B = col.getBlue();
        } catch (Exception e){
            shapes[index].R = 240;
            shapes[index].G = 150;
            shapes[index].B = 9;
        }
        shapes[index].R = R;
        shapes[index].G = G;
        shapes[index].B = B;
    }

    //设置当前画板画笔状态
    public void setCurrentChoice(int i){
        currentChoice = i+1;
    }

    //撤回
    public void ReturnIndex(){
        if (index>0){
            this.index--;
        }
    }

    //全部清除
    public void RemoveAll(){
        int choice = JOptionPane.showConfirmDialog(
                null, "确认要清空画板吗?", "是否清空画板", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            this.index = 0;
            JOptionPane.showMessageDialog(new JFrame(),"已清空");
        } else if (choice == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(new JFrame(), "已取消");
        }

    }

    //鼠标事件
    class MouseAction extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            drawFrame.setStatusBar(e.getX() + "," + e.getY() + " 像素");
            shapes[index].x1 = shapes[index].x2 = e.getX();
            shapes[index].y1 = shapes[index].y2 = e.getY();

            if (currentChoice == 1){
                shapes[index].x1 = shapes[index].x2 = e.getX();
                shapes[index].y1 = shapes[index].y2 = e.getY();
                index++;
                createNewShape();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            drawFrame.setStatusBar(e.getX() + "," + e.getY() + " 像素");
            if (currentChoice==1){
                shapes[index].x1 = e.getX();
                shapes[index].y1 = e.getY();
            }
            shapes[index].x2 = e.getX();
            shapes[index].y2 = e.getY();
            repaint();
            index++;
            createNewShape();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            super.mouseClicked(e);
            drawFrame.setStatusBar(e.getX() + "," + e.getY() + " 像素");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            drawFrame.setStatusBar(e.getX() + "," + e.getY() + " 像素");
        }

    }

    //鼠标拖动和移动时的响应
    class  MouseMotion extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            drawFrame.setStatusBar(e.getX() + "," + e.getY() + " 像素");
            if (currentChoice==1){
                shapes[index-1].x1=shapes[index].x2 = shapes[index].x1=e.getX();
                shapes[index-1].y1=shapes[index].y2 = shapes[index].y1=e.getY();
                index++;
                createNewShape();
            }else {
                shapes[index].x2 = e.getX();
                shapes[index].y2 = e.getY();
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            drawFrame.setStatusBar(e.getX() + "," + e.getY() + " 像素");
        }
    }
}
