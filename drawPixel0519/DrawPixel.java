package com.wh.drawPixel0519;

import java.awt.*;

import javax.swing.*;

/**
 * Java绘图软件
 * 1.显示美颜相机的界面（功能选择）：java.awt java.swing
 * 2.处理图像效果，显示在界面（画笔/画布）
 * 3.事件监听器（设计界面程序的交互功能）
 */
public class DrawPixel {

    public static void main(String[] args) {
        DrawPixel dp = new DrawPixel();
        dp.initUI();
    }

    //1.显示界面效果
    public void initUI() {
        //窗体组件
        JFrame jf = new JFrame();
        jf.setSize(800, 800);
        jf.setTitle("绘图软件");
        //设置居中显示
        jf.setLocationRelativeTo(null);
        //设置进程退出的方法
        jf.setDefaultCloseOperation(3);
        //流式布局管理器
        FlowLayout flow = new FlowLayout();
        jf.setLayout(flow);
        //按钮
        JButton jbu1 = new JButton("直线");
        jf.add(jbu1);
        JButton jbu2 = new JButton("矩形");
        jf.add(jbu2);
        JButton jbu3 = new JButton("椭圆");
        jf.add(jbu3);
        JButton jbu4 = new JButton("铅笔");
        jf.add(jbu4);
        /*
        自然
        1.平面上随机选A,B,C三个点。再随机选一个点，记为P。
        2.有一个三面色字，每丢一次，则选中ABC三个中一点。
        开始游戏：
        重复丢色子
        1.如果选中A，则取A和P的中点P1，画黑。第二次开始再选中A，则取A和P1的中点为新的P1，画黑。
        2.如果选中B，则取B和P的中点P2，画黑。第二次开始再选中B，则取B和P2的中点为新的P2，画黑。
        3.如果选中C，则取C和P的中点P3，画黑。第二次开始再选中C，则取C和P3的中点为新的P3，画黑。
        一直重复，每点一下鼠标，丢100次色子
         */
        JButton jbu5 = new JButton("自然");
        jf.add(jbu5);
        /*
        谢尔宾斯基三角形
        1.取一个实心的三角形。（多数使用等边三角形）
        2.沿三边中点的连线，将它分成四个小三角形。
        3.去掉中间的那一个小三角形。
        4.对其余三个小三角形重复1。
         */
        JButton jbu6 = new JButton("谢尔宾斯基三角形");
        jf.add(jbu6);
        /*
        谢尔宾斯基地毯
        构造与谢尔宾斯基三角形相似，区别仅在于谢尔宾斯基地毯是以正方形而非等边三角形为基础的。
        将一个实心正方形划分为3×3的9个小正方形，去掉中间的小正方形，再对余下的小正方形重复这一操作便能得到谢尔宾斯基地毯。
         */
        JButton jbu7 = new JButton("谢尔宾斯基地毯");
        jf.add(jbu7);
        JButton jbu8 = new JButton("清空");
        jf.add(jbu8);
        //设置可见
        jf.setVisible(true);
        //获取画笔：图像显示在哪个组件上，画笔就该从该组件上获取
        //从窗体上获取画笔，一定要在窗体显示可见之后
        Graphics g = jf.getGraphics();
        /*
         事件监听器
         a.事件源：当前动作所发生的组件
         b.确定监听器方法：鼠标监听器方法
         c.绑定事件处理类
         */
        DrawMouse mouse = new DrawMouse();
        //匿名内部类
        //给窗体添加鼠标监听器方法
        jf.addMouseListener(mouse);
        //拖动监听器
        jf.addMouseMotionListener(mouse);
        //1.有继承关系的类 2.在子类中重写父类中的方法（抽象方法）
        //给按钮添加动作监听器
        jbu1.addActionListener(mouse);
        jbu2.addActionListener(mouse);
        jbu3.addActionListener(mouse);
        jbu4.addActionListener(mouse);
        jbu5.addActionListener(mouse);
        jbu6.addActionListener(mouse);
        jbu7.addActionListener(mouse);
        jbu8.addActionListener(mouse);
        //把画笔对象传递给DrawMouse类
        mouse.g = g;
        //把窗体对象传递给DrawMouse类
        mouse.jf = jf;
    }

}
