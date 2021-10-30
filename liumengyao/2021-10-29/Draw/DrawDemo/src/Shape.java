import java.awt.*;

public class Shape {
    int x1,y1,x2,y2;  // 斜对角的两个点
    int R = 240, G = 150, B = 9;       //颜色，红绿蓝
    float width;      //线宽

    void draw(Graphics2D g) {}
}
//铅笔
class pencil extends Shape{
    void draw(Graphics2D g){
        g.setPaint(new Color(R,G,B));
        g.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
        g.drawLine(x1,y1,x2,y2);
    }
}
//直线
class Line extends Shape {
    void draw(Graphics2D g) {
        g.setPaint(new Color(R,G,B));
        g.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
        g.drawLine(x1,y1,x2,y2);
    }
}

//矩形
class Rectangle extends Shape {
    void draw(Graphics2D g) {
        g.setPaint(new Color(R,G,B));
        g.setStroke(new BasicStroke(width));
        g.drawRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x2-x1),Math.abs(y2-y1));
    }
}

//圆角矩形
class RoundRectangel extends Shape {
    void draw(Graphics2D g){
        g.setPaint(new Color(R,G,B));
        g.setStroke(new BasicStroke(width));
        g.drawRoundRect(Math.min(x1,x2),Math.min(y1,y2),Math.abs(x2-x1),Math.abs(y2-y1),30,30);
    }
}

//椭圆
class Oval extends Shape {
    void draw(Graphics2D g) {
        g.setPaint(new Color(R, G, B));
        g.setStroke(new BasicStroke(width));
        g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));

    }
}

//三角形
class Triangle extends Shape {
    void draw(Graphics2D g){
        int[] x = {(Math.abs(x2-x1)/2)+Math.min(x1,x2), x1, x2};
        int[] y = {Math.min(y1,y2),Math.max(y1,y2),Math.max(y1,y2)};
        g.setPaint(new Color(R,G,B));
        g.setStroke(new BasicStroke(width));
        g.drawPolygon(x,y,3);
    }
}

