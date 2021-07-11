package com.wh.drawPixel0519;

import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

//事件处理类
//实现接口一定要重写接口中所有的抽象方法
//实现(继承)接口：public class 子类 implements 接口, 接口 {}
public class DrawMouse implements MouseListener, ActionListener, MouseMotionListener {
    //保存传递过来的画笔对象
    public Graphics g;
    public int x1, y1, x2, y2;
    public String name;
    public JFrame jf;
    int n = 10;

    public void actionPerformed(ActionEvent e) {
        //获取当前的事件源：e.getSource() == jbu
        //获取当前事件源上的内容
        name = e.getActionCommand();
        System.out.println("点击按钮：" + name);
        if (name == "清空") {
            jf.repaint();
        }
    }

    //自然
    Random rand = new Random();
    int ax = rand.nextInt(801);
    int ay = rand.nextInt(801);
    int bx = rand.nextInt(801);
    int by = rand.nextInt(801);
    int cx = rand.nextInt(801);
    int cy = rand.nextInt(801);
    int px = rand.nextInt(801);
    int py = rand.nextInt(801);
    int ran;

    public void mouseClicked(MouseEvent e) {
        /*
        System.out.println("点击");
        //获取当前坐标
        int x = e.getX();
        int y = e.getY();
        //加载图片资源
        ImageIcon image = new ImageIcon("/Users/swish/Desktop/IMG_0835.JPG");
        //绘制图像效果
        g.drawImage(image.getImage(), x, y, 500, 500, null);
         */

        if (name == "自然") {

            for (int i = 0; i < 100; i++) {
                ran = rand.nextInt(3);

                switch (ran) {

                    //A
                    case 0:
                        px = (ax + px) / 2;
                        py = (ay + py) / 2;
                        g.drawLine(px, py, px, py);
                        break;
                    //B
                    case 1:
                        px = (bx + px) / 2;
                        py = (by + py) / 2;
                        g.drawLine(px, py, px, py);
                        break;
                    //C
                    case 2:
                        px = (cx + px) / 2;
                        py = (cy + py) / 2;
                        g.drawLine(px, py, px, py);
                        break;
                }

            }

        }

        if (name == "谢尔宾斯基三角形") {
            drawTriangle(g,100, (int)(400 + Math.sqrt(3) * 150), 600);
            sierpinskiTriangle(g,100, (int)(400 + Math.sqrt(3) * 150), 600, 10);
        }

        if (name == "谢尔宾斯基地毯") {
            g.drawRect(100, 100, 600, 600);
            sierpinskiCarpet(g, 100, 100, 600, 5);
        }



    }

    public void mousePressed(MouseEvent e) {
        System.out.println("按下");
        //获取当前坐标
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("释放");
        //获取当前坐标
        int x2 = e.getX();
        int y2 = e.getY();

        switch (name) {
            case "直线":
                g.drawLine(x1, y1, x2, y2);
                break;
            case "矩形":

                if (x2 > x1 && y2 > y1) {
                    g.drawRect(x1, y1, x2 - x1, y2 - y1);
                } else if (x2 > x1 && y2 < y1) {
                    g.drawRect(x1, y2, x2 - x1, y1 - y2);
                } else if (x2 < x1 && y2 > y1) {
                    g.drawRect(x2, y1, x1 - x2, y2 - y1);
                } else if (x2 < x1 && y2 < y1) {
                    g.drawRect(x2, y2, x1 - x2, y1 - y2);
                }


                break;
            case "椭圆":

                if (x2 > x1 && y2 > y1) {
                    g.drawOval(x1, y1, x2 - x1, y2 - y1);
                } else if (x2 > x1 && y2 < y1) {
                    g.drawOval(x1, y2, x2 - x1, y1 - y2);
                } else if (x2 < x1 && y2 > y1) {
                    g.drawOval(x2, y1, x1 - x2, y2 - y1);
                } else if (x2 < x1 && y2 < y1) {
                    g.drawOval(x2, y2, x1 - x2, y1 - y2);
                }

                break;
            default:
        }

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

        //一段曲线可以被分解为许多小段的直线连接在一起，因此，我们画曲线的方法就是画出线段并不断替换它的末端坐标
        if (name == "铅笔") {
            x2 = e.getX();
            y2 = e.getY();
            g.drawLine(x1, y1, x2 ,y2);
            x1 = x2;
            y1 = y2;
        }

    }

    public void mouseMoved(MouseEvent e) {

    }

    //画最大的等边三角形，(x,y)为左下角顶点，d为边长
    public void drawTriangle(Graphics g, int x, int y, int d) {
        g.drawLine(x, y, x + d, y);
        g.drawLine(x + d, y, x + d / 2, (int)(y - Math.sqrt(3) * d / 2));
        g.drawLine(x + d / 2, (int)(y - Math.sqrt(3) * d / 2), x, y);
    }

    //谢尔宾斯基三角形
    public void sierpinskiTriangle(Graphics g, int x, int y, int d, int n) {
        n--;
        d = d >> 1;
        x = x + d;
        //画倒三角
        g.drawLine(x, y, x + (d >> 1), (int)(y - Math.sqrt(3) * d / 2));
        g.drawLine(x + (d >> 1), (int)(y - Math.sqrt(3) * d / 2), x - (d >> 1), (int)(y - Math.sqrt(3) * d / 2));
        g.drawLine(x - (d >> 1), (int)(y - Math.sqrt(3) * d / 2), x, y);

        if (n <= 0) {
            return;
        }

        //递归画倒小三角
        sierpinskiTriangle(g, x, y, d, n);
        sierpinskiTriangle(g, x - d, y, d, n);
        sierpinskiTriangle(g, x - (d >> 1), (int)(y - Math.sqrt(3) * d / 2), d, n);
    }

    //谢尔宾斯基地毯
    public void sierpinskiCarpet(Graphics g, int x, int y, int d, int n) {

        if (n <= 0) {
            return;
        }

        n--;
        g.fillRect(x + d / 3, y + d / 3, d / 3, d / 3);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                sierpinskiCarpet(g, x + j * d / 3, y + i * d / 3, d / 3, n);
            }

        }

    }

}
