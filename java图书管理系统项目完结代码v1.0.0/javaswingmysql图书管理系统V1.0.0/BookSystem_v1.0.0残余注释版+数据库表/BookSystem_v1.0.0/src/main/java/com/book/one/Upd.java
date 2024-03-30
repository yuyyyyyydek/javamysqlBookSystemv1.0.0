package com.book.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.*;

public class Upd extends JFrame {//修改图书内容的类  ，采用了面板JPanel添加组件，不推荐使用面板添加组件，代码繁琐
    private String booktext;//修改文本框中的内容

    private JLabel jLabel;//修改书籍 的文本域信息
    private JLabel jLabel2;//所要修改成的书籍 的文本域信息

//    private JLabel jLabel3;//updata面板 文本域，信息为需要修改的图书名字
//
//    private JLabel jLabel4;//updata面板  文本域，信息为需要修改的图书作者
//
//    private JLabel jLabel5;//updata面板  文本域，信息为需要修改的图书价格
//
//    private JLabel jLabel6;//updata面板  文本域，信息为需要修改的图书数量
//
//    private JLabel jLabel7;//updata面板  文本域，信息为需要修改的图书类型

    private JButton bup;//查询图书按钮
    private JButton bupdata;//修改图书信息按钮声明，进入updata面板界面

//    private JButton bupdata2;//updata界面 修改图书信息按钮声明，完成数据修改的按钮
    private JTextField textField;//声明图书修改的文本框
    private JTextField textField2;//声明图书所要修改成为的名称的文本框//变更为显示要修改的目标书籍

//    private JTextField textField3;//updata面板 文本框，信息为需要修改的图书名字
//
//    private JTextField textField4;//updata面板  文本框，信息为需要修改的图书作者
//
//    private JTextField textField5;//updata面板   文本框，信息为需要修改的图书价格
//
//    private JTextField textField6;//updata面板  文本框，信息为需要修改的图书数量
//
//    private JTextField textField7;//updata面板   文本框，信息为需要修改的图书类型



    Font font2 = new Font("Serif",Font.BOLD,28);//设置文字大小
//----------------分割线



//    void updata(){
//        JFrame jframe = new JFrame();//创建窗口jframe
//
//        JPanel jPanel5 = new JPanel();//创建面板5
//        //jframe.getContentPane().setSize();
//        jframe.setSize(700,700);//设置窗体大小
//        //jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//设置窗体关闭方式
//        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭方式
//        jframe.setLocationRelativeTo(null);//窗口居中显示
//        jframe.setResizable(false);//设置窗口是否可以改变大小
//        jframe.setVisible(true);//设置窗体可见
//        //jPanel5.setBackground(Color.RED); // 设置面板颜色为红色背景
//        jframe.setLayout(null);//设置窗体布局为绝对布局
//
//        bupdata2 = new JButton("确认修改");//创建"确认修改"按钮
//        bupdata2.setFont(font2);//设置按钮字体大小格式
//        bupdata2.setBounds(244,525,180,65);//设置"确认修改"按钮位置大小
//        jframe.add(bupdata2);//添加"确认修改"按钮到窗体
//
//
//
//        jLabel3 = new JLabel("图书名称修改为");//图书名称文本域
//        jLabel3.setFont(font2);//设置文本域字体大小格式
//        jLabel3.setBounds(83,10,220,55);//设置文本域的出现位置以及大小
//        jframe.add(jLabel3);//将文本域3添加到jframe窗体中
//
//        textField3 = new JTextField();//updata面板 文本框，信息为需要修改的图书名字
//        textField3.setFont(font2);//设置文本域字体大小格式
//        textField3.setBounds(320,10,280,55);//图书名字文本框位置大小设定
//        textField3.setText(Main.staticdata.bokname);
//        jframe.add(textField3);//将文本框3添加到jframe窗体中
//
//
//
//        jLabel4 = new JLabel("图书作者修改为");//图书作者文本域
//        jLabel4.setFont(font2);//设置文本域字体大小格式
//        jLabel4.setBounds(83,110,220,55);//设置文本域的出现位置以及大小
//        jframe.add(jLabel4);//将文本域4添加到jframe窗体中
//
//        textField4 = new JTextField();//updata面板 文本框，信息为需要修改的图书作者
//        textField4.setFont(font2);//设置文本域字体大小格式
//        textField4.setBounds(320,110,280,55);//图书名字文本框位置大小设定
//        jframe.add(textField4);//将文本框4添加到jframe窗体中
//
//
//
//        jLabel5 = new JLabel("图书价格修改为");//图书价格文本域
//        jLabel5.setFont(font2);//设置文本域字体大小格式
//        jLabel5.setBounds(83,210,220,55);//设置文本域的出现位置以及大小
//        jframe.add(jLabel5);//将文本域5添加到jframe窗体中
//
//        textField5 = new JTextField();//updata面板 文本框，信息为需要修改的图书价格
//        textField5.setFont(font2);//设置文本域字体大小格式
//        textField5.setBounds(320,210,280,55);//图书名字文本框位置大小设定
//        jframe.add(textField5);//将文本框5添加到jframe窗体中
//
//
//        jLabel6 = new JLabel("图书数量修改为");//图书数量文本域
//        jLabel6.setFont(font2);//设置文本域字体大小格式
//        jLabel6.setBounds(83,310,220,55);//设置文本域的出现位置以及大小
//        jframe.add(jLabel6);//将文本域6添加到jframe窗体中
//
//        textField6 = new JTextField();//updata面板 文本框，信息为需要修改的图书数量
//        textField6.setFont(font2);//设置文本域字体大小格式
//        textField6.setBounds(320,310,280,55);//图书名字文本框位置大小设定
//        jframe.add(textField6);//将文本框6添加到jframe窗体中
//
//
//
//        jLabel7 = new JLabel("图书类型修改为");//图书类型文本域
//        jLabel7.setFont(font2);//设置文本域字体大小格式
//        jLabel7.setBounds(83,410,220,55);//设置文本域的出现位置以及大小
//        jframe.add(jLabel7);//将文本域7添加到jframe窗体中
//
//        textField7 = new JTextField();//updata面板 文本框，信息为需要修改的图书类型
//        textField7.setFont(font2);//设置文本域字体大小格式
//        textField7.setBounds(320,410,280,55);//图书名字文本框位置大小设定
//        jframe.add(textField7);//将文本框7添加到jframe窗体中
//        jframe.repaint();//重绘界面
//
//
////        jframe.addWindowListener(new WindowAdapter() {//设置窗体监听器
////
////            public void windowClosing(WindowEvent e) {//当窗口关闭时执行的代码
////                super.windowClosing(e);
////                Main.staticdata.countup = 0; //设置countup为0，方便下次可以创建修改面板
////                System.out.println("1235555555555");
////
////
////            }
////        });
//
//
//    }
//--------------------------------------------分割线

    public void upd(){ //修改图书内容的主窗体

        JPanel jPanel = new JPanel();//创建面板1
        JPanel jPanel2 = new JPanel();//创建面板2
        JPanel jPanel3 = new JPanel();//创建面板3
        JPanel jPanel4 = new JPanel();//创建面板4

        //区分面板的颜色信息被注释掉，这里采用了面板JPanel添加组件
//        jPanel.setBackground(Color.RED); // 设置面板颜色为红色背景
//        jPanel2.setBackground(Color.YELLOW); // 设置面板颜色为蓝色背景
//        jPanel3.setBackground(Color.PINK); // 设置面板颜色为蓝色背景
//        jPanel4.setBackground(Color.GREEN);//设置面板颜色为绿色背景


        this.add(jPanel);//添加面板到窗体容器
        this.add(jPanel2);//将面板2添加到窗体
        this.add(jPanel3);//将面板3添加到窗体
        this.add(jPanel4);//将面板4添加到窗体
        jPanel.setBounds(0,0,300,48);//设置面板1的大小以及位置
        jPanel2.setBounds(0,55,300,98);//设置面板2的大小以及位置
        jPanel3.setBounds(0,155,300,108);//设置面板3的大小以及位置
        jPanel4.setBounds(0,275,300,88);//设置面板4的大小以及位置
        //this.setSize(500,410);//设置窗体大小
        this.setSize(310,410);//设置窗体大小
        setResizable(false);//设置窗口是否可以改变大小
        //this.setResizable(false);

        this.setTitle("图书修改");//设置窗口标题
        this.setLayout(null);//设置窗口布局
        setLayout(null);
        //this.setLayout(new BorderLayout(10,25)); //默认为0，0；水平间距10，垂直间距5
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭方式
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setVisible(true);//设置窗体可见
        //jPanel.setVisible(true);//

        bupdata = new JButton("修改图书信息");//创建修改图书按钮
        bupdata.setFont(font2);//设置按钮文字大小格式
        bupdata.setBounds(0,400,180,65);
        bup = new JButton("查询书名");
        bup.setFont(font2);//按钮文字采用28号
        bup.setBounds(0,300,180,65);

        jLabel2 = new JLabel("书籍名称为");//创建文本域并赋值，填写内容
        jLabel2.setFont(font2);//为文本域中的内容设定字体大小
        jLabel2.setBounds(0,0,280,55);//设置文本域的位置以及尺寸大小
        jLabel = new JLabel("输入要修改的图书ID");//创建文本域并赋值，填写内容
        jLabel.setFont(font2);//为文本域中的内容设定字体大小
        jLabel.setBounds(0,0,280,55);//设置文本域的位置以及尺寸大小
        textField = new JTextField(10);//创建图书修改的文本框
        textField.setFont(font2);//图书修改文本域文字大小使用28号字体
        textField.setLocation(0,20);//图书修改文本框位置大小设定
        textField2 = new JTextField(10);//创建图书修改的文本框//图书修改文本框变更为目标书籍名称
        textField2.setText("这里显示修改的书");//设置目标修改图书文本框的默认显示内容
        textField2.setFont(font2);//图书修改文本域文字大小使用28号字体
        textField2.setBounds(0,0,280,55);//图书修改文本框位置大小设定
        jPanel2.add(textField);//添加文本框到面板2，文本框为要输入的书籍ID
        jPanel3.add(textField2);//添加文本框到面板3，文本框为目标图书的书名
        jPanel3.add(bup);//查询书籍按钮添加到面板3
        jPanel4.add(bupdata);//修改书籍名称按钮添加到面板4
        repaint();

        jPanel.add(jLabel);//添加文本域到面板1中
        jPanel2.add(jLabel2);//添加文本域到面板1中
        this.setVisible(true);//设置窗体可见
        setVisible(true);//设置窗体可见
        bupdata.setEnabled(false);//设置"修改图书信息"按钮不可见,除非查出来了书籍信息


        //这里按下按钮可以出现图书名称信息  .另外加一个修改失败后会有怎样的行为的信息窗，已找到，就在这里
        bupdata.addMouseListener(new MouseListener() {//为修改信息按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件

                if(MainAp.staticdata.countupdata == 0){//当该窗口不存在时可以创建该窗口
                    MainAp.staticdata.countupdata = 1;//设置该窗体状态以及存在，防止创建多个该窗体
                    new Updata().updata();//实例化一个修改书籍信息的界面
                    new UpdataDef().updatadef();//修改失败信息框提示

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


        //查询键按下出现书籍信息后，修改图书信息按钮激活，可以按下,这里updata按键要加一个新的指示是否成功修改的信息窗，

        bup.addMouseListener(new MouseListener() {//为查询按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件
                //jPanel2.removeAll();//移除面板2中所有的内容
                //****System.out.println(gain(textField));//输出显示查询文本框中的信息
                booktext = gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext

                //Object object = updata(booktext);//将booktext传入seeall2方法中
                updata(booktext);//获得需要查询的文本框内容并进行数据库查找,查找书籍的ID
                textField2.setText(MainAp.staticdata.bokname);//修改文本框内容，内容为要修改的书籍名称
                if(MainAp.staticdata.bokname != ""){  //当静态字符串bokname不为空，bokname有内容时进行此判断

                    bupdata.setEnabled(true);//修改"修改图书信息"按钮进入激活可按状态


                }
                setVisible(true);//设置窗口内容可见


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


        this.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainAp.staticdata.countup = 0;  //countup重置为0
            }

        });


    }



    private String gain(JTextField textField) {//获取文本框中的文本信息的方法
        String text = textField.getText();//获取文本框中的内容信息
        //System.out.println("获取文本框内容");//提示信息
        return text;//返回框中的内容

    }

//---------------------------------------
    void  updata(String search) {//传入要查询的ID，进行数据库查询，并显示
//        time = 1;

//        int id = 0;
//        String name = null;
//        String author = null;
//        BigDecimal price = null;
//        int amount = 0;
//        String BookType = null;

        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '%" + search + "%'";

        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '" + search + "'";
        //String sql2 = "select id form t_book where id = ?";
        //SELECT 字段1,字段2,...  from 表名 where name like '%豪'
        String sql2 = "select id,bookname,bookauthor,bookprice,bookamount,booktype from t_book where id LIKE'" + search + "'";


        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem";
        String user = "root";
        String password = "123456";

        // 表格列名
        //String[] columnNames = {"ID", "BookName", "BookAuthor", "Price", "Amount", "BookType"};

        // 创建表格的数据模型
        //DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//        Object[] obj = new Object[]{id, name, author, price, amount, BookType};;
        {
            try {
                // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                Connection con = DriverManager.getConnection(url, user, password);
                // 创建Statement
                Statement stmt = con.createStatement();
                //PreparedStatement pstmt = con.prepareStatement(sql2);
                //pstmt.set
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

                    //*****System.out.println(name);


                    System.out.println(id);
                    MainAp.staticdata.upid = id;//查询到的图书ID写入到静态类的属性中
                    System.out.println(name);
                    MainAp.staticdata.bokname = name;//查询到的图书名称写入到静态类的属性中
                    System.out.println(author);
                    MainAp.staticdata.bokauthor = author;//查询到的图书作者写入到静态类的属性中
                    System.out.println(price);
                    MainAp.staticdata.bokprice = price;//查询到的图书价格写入到静态类的属性中
                    System.out.println(amount);
                    MainAp.staticdata.bokamount = amount;//查询到的图书数量写入到静态类的属性中
                    System.out.println(BookType);
                    MainAp.staticdata.boktype = BookType;//查询到的图书类型写入到静态类的属性中
                    // 将数据添加到表格模型
                    //model.addRow(new Object[]{id, name, author, price, amount, BookType});


                    ;

                }

                // 关闭资源
                rs.close();
                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }


        //--------------------------------------------------
        //jtable = new JTable(model);//表格模型添加到表
        //jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****

        // 创建表格
        // JTable table = new JTable(model);  //关键注释

        // 创建滚动面板来容纳表格
        //JScrollPane scrollPane = new JScrollPane(table); //关键注释

        //分割线------------------------------------


    }//updata() end


}
