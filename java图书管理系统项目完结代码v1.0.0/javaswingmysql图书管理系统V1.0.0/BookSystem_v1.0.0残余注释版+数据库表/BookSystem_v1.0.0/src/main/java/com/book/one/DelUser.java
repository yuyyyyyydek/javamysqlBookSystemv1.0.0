package com.book.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class DelUser extends JFrame {

    private String usertext;//接受删除用户ID的文本框


    private String addAccount;//新注册的账号

    private String addPass;//新注册账号的密码

    private String account;	//管理员账号字符串
    private String password;//管理员密码字符串

    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    private JButton bse;//按钮1  重置为空信息********

    private JButton bdel;//注册按钮 的声明

    private JLabel jLaccount;//请输入您的账号
    private JLabel jLName;//请输入您的密码

    private JLabel jLaccount2;//请输入管理员的账号

    private JLabel jLpass2;//请输入管理员的密码

    private JTextField textField;//文本框，信息为 输入的删除账号ID

    private JTextField textField2;// 文本框，信息为 指定ID的账号字符串

    private JTextField jAdmini;//文本框，信息为输入的管理员账号

    //private JTextField textField4;//文本框，信息为输入的管理员密码
    private JPasswordField jPassword;//密码文本框 管理员密码用这个

    void delUser(){


            MainAp.staticdata.countuserdel = 1;

            setTitle("删除用户信息");//设置窗口标题
            setSize(500,440);//设置窗口大小
            setLayout(null);//设置窗口布局
            setResizable(false);//设置窗口是否可以改变大小
            this.setLocationRelativeTo(null);//窗口居中显示
            setVisible(true);//设置窗口可见
            jLaccount = new JLabel("账号ID");//实例化账号ID文本域，并为账号文本域赋值
            jLaccount.setFont(font2);//设置账号文本域的文字的大小格式
            jLaccount.setBounds(30,20,220,55);//账号ID文本域的位置大小设置
            jLName = new JLabel("账号为:");//实例化账号内容文本域,初始化内容为  账号为：
            jLName.setFont(font2);//设置密码文本域的字体大小格式
            jLName.setBounds(30,95,220,55);//"账号为"文本域的位置大小设置
            jLaccount2 = new JLabel("管理员账号");//实例化文本域  管理员账户文本域
            jLaccount2.setFont(font2);//管理员账号文本域文字大小格式设置
            jLaccount2.setBounds(0,160,220,55);//设置管理员账号文本域的位置大小
            jLaccount2.setEnabled(false);//管理员账号文本域设置为不可用
            jLpass2 = new JLabel("管理员密码");//实例化文本域 管理员密码文本域
            jLpass2.setFont(font2);//管理员密码文本域字体大小设置
            jLpass2.setBounds(0,230,220,55);//设置管理员密码文本域的位置大小
            jLpass2.setEnabled(false);//管理员密码文本域设置不可用
            add(jLpass2);//将“管理员密码”文本域添加到窗口
            add(jLaccount2);//将“管理员账户”文本域添加到窗口
            add(jLName);//将“账号为”文本域添加到窗口
            add(jLaccount); //将"账号ID"文本域添加到窗口
            textField = new JTextField();//实例化文本框，该文本框为 输入的账号ID
            textField.setFont(font2);//为文本框设置字体大小格式
            textField.setBounds(150,20,280,55);//账号ID文本框的位置大小设置
            textField2 = new JTextField("此框显示账号信息");//实例化“账号为”文本框，该文本框为 账号为 的账号字符
            textField2.setFont(font2);//为账号字符文本框设置文字大小格式
            textField2.setBounds(150,95,280,55);//账号字符文本框位置大小格式
            jAdmini = new JTextField();//管理员账户文本框实例化文本框对象
            jAdmini.setFont(font2);//管理员账号文本框设置字体大小格式
            jAdmini.setBounds(150,160,280,55);//管理员账户文本框大小位置
            jAdmini.setEnabled(false);//管理员账号框不可用
            jPassword = new JPasswordField();//管理员密码文本框 实例化文本框对象
            jPassword.setFont(font2);//管理员密码文本框 字体大小格式的设置
            jPassword.setBounds(150,230,280,55);//管理员密码文本框大小位置
            jPassword.setEnabled(false);//管理员密码框不可用
            add(textField);//将账号ID文本框添加到窗口
            add(textField2);//将账号为文本框添加到窗口

            add(jAdmini);//将管理员账号文本框添加到窗口
            add(jPassword);//将管理员密码文本框添加到窗口
            bse = new JButton("查询用户");//按钮实例化，按钮为重置查询用户按钮
            bse.setFont(font2);//查询用户按钮文字大小格式的设置
            bse.setBounds(40,310,170,55);
            bdel = new JButton("删除账号");//删除账户的按钮  实例化
            bdel.setFont(font2);//删除账户的按钮字体大小格式设置
            bdel.setBounds(270,310,170,55);
            bdel.setEnabled(false);//删除账号按钮不可用设置
            add(bdel);//将删除账号按钮添加到窗口中
            add(bse);//将查询用户按钮添加到注册窗口中
            //blog.addActionListener(listener);//给注册账号按钮添加监听事件

        bdel.addMouseListener(new MouseListener() {//为删除按钮添加事件监听器
                @Override
                public void mouseClicked(MouseEvent e) {

                    account= gain(jAdmini);//调用此方法获取管理员账号文本框信息
                    System.out.println("您输入的账号为" + account);//输出管理员用户输入的账号
                    password = gain2(jPassword);//获取管理员密码框中的内容信息

                    System.out.println("您输入的密码为：" + password);//输出管理员用户输入的密码


                    addAccount = gain(textField);//将从新注册账号的账号文本框获取的文本信息赋值到已经声明的注册账号字符串中
                    addPass = gain(textField2);//将从新注册账号的密码文本框获取的文本信息赋值到已经声明的注册账号的密码字符串中

                    if(jdbc3(account,password))  {  //管理员账号密码和数据库横纵的密码进行比对

                        updata3();//根据静态变量ID进行删除

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

            repaint();//窗口重绘

        bse.addMouseListener(new MouseListener() {//为重置按钮添加鼠标监听器
                @Override
                public void mouseClicked(MouseEvent e) {//添加鼠标单击事件

                    usertext = gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext


                    updata(usertext);//获得需要查询的文本框内容并进行数据库查找,查找书籍的ID
                    textField2.setText(MainAp.staticdata.user);//修改文本框内容，内容为要修改的书籍名称


                    if(MainAp.staticdata.user != ""){  //当静态字符串bokname2不为空，bokname2有内容时进行此判断

                        bdel.setEnabled(true);//修改"修改图书信息"按钮进入激活可按状态

                        jLaccount2.setEnabled(true);//管理员账号文本域设置为不可用
                        jLpass2.setEnabled(true);//管理员密码文本域设置不可用
                        jAdmini.setEnabled(true);//管理员账号框激活可用
                        jPassword.setEnabled(true);//管理员密码框激活可用


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


            //设置窗体关闭执行的代码
            addWindowListener(new WindowAdapter() {//添加窗体监听器

                public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                    super.windowClosing(e);
                    MainAp.staticdata.countuserdel = 0;  //countup重置为0
                }

            });



    }//delUser()方法  end



    //复制的代码，
    void  updata(String search) {//传入要查询的ID，进行数据库查询，并显示


        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '%" + search + "%'";

        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '" + search + "'";
        //String sql2 = "select id form t_book where id = ?";
        //SELECT 字段1,字段2,...  from 表名 where name like '%豪'
        String sql2 = "select id,username from t_user where id LIKE'" + search + "'";


        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem";
        String user = "root";
        String password = "123456";


        {
            try {
                // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                Connection con = DriverManager.getConnection(url, user, password);
                // 创建Statement
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);


                // 遍历结果集
                while (rs.next()) {

                    // 根据列名获取数据
                    int id = rs.getInt("id");//前面声明的id用于后续代码，括号中的ID为数据库表中的列名
                    String username = rs.getString("username");//前面声明的username用于后续代码，括号中的username为数据库表中的列名



                    System.out.println(id);
                    MainAp.staticdata.deid3 = id;//查询到的id 写入到静态类的属性中这里是deid3
                    System.out.println(user);
                    MainAp.staticdata.user = username;//这里是username。查询到的书名写入到静态类的属性user中




                }

                // 关闭资源
                rs.close();
                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }


    }//updata() end



    //工具类，复制的代码，用于获取文本框中的内容
    private String gain(JTextField textField) {//获取文本框中的文本信息的方法
        String text = textField.getText();//获取文本框中的内容信息
        //System.out.println("获取文本框内容");//提示信息
        return text;//返回框中的内容

    }


    String gain2(JPasswordField jPassword) {//获取密码文本框中的内容
        char[] text = jPassword.getPassword();//获取密码框字符数集
        String password = String.valueOf(text);//将字符数集转化为字符串
        return password;//返回密码框中的内容
    }



    void  updata3() {//删除数据库信息的方法，传入要删除的数据信息，根据静态变量ID查找



        String sql="delete from t_user where id='"+ MainAp.staticdata.deid3+"' ";//生成一条mysql语句


        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem";
        String user = "root";
        String password = "123456";



        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            Connection con = DriverManager.getConnection(url, user, password);
            // 创建Statement
            Statement stmt = con.createStatement();

            int rs = stmt.executeUpdate(sql);


            if(rs == 1){//如果所有删除成功了就执行以下代码，弹出成功窗口
                System.out.println("删除成功");//在控制台输出"修改成功"
                if(MainAp.staticdata.countuserdelwin == 0){//检查成功窗口是否为一个
                    win();
                }
            }



            // 关闭资源
//                rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();


        }




    }//updata2() end


    //删除成功后弹出的删除成功的消息窗
    void win(){
        MainAp.staticdata.countuserdelwin = 1;//本窗体是否已经存在以及只能存在一个该窗体的判断代码
        JButton win;//声明一个按钮
        JLabel jLabel ;//删除成功的提示
        JFrame jwin = new JFrame();//创建一个窗体对象
        jwin.setTitle("删除用户信息成功");
        jwin.setLayout(null);//设置窗体布局管理器为绝对布局
        jwin.setSize(400,280);//设置窗体大小
        jwin.setLocationRelativeTo(null);//窗口居中显示
        jwin.setResizable(false);//设置窗口是否可以改变大小
        jLabel = new JLabel("删除用户信息成功");//实例化文本域
        win = new JButton("确定");//实例化一个按钮
        win.setFont(font2);//设置按钮字体大小样式
        jLabel.setFont(font2);//设置文本域字体大小样式
        jLabel.setBounds(76,-28,250,200);//设置成功信息文字的大小和位置
        win.setBounds(96,134,180,55);//设置确定按钮的大小和位置
        jwin.add(win);//添加确认按钮到窗体
        jwin.add(jLabel);//将文本域加入到成功窗体中
        jwin.setVisible(true);//设置弹出的窗体可见
        win.addMouseListener(new MouseListener() {//定义删除成功窗口中按钮的监听事件
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件

                MainAp.staticdata.countuserdelwin = 0;//将验证是否存在此窗口的判断重置为0，方便下次再次弹出成功信息窗口
                jwin.dispose();//jwin窗体关闭
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

        //设置窗体关闭执行的代码
        jwin.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainAp.staticdata.countuserdelwin = 0;  //countup重置为0
            }

        });

    }   //win  end



    //以下代码为复制粘贴内容，源码在Enter中，有所更改,while循环变为if，
    //作用为让传入的账号密码和数据库中的账号密码进行比较
    boolean jdbc3(String account,String password){//定义jdbc连接数据库方法
        // JDBC驱动程序名称及URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/booksystem";
        // 数据库登录信息
        String username = "root";
        String Password = "123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //2.注册驱动

            Class.forName(driver);
            //3.获取数据库连接对象
            conn = DriverManager.getConnection(url,username,Password);


            //5.获取执行sql的对象 Statement,创建Statement对象
            stmt = conn.createStatement();

            //执行sql
            String sql = "SELECT admini,admpass FROM t_admini";//sql语句
            rs = stmt.executeQuery(sql);//获取查询语句执行结果


            while (rs.next()) {//查询结果rs遍历，循环输出
                String name = rs.getString("admini");//获取从数据库查询到的用户信息至name属性
                String password2 =rs.getString("admpass");//获取从数据库查询到的密码信息至password2属性


                //此处为判断传进来的账号密码信息是否与查询数据库中信息是否一致
                //password2接受了数据库中的密码信息，与传参进来的password进行比较
                //account为传参进来的账号信息，与数据库查询到的账号信息name进行比较
                if(password2.equals(password)&&account.equals(name)) {//如果用户输入的管理员密码与数据库中的管理员密码相同进入此if中
                    System.out.println("管理员账号登录成功");//提示用户登录成功
                    System.out.println("管理员密码password:" + password2);//输出用户输入的正确密码
                    return true;//返回ture
                }




            }
            System.out.println("登录失败，请重新输入");//账号密码为空或输如的账号密码不在数据库中，输出此警告信息

            return false;//信息不正确，返回false，以便其它循环条件的使用

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();//打印异常信息
        }finally {

            try {
                if (stmt!=null){//如果stmt不为空，释放此资源
                    //8.释放资源
                    stmt.close(); //关闭Statement对象
                }
            } catch (SQLException throwables) {//出现异常后执行的代码
                throwables.printStackTrace();//打印异常信息
            }

            try {
                if (conn!=null){//如果conn不为空，释放此资源
                    conn.close();//关闭数据库连接对象
                }
            } catch (SQLException throwables) {//出现异常后执行的代码
                throwables.printStackTrace();//抛出异常信息
            }
        }
        return false;
    }//JDBC  end


}
