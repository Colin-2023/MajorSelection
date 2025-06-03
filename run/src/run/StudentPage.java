/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import java.net.URL; 
import java.net.URI;
import java.lang.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static run.HomePage2.con;
import static run.ModifyCodePage.sql;
/**
 *
 * @author HP
 */
public class StudentPage extends Page{  //学生界面的类
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public static JFrame jf = new JFrame("计算机大类专业分流软件");  //将组件设为对象便于后续控制
    Container c = jf.getContentPane();//定义容器
    public static JLabel jl8 = new JLabel();
    public static JLabel jl9 = new JLabel();
    public static JLabel jl10 = new JLabel();
    public static JLabel jl11 = new JLabel();
    public static JLabel jl12 = new JLabel();
    
    public static Student s1 = new Student(); //建立学生对象
    
    public void show()
    {
        
        jf.setLocation(500,200);
       // JLabel imgLabel = new JLabel(new ImageIcon(Run.class.getResource("/pic/1.png")));  //可以打包进jar包的
        //jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        //imgLabel.setSize(900,600);   
        
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景
        jf.setLayout(null);
        jf.setSize(900, 600);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口方式，直接关闭
        jf.setVisible(true); //窗口可见
        
        JLabel jl1 = new JLabel("欢迎登陆计算机专业分流系统");
        jl1.setFont(new Font("华文行楷",  2,  30));
        jl1.setBounds(0,20,425,50);
        c.add(jl1);
        
        JLabel jl2 = new JLabel("姓名：");
        jl2.setFont(new Font("黑体",  2,  23));
        jl2.setBounds(320,125,100,50);
        c.add(jl2);
        
        JLabel jl3 = new JLabel("学号：");
        jl3.setFont(new Font("黑体",  2,  23));
        jl3.setBounds(320,175,100,50);
        c.add(jl3);
        
        JLabel jl4 = new JLabel("学院：信息学院");
        jl4.setFont(new Font("黑体",  2,  23));
        jl4.setBounds(320,225,250,50);
        c.add(jl4);
        
        JLabel jl5 = new JLabel("入学时间：");
        jl5.setFont(new Font("黑体",  2,  23));
        jl5.setBounds(270,275,250,50);
        c.add(jl5);
        
        JLabel jl6 = new JLabel("专业：");
        jl6.setFont(new Font("黑体",  2,  23));
        jl6.setBounds(310,325,250,50);
        c.add(jl6);
        
        JLabel jl7 = new JLabel("班级：");
        jl7.setFont(new Font("黑体",  2,  23));
        jl7.setBounds(310,375,250,50);
        c.add(jl7);
        
        JButton jb1 = new JButton("修改密码");
        jb1.setBounds(200, 450, 143, 47); 
        jb1.setContentAreaFilled(false); //设置按钮透明
        jb1 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb1.addMouseListener(new MouseListener() {    
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb1.setBorder(BorderFactory.createLoweredBevelBorder());  
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发   
            jb1.setBorder(BorderFactory.createRaisedBevelBorder()); 
            //jf.dispose();//销毁窗口
            ModifyCodePage mod = new ModifyCodePage();
            mod.show();
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb1);
        
        JButton jb2 = new JButton("志愿填报");
        jb2.setBounds(550, 450, 143, 47); 
        jb2.setContentAreaFilled(false); //设置按钮透明
        jb2 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb2.addMouseListener(new MouseListener() {    
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb2.setBorder(BorderFactory.createLoweredBevelBorder());  
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发   
            jb2.setBorder(BorderFactory.createRaisedBevelBorder()); 
            //jf.dispose();//销毁窗口
            ChooseMajorPage choosemajorpage = new ChooseMajorPage();
            choosemajorpage.show();
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb2);
        
        getmessage();//调用获取对应登录者的信息并显示
        
    }
    
    public void getmessage()  //获取学生详细信息的方法
    {
        
        
        //与数据库进行联系
        Connect con1 = new Connect();
        con=con1.getConnection();
        try
        {          
            sql=con.prepareStatement("select * from school.student where xuehao like ?");  
            sql.setString(1, HomePage2.input1);    //显示对应学号的学生信息
            res=sql.executeQuery();           
            //遍历查询结果
            while(res.next())
            {               
                //将数据从数据库中导出来                                              
                s1.name = res.getString("name");
                s1.xuehao = res.getString("xuehao");
                s1.time = res.getString("time");
                s1.major = res.getString("major");
                s1.class0= res.getString("class");
                
                
                jl8.setText(s1.name);
                jl8.setFont(new Font("黑体",  2,  23));
                jl8.setBounds(390,125,100,50);
                c.add(jl8);
                
                
                jl9.setText(s1.xuehao);
                jl9.setFont(new Font("黑体",  2,  23));
                jl9.setBounds(390,175,150,50);
                c.add(jl9);
                
                
                jl10.setText(s1.time);
                jl10.setFont(new Font("黑体",  2,  23));
                jl10.setBounds(390,275,250,50);
                c.add(jl10);
                
                
                jl11.setText(s1.major);
                jl11.setFont(new Font("黑体",  2,  23));
                jl11.setBounds(390,325,250,50);
                c.add(jl11);
                
                jl12.setText(s1.class0);
                jl12.setFont(new Font("黑体",  2,  23));
                jl12.setBounds(390,375,250,50);
                c.add(jl12);
            }                      
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }   
        
    }
                 
    
}
