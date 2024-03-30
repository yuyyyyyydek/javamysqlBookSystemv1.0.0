package com.book.one;

import java.awt.Font;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Succeed extends JFrame{
    private JLabel jLabel ;//登录成功的提示
    private JLabel jLabel2 ;//登陆所需时长的提示

    void succeed() {

        setTitle("登录成功");//设置窗口标题
        setSize(400,280);//设置窗口大小
        setLayout(null);//设置窗口布局
        setResizable(false);//设置窗口是否可以改变大小
        this.setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//设置窗口可见
        jLabel = new JLabel("您已经成功登录");//文本域，登录成功的信息
        jLabel2 = new JLabel("将在五秒后登陆");//文本域，登录显示延迟时间的信息
        Font font = new Font("Serif",Font.BOLD,22);//设置文字大小
        jLabel.setFont(font);//应用账号文字大小
        jLabel2.setFont(font);//应用账号文字大小
        jLabel.setBounds(116,-24,200,200);//设置成功信息文字的大小和位置
        jLabel2.setBounds(116,34,200,200);//设置成功登陆延迟时间文字的大小和位置
        add(jLabel);//添加文字文本域至窗口
        add(jLabel2);//添加文字文本域至窗口
        repaint();//刷新重绘

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);//定时器任务方法，网上查询到的
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                setVisible(false);//设置注册窗口隐藏
                new MainAp();//创建图书管理系统的主窗体
            }
        }, 5, TimeUnit.SECONDS);    // 五秒钟后执行任务
        executor.shutdown();



    }


}
