package com.book.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame{

    //amount方法中的声明项
    private JLabel jLblank;//"账号注册信息中不能有空框"文本域声明
    private JButton bdef;//"账号注册信息中不能有空框"弹出窗的确定按钮

    private String addAccount;//新注册的账号

    private String addPass;//新注册账号的密码

    private String account;	//管理员账号字符串
    private String password;//管理员密码字符串

    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    private JButton bre;//按钮1  重置为空信息

    private JButton blog;//注册按钮 的声明

    private JLabel jLaccount;//请输入您的账号
    private JLabel jLpass;//请输入您的密码

    private JLabel jLaccount2;//请输入管理员的账号

    private JLabel jLpass2;//请输入管理员的密码

    private JTextField textField;//文本框，信息为输入的注册账号

    private JTextField textField2;// 文本框，信息为输入的注册账号的密码

    private JTextField jAdmini;//文本框，信息为输入的管理员账号

    //private JTextField textField4;//文本框，信息为输入的管理员密码
    private JPasswordField jPassword;//密码文本框 管理员密码用这个

    void register() {
        MainAp.staticdata.countreg = 1;

        setTitle("注册");//设置窗口标题
        setSize(500,440);//设置窗口大小
        setLayout(null);//设置窗口布局
        setResizable(false);//设置窗口是否可以改变大小
        this.setLocationRelativeTo(null);//窗口居中显示
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭方式
        setVisible(true);//设置窗口可见
        jLaccount = new JLabel("账号");//实例化账号文本域，并为账号文本域赋值
        jLaccount.setFont(font2);//设置账号文本域的文字的大小格式
        jLaccount.setBounds(60,20,220,55);//账号文本域的位置大小设置
        jLpass = new JLabel("密码");//实例化密码文本域,并为密码文本域赋值
        jLpass.setFont(font2);//设置密码文本域的字体大小格式
        jLpass.setBounds(59,95,220,55);//密码文本域的位置大小设置
        jLaccount2 = new JLabel("管理员账号");//实例化文本域  管理员账户文本域
        jLaccount2.setFont(font2);//管理员账号文本域文字大小格式设置
        jLaccount2.setBounds(0,160,220,55);//设置管理员账号文本域的位置大小
        jLpass2 = new JLabel("管理员密码");//实例化文本域 管理员密码文本域
        jLpass2.setFont(font2);//管理员密码文本域字体大小设置
        jLpass2.setBounds(0,230,220,55);//设置管理员密码文本域的位置大小
        add(jLpass2);//将“管理员密码”文本域添加到窗口
        add(jLaccount2);//将“管理员账户”文本域添加到窗口
        add(jLpass);//将“密码”文本域添加到窗口
        add(jLaccount); //将"账号"文本域添加到窗口
        textField = new JTextField();//实例化文本框，该文本框为 输入的账号
        textField.setFont(font2);//为文本框设置字体大小格式
        textField.setBounds(150,20,280,55);//账号文本框的位置大小设置
        textField2 = new JTextField();//实例化密码文本框，该文本框为 输入的密码
        textField2.setFont(font2);//为密码文本框设置文字大小格式
        textField2.setBounds(150,95,280,55);//密码文本框位置大小格式
        jAdmini = new JTextField();//管理员账户文本框实例化文本框对象
        jAdmini.setFont(font2);//管理员账号文本框设置字体大小格式
        jAdmini.setBounds(150,160,280,55);//管理员账户文本框大小位置
        jPassword = new JPasswordField();//管理员密码文本框 实例化文本框对象
        jPassword.setFont(font2);//管理员密码文本框 字体大小格式的设置
        jPassword.setBounds(150,230,280,55);//管理员密码文本框大小位置
        add(textField);//将账号文本框添加到窗口
        add(textField2);//将密码文本框添加到窗口
        add(jAdmini);//将管理员账号文本框添加到窗口
        add(jPassword);//将管理员密码文本框添加到窗口
        bre = new JButton("重置信息");//按钮实例化，按钮为重置注册信息按钮
        bre.setFont(font2);//重置按钮文字大小格式的设置
        bre.setBounds(40,310,170,55);
        blog = new JButton("注册账号");//注册账户的按钮  实例化
        blog.setFont(font2);//注册账户的按钮字体大小格式设置
        blog.setBounds(270,310,170,55);
        add(blog);//将注册按钮添加到窗口中
        add(bre);//将重置按钮添加到注册窗口中
        blog.addActionListener(listener);//给注册账号按钮添加监听事件

        repaint();//窗口重绘

        bre.addMouseListener(new MouseListener() {//为重置按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//添加鼠标单击事件
                textField.setText("");//将账号文本框设置为空
                textField2.setText("");//将密码文本框设置为空
                jAdmini.setText("");//将管理员账号文本框设置为空
                jPassword.setText("");//将管理员密码文本框设置为空

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
                MainAp.staticdata.countreg = 0;  //countreg注册窗口是否存在 ，重置为0，表示不存在
            }

        });




    }//register注册方法  end



    //以下为获取文本框信息的方法
    String gain(JTextField textField) {//获得账号文本框的内容信息
        String text = textField.getText();//获取账号文本框中的内容信息
        //System.out.println("获取文本框内容");//提示信息
        return text;//返回账号框中的内容
    }

    String gain2(JPasswordField jPassword) {//获取密码文本框中的内容
        char[] text = jPassword.getPassword();//获取密码框字符数集
        String password = String.valueOf(text);//将字符数集转化为字符串
        return password;//返回密码框中的内容
    }



    ActionListener listener = new ActionListener() {//添加事件监听

        @Override
        public void actionPerformed(ActionEvent e) {//重写方法
            account= gain(jAdmini);//调用此方法获取管理员账号文本框信息
            System.out.println("您输入的账号为" + account);//输出管理员用户输入的账号
            password = gain2(jPassword);//获取管理员密码框中的内容信息

            System.out.println("您输入的密码为：" + password);//输出管理员用户输入的密码


            addAccount = gain(textField);//将从新注册账号的账号文本框获取的文本信息赋值到已经声明的注册账号字符串中
            addPass = gain(textField2);//将从新注册账号的密码文本框获取的文本信息赋值到已经声明的注册账号的密码字符串中

            if(jdbc2(account,password))  {  //管理员账号密码和数据库横纵的密码进行比对

                updata3(addAccount,addPass);
                MainAp.staticdata.countreg = 0;//设置此注册窗口不存在，重置为0方便下次创建
                dispose();


            }


        }
    };//listener  END


    //以下代码为复制粘贴内容，源码在Enter中，有所更改,while循环变为if
    boolean jdbc2(String account,String password){//定义jdbc连接数据库方法
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
                    if(password2.equals(password)&&account.equals(name)) {//如果用户输入的密码与数据库中的密码相同进入此if中
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




    //实现获得信息并将信息更新进数据库的方法
    void  updata3(String addname2,String addpass2) {//新增数据库表信息，为使用者账号和密码


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


                //填上管理员密码后的新增账号空框提示
                //注册信息不能为空，测试异常
                if(addname2.equals("")||addpass2.equals("")){//如果任意项为空则抛出异常，停止后续代码的执行，防止空值进入数据库

                    System.out.println("账号密码不为空");
                    throw new Exception();//如果信息为空抛出异常停止以后的代码执行
                }

//                //图书数量与不为0：
//                if(bookamount < 0||bookprice.compareTo(bokamount)<0){//与声明的数量为0进行比较
//                    throw new RuntimeException();//如果信息为空抛出异常停止以后的代码执行
//                }


                //使用PreparedStatement
                //  准备SQL语句
                String sqladd = "INSERT INTO t_user (username, password) VALUES (?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sqladd);

                // 4. 设置参数值
                preparedStatement.setString(1, addname2);//为第1个问号赋值
                preparedStatement.setString(2, addpass2);//为第2个问号赋值






                int rowsAffected = preparedStatement.executeUpdate();




                if(rowsAffected == 1){//如果所有新增成功了就执行以下代码，弹出成功窗口
                    System.out.println("注册账号成功");//在控制台输出"注册成功"
                    if(MainAp.staticdata.countregwin == 0){//检查成功窗口是否为一个
                        win();
                    }
                }




                // 关闭资源
//                rs.close();
                preparedStatement.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            } catch (RuntimeException e) {
                //amount();
                throw new RuntimeException(e);
            } catch (Exception e) {
                amount();
                throw new RuntimeException(e);
            }
        }



    }//updata2() end

    //注册成功后弹出的注册成功的消息窗
    void win(){
        MainAp.staticdata.countregwin = 1;//本窗体是否已经存在以及只能存在一个该窗体的判断代码//此处为注册成功信息成功
        JButton win;//声明一个按钮
        JLabel jLabel ;//注册成功的提示
        JFrame jwin = new JFrame();//创建一个窗体对象
        jwin.setTitle("注册账号信息成功");
        jwin.setLayout(null);//设置窗体布局管理器为绝对布局
        jwin.setSize(400,280);//设置窗体大小
        jwin.setLocationRelativeTo(null);//窗口居中显示
        jwin.setResizable(false);//设置窗口是否可以改变大小
        jLabel = new JLabel("注册账号信息成功");//实例化文本域
        win = new JButton("确定");//实例化一个按钮。确认注册成功的按钮
        win.setFont(font2);//设置按钮字体大小样式
        jLabel.setFont(font2);//设置文本域字体大小样式
        jLabel.setBounds(76,-28,250,200);//设置成功信息文字的大小和位置
        win.setBounds(96,134,180,55);//设置确定按钮的大小和位置
        jwin.add(win);//添加确认按钮到窗体
        jwin.add(jLabel);//将文本域加入到成功窗体中
        jwin.setVisible(true);//设置弹出的窗体可见
        win.addMouseListener(new MouseListener() {//定义注册成功窗口中按钮的监听事件
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件
                jwin.dispose();//jwin窗体关闭
                MainAp.staticdata.countregwin = 0;//将验证是否存在此窗口的判断重置为0，方便下次再次弹出成功信息窗口
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
                MainAp.staticdata.countregwin = 0;  //countup重置为0
            }

        });

    }   //win  end


    //注册信息中不能有空缺文本框
    void amount(){

        JFrame jframeamount = new JFrame(); //注册账号信息框中不能有空，提示框
        jframeamount.setSize(410, 200);//设置窗体大小
        jframeamount.setTitle("注册内容不能为空");
        jframeamount.setLocationRelativeTo(null);//窗口居中显示
        jframeamount.setResizable(false);//设置窗口是否可以改变大小
        jframeamount.setLayout(null);//设置窗体布局为绝对布局
        jframeamount.setVisible(true);//设置窗体可见
        jframeamount.setAlwaysOnTop(true);//设置窗口前置
        jLblank = new JLabel("账号注册信息中不能有空框");//实例化文本域信息，并初始化信息内容
        jLblank.setFont(font2);//修改提示信息文本域的字体大小格式
        jLblank.setBounds(10,15,400,55);//设置信息文本域出现的位置以及大小
        jframeamount.add(jLblank);//添加文本域到此窗口
        bdef = new JButton("确认信息");//实例化按钮对象并初始化按钮信息
        bdef.setFont(font2);//设置按钮文字大小格式
        bdef.setBounds(100,75,180,55);
        jframeamount.add(bdef);

        //按下按钮关闭窗口
        bdef.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //按钮单击事件
                jframeamount.dispose(); //退出此窗口
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


    }


}
