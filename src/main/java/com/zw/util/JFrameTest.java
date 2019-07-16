package com.zw.util;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/7 15:53
 */
public class JFrameTest extends JFrame implements Icon {
    private int width;        // 声明图标的宽
     private int height;        // 声明图标的长

             public JFrameTest() {}        // 定义无参构造方法

             public JFrameTest(int width, int height) {        // 定义有参构造方法
                 this.width = width;
                 this.height = height;
             }

             @Override
     public int getIconHeight() {        // 实现getIconHeight()方法
                 return this.height;
             }

             @Override
     public int getIconWidth() {            // 实现getIconWidth()方法
                 return this.width;
             }

             @Override
     public void paintIcon(Component arg0, Graphics arg1, int arg2, int arg3) {        // 实现paintIcon()方法
                 arg1.fillOval(arg2, arg3, width, height);        // 绘制一个圆形
             }

             public void init() {    // 定义一个方法用于实现界面
                 JFrameTest iconDemo = new JFrameTest(15, 15);        // 定义图标的长和宽
                 JLabel jb = new JLabel("icon测试", iconDemo, SwingConstants.CENTER);    // 设置标签上的文字在标签正中间

                 Container container = getContentPane();
                 container.add(jb);

                 this.setVisible(true);
                 this.setSize(500, 350);
                 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
             }

             public static void main(String[] args) {
                 new JFrameTest().init();
             }
}
