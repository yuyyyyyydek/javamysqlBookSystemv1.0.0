package com.book.one;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import javax.swing.*;

public class MainAp extends JFrame {
//     int count = 0;


    {
        setSize(1000, 650);//设置窗口大小
        JMenuBar menuBar;//菜单栏
        JMenu menuse;//菜单显示选项 图书系统
        JMenu menuyh;//菜单显示选项	 用户管理
        JMenuItem[] jmenuzsgc;//菜单操作选项
        menuBar = new JMenuBar();//创建菜单栏
        menuse = new JMenu("图书系统");//创建菜单选项"图书系统"
        menuyh = new JMenu("用户管理");//创建菜单选项"图书系统"
        menuBar.add(menuse);    //添加图书系统到菜单栏
        menuBar.add(menuyh);    //添加图书借阅到菜单栏
        JMenuItem jmenuzsgcse = new JMenuItem("图书查询");//图书查询菜单选项
        JMenuItem jmenuzsgcup = new JMenuItem("图书修改");//图书修改菜单选项
        JMenuItem jmenuzsgcde = new JMenuItem("图书删除");//图书删除菜单选项
        JMenuItem jmenuzsgcin = new JMenuItem("图书增添");//图书增添菜单选项
        JMenuItem jmenuyhxz = new JMenuItem("新增用户");//图书管理系统使用者的增加
        JMenuItem jmenuyhsc = new JMenuItem("删除用户");//图书管理系统使用者的删除
        menuse.add(jmenuzsgcse);//添加图书查询选项到图书系统菜单栏中
        menuse.add(jmenuzsgcup);//添加图书修改选项到图书系统菜单栏中
        menuse.add(jmenuzsgcde);//添加图书删除选项到图书系统菜单栏中
        menuse.add(jmenuzsgcin);//添加图书增添选项到图书系统菜单栏中
        menuyh.add(jmenuyhxz);//添加新增用户选项到用户管理菜单栏中
        menuyh.add(jmenuyhsc);//添加用户删除选项到用户管理菜单栏中
        this.setJMenuBar(menuBar);//添加菜单栏到主窗体

        //以下为用户管理菜单栏的选项按钮，此段添加选项点击事件
        jmenuyhxz.addActionListener(new ActionListener() {//为菜单栏选项"用户新增"添加监听事件
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainAp.staticdata.countreg == 0) {//如果注册用户窗口不存在，按下此按钮弹出注册窗口
                    staticdata.countreg = 1;
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new Register().register(); //显示注册窗口
                }

            }
        });

        jmenuyhsc.addActionListener(new ActionListener() {//为菜单栏选项"用户删除添加监听事件"
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainAp.staticdata.countuserdel == 0) { //如果删除用户窗口不存在，点击此按钮弹出删除用户窗口
                    staticdata.countuserdel = 1;
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new DelUser().delUser();//创建一个删除用户窗口
                }
            }
        });


        jmenuzsgcse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.count == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    staticdata.count = 1;//设置窗口状态为1，表示窗口已经存在
                    new See2().see2();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、

                }

            }
        });//添加图书查询选项的点击事件
        jmenuzsgcup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countup == 0) {//如果修改窗口不存在，0表示不存在，不存在则创建修改窗口
                    staticdata.countup = 1;//修改窗口存在，设置为1,1表示存在窗口
                    new Upd().upd();//实例化类以及调用该类的方法、
                }


            }
        });//添加图书修改选项的点击事件
        jmenuzsgcde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countdel == 0) {//如果图书删除窗口不存在，0表示不存在，不存在则创建删除图书窗口
                    staticdata.countdel = 1;//设置图书删除窗口已经存在，设置值为1，防止创建多个删除图书的窗口
                    new Del().del();//实例化类以及调用该类的方法
                }


            }
        });//添加图书删除选项的点击事件
        jmenuzsgcin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countadd == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    staticdata.countadd = 1;//设置新增图书窗口存在，1表示存在
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new Add().add();//创建新增图书窗口//实例化类以及调用该类的方法
                }

            }
        });//添加图书增添选项的点击事件


        setVisible(true);//设置菜单栏可见
        repaint();//重绘刷新
        main();//创建图书管理系统总目录总页面
    }

    void main() {

        mframe();
    }


    private JPanel jPanel;//面板对象
    private JLabel jLabel;//图书管理系统总标题
    private JLabel jLabel2;//图书操作总标题
    private JButton bse;//查看图书按钮
    private JButton bup;//修改更新图书按钮
    private JButton bde;//删除图书按钮
    private JButton bin;//增加图书按钮
//	private JMenuBar menuBar;//菜单栏
//	private JMenu menuse;//菜单显示选项 图书系统
//	private JMenu menujy;//菜单显示选项	 图书借阅
//	private JMenuItem[] jmenuzsgc;//菜单操作选项

    void mframe() {
        jPanel = new JPanel();//创建面板对象
        getContentPane().add(jPanel);//面板加入到显示容器中

        setTitle("登录");//设置窗口标题
        setSize(1000, 650);//设置窗口大小
//        setLayout(null);//设置窗口布局 //****此处不能设置绝对布局null
        setResizable(false);//设置窗口是否可以改变大小
        setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
        this.setVisible(true);//设置容器窗口可见
        jPanel.setVisible(true);//设置面板窗口可见


        jPanel.setSize(300, 650);//设置面板对象的大小
        //jPanel.setLocation(0,0);//窗口居中显示
        jPanel.setLayout(null);//面板布局样式
        jLabel = new JLabel("图书管理系统");//创建文本域，显示"图书管理系统"6个大字
        jLabel2 = new JLabel("图书系统");    //显示图书系统小标题
        Font font = new Font("Serif", Font.BOLD, 45);//设置文字大小
        Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
        jLabel.setFont(font);//图书管理系统总标题文字大小
        jLabel2.setFont(font2);//图书操作标题应用文字大小
        //jLabel.setBounds(374,-60,500,200);//"图书管理系统"总标题位置大小设定
        jLabel.setBounds(374, -70, 500, 200);//"图书管理系统"总标题位置大小设定
        //jLabel2.setBounds(135,100,180,65);//“图书系统”小标题位置大小设定
        jLabel2.setBounds(135, 60, 180, 65);//“图书系统”小标题位置大小设定
        jLabel.setForeground(Color.RED);//设置字体颜色
        bse = new JButton("图书查询");//图书查询按钮创建
        bup = new JButton("图书修改");//图书修改按钮创建
        bde = new JButton("图书删除");//图书删除按钮创建
        bin = new JButton("图书增添");//图书增添按钮创建
        bse.setFont(font2);//按钮文字采用28号
        bup.setFont(font2);//按钮文字采用28号
        bde.setFont(font2);//按钮文字采用28号
        bin.setFont(font2);//按钮文字采用28号
        bse.setBounds(100, 150, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        bup.setBounds(100, 250, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        bde.setBounds(100, 350, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        bin.setBounds(100, 450, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        jPanel.add(bup);//按钮添加到面板容器
        jPanel.add(bse);//按钮添加到面板容器
        jPanel.add(bde);//按钮添加到面板容器
        jPanel.add(bin);//按钮添加到面板容器
        jPanel.add(jLabel2);//文本域添加到面板容器"图书系统"标题
        jPanel.add(jLabel);//文本域添加到面板容器"图书管理系统大标题"

        bse.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { //鼠标点击事件执行的代码

                if (staticdata.count == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    staticdata.count = 1;//设置窗口状态为1，表示窗口已经存在
                    new See2().see2();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//添加一个鼠标监听

//为修改按钮添加鼠标监听器
        bup.addMouseListener(new MouseListener() {//为按钮添加监听器
            @Override
            public void mouseClicked(MouseEvent e) {//添加鼠标单击事件

                if (staticdata.countup == 0) {//如果修改窗口不存在，0表示不存在，不存在则创建修改窗口
                    staticdata.countup = 1;//修改窗口存在，设置为1,1表示存在窗口
                    new Upd().upd();//实例化类以及调用该类的方法、
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


//为删除按钮添加鼠标事件
        bde.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (staticdata.countdel == 0) {//如果图书删除窗口不存在，0表示不存在，不存在则创建删除图书窗口
                    staticdata.countdel = 1;//设置图书删除窗口已经存在，设置值为1，防止创建多个删除图书的窗口
                    new Del().del();//实例化类以及调用该类的方法
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        //为新增添加按钮添加鼠标事件
        bin.addMouseListener(new MouseListener() {//新增图书按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件

                if (staticdata.countadd == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    staticdata.countadd = 1;//设置新增图书窗口存在，1表示存在
                    new UpdataDef().updatadef();//新增失败信息框提示
                    new Add().add();//创建新增图书窗口//实例化类以及调用该类的方法
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        repaint();//重绘刷新
        setVisible(true);


    }//mframe  end


//    ActionListener listener3 = new ActionListener() {//添加事件监听
//
//        @Override
//        public void actionPerformed(ActionEvent e) {//重写方法
//            //register = new Register();//注册窗口创建
//            //register.register();//调用注册窗口构造方法，使窗口创建
//            if(Main.staticdata.countreg == 0) {//如果注册窗口不存在，按下此按钮弹出注册窗口
//                new Register().register(); //显示注册窗口
//            }
//        }
//    };//listener  END


    static class staticdata {

        static int countreg = 0;//用于注册窗口界面只能存在一个

        static int countregwin = 0;//用于注册窗口注册成功后弹出的成功注册窗口只能存在一个

        static int count = 0;//用于使查询界面只能存在一个

        static int countup = 0;//用于界面修改数据界面只能存在一个

        static int countdel = 0;//用于删除图书界面只能存在一个

        static int countadd = 0;//用于新增图书界面只能存在一个

        static int countupdata = 0;//用于修改图书信息窗口界面只能存在一个

        static int countwin = 0;//用于修改成功弹出的窗口只能存在一个

        static int countwinadd = 0;//用于删除成功弹出的成功窗口只能存在一个

        static int countdewin = 0;//用于删除成功弹出的窗口只能存在一个

        static int countdef = 0;//用于修改失败弹出的信息窗口只能存在一个
        static String bokname = "";//用于获取要修改的图书的书名//要修改的图书书名

        static String bokname2 = "";//用于获取要删除的图书的书名//要删除的图书书名

        static String bokauthor = "";//用于获取要修改的图书的作者

        static BigDecimal bokprice = null;//用于获取要修改的图书的价格

        static int bokamount = 0;//用于获取要修改的图书的数量

        static String boktype = "";//用于获取要修改的图书的类型

        static int upid = 0; //用于确定要修改的是哪一个ID，以ID为信息修改其他信息

        static int deid2 = 0; //用于确定要删除的是哪一个ID，以ID为信息删除指定图书

        //以下为删除用户信息的静态变量
        static int deid3 = 0;//用于确定要删除的是哪一个用户ID，以ID为准删除指定用户

        static String user = "";//用于获取要删除的用户字符串信息

        static int countuserdel = 0;//用于使用户删除窗口界面只能存在一个

        static int countuserdelwin = 0;//用于用户删除成功后的提示窗只能存在一个

    } //static  staticdata end


}



