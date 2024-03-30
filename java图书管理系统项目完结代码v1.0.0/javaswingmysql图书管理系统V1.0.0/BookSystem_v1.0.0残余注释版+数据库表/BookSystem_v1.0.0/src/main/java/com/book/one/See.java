package com.book.one;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class See extends JFrame{  //See类为此功能的第一个版本,1版本面板2使用黄色，表示垃圾版本
    String booktext;//查询文本框中的内容

//    public int time = 0;//该窗口是否存在


    private JTextField textField;//声明图书查询的文本框
    private JPanel jPanel;//声明面板
    private JPanel jPanel2;//声明面板2

    private JButton bse;//查询图书按钮
    private JLabel jLabel;//查询书籍 的文本域信息
    private JTable jtable;//声明表格
    Font font2 = new Font("Serif",Font.BOLD,28);//设置文字大小


    public void see() {


        jtable = new JTable();//创建数据表格
        jPanel2 = new JPanel();//创建面板2
        jPanel = new JPanel();//创建面板

        this.setSize(1010,610);//查询窗口的大小
        //this.setResizable(false);

        this.setTitle("图书查询");//设置窗口标题
        this.setLayout(null);//设置窗口布局
        this.setLocationRelativeTo(null);//窗口居中显示
        setResizable(false);//设置窗口是否可以改变大小



        // 设置JPanel的背景颜色
        jPanel.setBackground(Color.YELLOW); // 设置面板颜色为红色背景
        jPanel2.setBackground(Color.YELLOW); // 设置面板颜色为灰色背景
//        jPanel3.setBackground(Color.BLUE); // 设置为红色背景

        jPanel.setBounds(0,0,300,400);//设置面板1的大小以及位置
        //jPanel2.setSize(700,500);
        jPanel2.setBounds(300,0,800,600);//设置面板2的大小以及位置

        jLabel = new JLabel("输入图书名称可查询");//输入图书名称可查询 文本域的内容
        bse =new JButton("图书查询");//图书查询按钮创建，并赋值(+字)
        textField = new JTextField();  //文本框创建

        bse.setFont(font2);//按钮文字采用28号
        textField.setFont(font2);//图书查询窗口文字大小使用28号字体
        jLabel.setFont(font2);//为文本信息设置字体大小
        textField.setBounds(60,250,190,55);//图书查询文本框位置大小设定
        bse.setBounds(70,100,180,65);
        jLabel.setBounds(22,190,280,55);
        //bse.setLocation(80,300);
        jPanel.setLayout(null);//设置面板布局为绝对布局

        repaint();
        jPanel.add(textField);//添加文本框到面板1
        jPanel2.add(jtable);//添加表格到面板2

//        jPanel.setLayout(new BorderLayout());
//        jPanel.add(textField);
//            jPanel.setBounds(20,600,400,665);

        jPanel.add(bse);//按钮添加到面板1容器

        jPanel.add(jLabel);//
        repaint();//重绘
        setVisible(true);//设置窗体可见
        getContentPane().add(jPanel);//得到当前容器，把jpanel添加到容器中
        getContentPane().setLayout(null);//当前容器布局为绝对布局
        getContentPane().add(jPanel2);//得到当前哦那个其，把jpanel2添加到容器中

        //booktext = gain(textField);//调用获取账号文本框信息

        seeall();//默认显示所有图书信息

        bse.addMouseListener(new MouseListener() {//为查询按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件
               jPanel2.removeAll();//移除面板2中所有的内容
                System.out.println(gain(textField));//输出显示查询文本框中的信息
                booktext = gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext
                seeall2(booktext);//将booktext传入seeall2方法中
                setVisible(true);//设置窗口内容可见


                }
                //seeall();



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












        //seeall();


        setVisible(true);//设置窗口内容可见


        this.addWindowListener(new WindowAdapter() {


            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                        MainAp.staticdata.count = 0;//设置该窗口是否存在，这里重置为0，方便下次创建
                   }

         });


        // 创建表格模型
        //String[] columnNames = {"姓名", "年龄", "职业"};
//        Object[][] data = {
//                {"张三", 28, "软件工程师"},
//                {"李四", 35, "项目经理"},
//                {"王五", 22, "数据分析师"},
//                {"张三", 28, "软件工程师"},
//                {"李四", 35, "项目经理"},
//                {"王五", 22, "数据分析师"},
//                {"张三", 28, "软件工程师"},
//                {"李四", 35, "项目经理"},
//                {"王五", 22, "数据分析师"},
//                {"张三", 28, "软件工程师"},
//                {"李四", 35, "项目经理"},
//                {"王五", 22, "数据分析师"},
//                {"张三", 28, "软件工程师"},
//                {"李四", 35, "项目经理"},
//                {"王五", 22, "数据分析师"},
//                {"张三", 28, "软件工程师"},
//
//
//
//        };

        //分割线------------------------------------





//        void seeall():
//
//            // 数据库连接配置
//            String url = "jdbc:mysql://localhost:3306/booksystem";
//            String user = "root";
//            String password = "123456";
//
//            // 表格列名
//            String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};
//
//            // 创建表格的数据模型
//            DefaultTableModel model = new DefaultTableModel(columnNames,0);
//            {
//                try {
//                    // 加载数据库驱动
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    // 建立连接
//                    Connection con = DriverManager.getConnection(url, user, password);
//                    // 创建Statement
//                    Statement stmt = con.createStatement();
//                    // 执行查询
//                    ResultSet rs = stmt.executeQuery("select * from t_book");
//
//                    // 遍历结果集
//                    while (rs.next()) {
//                        // 根据列名获取数据
//                        int id = rs.getInt("ID");
//                        String name = rs.getString("BookName");
//                        String author = rs.getString("BookAuthor");
//                        BigDecimal price = rs.getBigDecimal("bookprice");
//                        int amount = rs.getInt("bookamount");
//                        String BookType = rs.getString("BookType");
//
//                        // 将数据添加到表格模型
//                        model.addRow(new Object[]{id, name, author,price,amount,BookType});
//
//                    }
//
//                    // 关闭资源
//                    rs.close();
//                    stmt.close();
//                    con.close();
//
//                } catch (ClassNotFoundException | SQLException e) {
//                    e.printStackTrace();
//
//                }
//            }
//            jtable = new JTable(model);//表格模型添加到表
//            jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****
//
//            // 创建表格
//            // JTable table = new JTable(model);  //关键注释
//
//            // 创建滚动面板来容纳表格
//            //JScrollPane scrollPane = new JScrollPane(table); //关键注释
//
//            //分割线------------------------------------
//
//



        /**
         * 重要一步 ：以下
         */
        // 创建JTable
        //jtable = new JTable(model);  //**** 已经上移
        //jtable.setSize(700,500);
        //jtable.setVisible(true);
        //JScrollPane scrollPane = new JScrollPane(jtable); //关键注释
        //jPanel2.add(scrollPane);

        // 添加表格到框架
        /**
         * 重要一步：以下：
         */
        //jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****已经上移
//        setVisible(true);
        //jPanel2.setVisible(true); // 显示框架


    }






    private String gain(JTextField textField) {//获取文本框中的文本信息的方法
        String text = textField.getText();//获取文本框中的内容信息
        //System.out.println("获取文本框内容");//提示信息
        return text;//返回框中的内容

    }



    void seeall(){//默认显示所有图书信息



        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem";
        String user = "root";
        String password = "123456";

        // 表格列名
        String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};

        // 创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        {
            try {
                // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                Connection con = DriverManager.getConnection(url, user, password);
                // 创建Statement
                Statement stmt = con.createStatement();
                String sql = "select * from t_book";
                // 执行查询
                //ResultSet rs = stmt.executeQuery("select * from t_book");//原始语句
                ResultSet rs = stmt.executeQuery(sql);

                // 遍历结果集
                while (rs.next()) {
                    // 根据列名获取数据
                    int id = rs.getInt("ID");
                    String name = rs.getString("BookName");
                    String author = rs.getString("BookAuthor");
                    BigDecimal price = rs.getBigDecimal("bookprice");
                    int amount = rs.getInt("bookamount");
                    String BookType = rs.getString("BookType");

                    // 将数据添加到表格模型
                    model.addRow(new Object[]{id, name, author,price,amount,BookType});

                }

                // 关闭资源
                rs.close();
                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }
        jtable = new JTable(model);//表格模型添加到表
        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****

        // 创建表格
        // JTable table = new JTable(model);  //关键注释

        // 创建滚动面板来容纳表格
        //JScrollPane scrollPane = new JScrollPane(table); //关键注释

        //分割线------------------------------------


    }





    void seeall2(String search) {
//        time = 1;

        String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '%" + search + "%'";
        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '" + search + "'";
        //实验成功  ：：String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '"+ search +"'";
        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem";
        String user = "root";
        String password = "123456";

        // 表格列名
        String[] columnNames = {"ID", "BookName", "BookAuthor", "Price", "Amount", "BookType"};

        // 创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        {
            try {
                // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                Connection con = DriverManager.getConnection(url, user, password);
                // 创建Statement
                Statement stmt = con.createStatement();
                //String sql = "select * from t_book";
                // 执行查询
                //ResultSet rs = stmt.executeQuery("select * from t_book");//原始语句
                ResultSet rs = stmt.executeQuery(sql2);

                // 遍历结果集
                while (rs.next()) {
                    // 根据列名获取数据
                    int id = rs.getInt("ID");
                    String name = rs.getString("BookName");
                    String author = rs.getString("BookAuthor");
                    BigDecimal price = rs.getBigDecimal("bookprice");
                    int amount = rs.getInt("bookamount");
                    String BookType = rs.getString("BookType");

                    // 将数据添加到表格模型
                    model.addRow(new Object[]{id, name, author, price, amount, BookType});

                }

                // 关闭资源
                rs.close();
                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }
        jtable = new JTable(model);//表格模型添加到表
        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****

        // 创建表格
        // JTable table = new JTable(model);  //关键注释

        // 创建滚动面板来容纳表格
        //JScrollPane scrollPane = new JScrollPane(table); //关键注释

        //分割线------------------------------------

    }//seeall2() end


}


