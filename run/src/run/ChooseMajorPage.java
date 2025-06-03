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



/**
 *
 * @author HP
 */
public class ChooseMajorPage extends Page{  //选择专业的页面类
    
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    int num=0;//记录一共从数据库中读到几个专业
    
    JFrame jf = new JFrame("计算机大类专业分流软件");
    JComboBox<String> comboBox1=new JComboBox<>(); //定义选项框
    JComboBox<String> comboBox2=new JComboBox<>();
    JComboBox<String> comboBox3=new JComboBox<>();
    JComboBox<String> comboBox4=new JComboBox<>();
    JComboBox<String> comboBox5=new JComboBox<>();
    JButton jb1 = new JButton("确定");
    JButton jb2 = new JButton("关闭");
    
    public void show()
    {
       
        Container c = jf.getContentPane();//定义容器
        jf.setLocation(600,300);
       // JLabel imgLabel = new JLabel(new ImageIcon(Run.class.getResource("/pic/1.png")));  //可以打包进jar包的
        //jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        //imgLabel.setSize(900,600);   
        
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景
        jf.setLayout(null);
        jf.setSize(900, 600);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭窗口方式，直接关闭
        jf.setVisible(true); //窗口可见
        
        JLabel jl1 = new JLabel("请选择你选择的专业：");
        jl1.setFont(new Font("华文行楷",  2,  30));
        jl1.setBounds(0,20,425,50);
        c.add(jl1);
        
        //连接数据库看一共有几个专业
        Connect con1 = new Connect();
        con=con1.getConnection();   
        try
        {             
                sql=con.prepareStatement("select * from school.profession ");   //检验输入的学号/职工号密码是否正确                                
                res=sql.executeQuery(); 
                                                             
                while(res.next())
                {                                                                             
                    num++;
                    System.out.print(num);
                }
                
                if(num == 1)  //当只有一个专业时
                {
                    JLabel jl2 = new JLabel("专业一：");
                    jl2.setFont(new Font("黑体",  2,  23));
                    jl2.setBounds(300,125,100,50);
                    c.add(jl2);
                    
                    comboBox1.addItem("请选择");
                    comboBox1.setBounds(400, 125, 280, 50);
                    comboBox1.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox1);
                    
                    
                    sql=con.prepareStatement("select * from school.profession ");   //连接数据库读取里面有的科目                                
                    res=sql.executeQuery(); 
                    String major1;
                    while(res.next())
                    {                                                                             
                        major1=res.getString("name");
                        comboBox1.addItem(major1);
                    }
                    
                }
                
                if(num == 2)   //当有两个专业时
                {
                    JLabel jl2 = new JLabel("专业一：");
                    jl2.setFont(new Font("黑体",  2,  23));
                    jl2.setBounds(300,125,100,50);
                    c.add(jl2);
        
                    JLabel jl3 = new JLabel("专业二：");
                    jl3.setFont(new Font("黑体",  2,  23));
                    jl3.setBounds(300,175,100,50);
                    c.add(jl3);
                    
                    comboBox1.addItem("请选择");
                    comboBox1.setBounds(400, 125, 280, 50);
                    comboBox1.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox1);
                    
                    comboBox2.addItem("请选择");
                    comboBox2.setBounds(400, 175, 280, 50);
                    comboBox2.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox2);
                    
                    sql=con.prepareStatement("select * from school.profession ");   //连接数据库读取里面有的科目                                
                    res=sql.executeQuery(); 
                    String major1;                    
                    while(res.next())
                    {                                                                             
                        major1=res.getString("name");
                        comboBox1.addItem(major1);
                        comboBox2.addItem(major1);
                    }
                    
                    
                    
                    
                }
                
                if(num == 3)   //当有三个专业时
                {
                    JLabel jl2 = new JLabel("专业一：");
                    jl2.setFont(new Font("黑体",  2,  23));
                    jl2.setBounds(300,125,100,50);
                    c.add(jl2);
        
                    JLabel jl3 = new JLabel("专业二：");
                    jl3.setFont(new Font("黑体",  2,  23));
                    jl3.setBounds(300,175,100,50);
                    c.add(jl3);
        
                    JLabel jl4 = new JLabel("专业三：");
                    jl4.setFont(new Font("黑体",  2,  23));
                    jl4.setBounds(300,225,250,50);
                    c.add(jl4);
                    
                    comboBox1.addItem("请选择");
                    comboBox1.setBounds(400, 125, 280, 50);
                    comboBox1.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox1);
                    
                    comboBox2.addItem("请选择");
                    comboBox2.setBounds(400, 175, 280, 50);
                    comboBox2.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox2);
                    
                    comboBox3.addItem("请选择");
                    comboBox3.setBounds(400, 225, 280, 50);
                    comboBox3.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox3);
                    
                    sql=con.prepareStatement("select * from school.profession ");   //连接数据库读取里面有的科目                                
                    res=sql.executeQuery(); 
                    String major1;                    
                    while(res.next())
                    {                                                                             
                        major1=res.getString("name");
                        comboBox1.addItem(major1);
                        comboBox2.addItem(major1);
                        comboBox3.addItem(major1);
                    }
                    
                    
                }
                
                if(num == 4)   //当有四个专业时
                {
                    JLabel jl2 = new JLabel("专业一：");
                    jl2.setFont(new Font("黑体",  2,  23));
                    jl2.setBounds(300,125,100,50);
                    c.add(jl2);
        
                    JLabel jl3 = new JLabel("专业二：");
                    jl3.setFont(new Font("黑体",  2,  23));
                    jl3.setBounds(300,175,100,50);
                    c.add(jl3);
        
                    JLabel jl4 = new JLabel("专业三：");
                    jl4.setFont(new Font("黑体",  2,  23));
                    jl4.setBounds(300,225,250,50);
                    c.add(jl4);
        
                    JLabel jl5 = new JLabel("专业四：");
                    jl5.setFont(new Font("黑体",  2,  23));
                    jl5.setBounds(300,275,250,50);
                    c.add(jl5);
                    
                    comboBox1.addItem("请选择");
                    comboBox1.setBounds(400, 125, 280, 50);
                    comboBox1.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox1);
                    
                    comboBox2.addItem("请选择");
                    comboBox2.setBounds(400, 175, 280, 50);
                    comboBox2.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox2);
                    
                    comboBox3.addItem("请选择");
                    comboBox3.setBounds(400, 225, 280, 50);
                    comboBox3.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox3);
                    
                    comboBox4.addItem("请选择");
                    comboBox4.setBounds(400, 275, 280, 50);
                    comboBox4.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox4);
                    
                    sql=con.prepareStatement("select * from school.profession ");   //连接数据库读取里面有的科目                                
                    res=sql.executeQuery(); 
                    String major1;                    
                    while(res.next())
                    {                                                                             
                        major1=res.getString("name");
                        comboBox1.addItem(major1);
                        comboBox2.addItem(major1);
                        comboBox3.addItem(major1);
                        comboBox4.addItem(major1);
                    }
                }
                
                if(num == 5)
                {
                    JLabel jl2 = new JLabel("专业一：");
                    jl2.setFont(new Font("黑体",  2,  23));
                    jl2.setBounds(300,125,100,50);
                    c.add(jl2);
        
                    JLabel jl3 = new JLabel("专业二：");
                    jl3.setFont(new Font("黑体",  2,  23));
                    jl3.setBounds(300,175,100,50);
                    c.add(jl3);
        
                    JLabel jl4 = new JLabel("专业三：");
                    jl4.setFont(new Font("黑体",  2,  23));
                    jl4.setBounds(300,225,250,50);
                    c.add(jl4);
        
                    JLabel jl5 = new JLabel("专业四：");
                    jl5.setFont(new Font("黑体",  2,  23));
                    jl5.setBounds(300,275,250,50);
                    c.add(jl5);
        
                    JLabel jl6 = new JLabel("专业五：");
                    jl6.setFont(new Font("黑体",  2,  23));
                    jl6.setBounds(300,325,250,50);
                    c.add(jl6);
                    
                     comboBox1.addItem("请选择");
                    comboBox1.setBounds(400, 125, 280, 50);
                    comboBox1.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox1);
                    
                    comboBox2.addItem("请选择");
                    comboBox2.setBounds(400, 175, 280, 50);
                    comboBox2.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox2);
                    
                    comboBox3.addItem("请选择");
                    comboBox3.setBounds(400, 225, 280, 50);
                    comboBox3.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox3);
                    
                    comboBox4.addItem("请选择");
                    comboBox4.setBounds(400, 275, 280, 50);
                    comboBox4.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox4);
                    
                    comboBox5.addItem("请选择");
                    comboBox5.setBounds(400, 325, 280, 50);
                    comboBox5.setFont(new Font("黑体",  2,  23));
                    c.add(comboBox5);
                    
                    sql=con.prepareStatement("select * from school.profession ");   //连接数据库读取里面有的科目                                
                    res=sql.executeQuery(); 
                    String major1;                    
                    while(res.next())
                    {                                                                             
                        major1=res.getString("name");
                        comboBox1.addItem(major1);
                        comboBox2.addItem(major1);
                        comboBox3.addItem(major1);
                        comboBox4.addItem(major1);
                        comboBox5.addItem(major1);
                    }
                }
                
        }
        catch(Exception e2)
        {             
            e2.printStackTrace();
        }                
        
        
        
       
        jb1.setBounds(200, 400, 143, 47); 
        jb1.setContentAreaFilled(false); //设置按钮透明
        jb1 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        c.add(jb1);
        jb1.addMouseListener(new MouseListener() {    //确定按钮功能
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
            choosemajor();           
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        
        
        
        jb2.setBounds(550, 400, 143, 47); 
        jb2.setContentAreaFilled(false); //设置按钮透明
        jb2 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起
        jb2.addMouseListener(new MouseListener() {    //关闭按钮功能
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb2.setBorder(BorderFactory.createLoweredBevelBorder());  
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发   
            jf.dispose();
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb2);        
    }
    
    
    
    public void choosemajor()
    {
            
            
            
            int i1=0;
            int i2=0;
            int i3=0;
            int i4=0;
            int i5=0;
            i1=comboBox1.getSelectedIndex();   //接收选择的选项id
            i2=comboBox2.getSelectedIndex();
            i3=comboBox3.getSelectedIndex();
            i4=comboBox4.getSelectedIndex();
            i5=comboBox5.getSelectedIndex();
            
            if(num==1)  //当有一个专业时，将选择的专业导回学生表
            {
                if(i1!=1)//保证每一个专业都选了,1是这些选项刚好选择都不同时的ID的和
                {
                    JOptionPane about =new JOptionPane();
                    about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                }
                else
                {
                    Connect con1 = new Connect();
                    con=con1.getConnection();
                
                
                    StudentPage.s1.choose1=(String) comboBox1.getSelectedItem();  //获取从选项中选择的专业
                    
                    try
                    {          
                        sql=con.prepareStatement("update school.student set choose1 = ?  where xuehao like ?");
                        sql.setString(1, StudentPage.s1.choose1);
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                    
                        sql=con.prepareStatement("update school.student set choose2 = ?  where xuehao like ?");
                        sql.setString(1, "");
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                    
                        sql=con.prepareStatement("update school.student set choose3 = ?  where xuehao like ?");
                        sql.setString(1, "");
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                    
                        sql=con.prepareStatement("update school.student set choose4 = ?  where xuehao like ?");
                        sql.setString(1, "");
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                    
                        sql=con.prepareStatement("update school.student set choose5 = ?  where xuehao like ?");
                        sql.setString(1, "");
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                    }    
                    catch(Exception e1)
                    {
                        e1.printStackTrace();
                    }
                    jf.dispose();
                }
            }   
            
            
            if(num==2)  //当有两个专业时，将选择的专业导回学生表
            {
                if( i1!=0 && i2!=0 )//避免有未选择
                {
                    if((i1+i2)!=3)//保证每一个专业都选了,3是这些选项刚好选择都不同时的ID的和
                    {
                        JOptionPane about =new JOptionPane();
                        about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                    }
                    else
                    {
                        Connect con1 = new Connect();
                        con=con1.getConnection();
                
                
                        StudentPage.s1.choose1=(String) comboBox1.getSelectedItem();
                        StudentPage.s1.choose2=(String) comboBox2.getSelectedItem();
                    
                    try
                    {          
                        sql=con.prepareStatement("update school.student set choose1 = ?  where xuehao like ?");
                        sql.setString(1, StudentPage.s1.choose1);
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                    
                        sql=con.prepareStatement("update school.student set choose2 = ?  where xuehao like ?");
                        sql.setString(1, StudentPage.s1.choose2);
                        sql.setString(2, HomePage2.input1);
                        sql.executeUpdate();
                        
                        sql=con.prepareStatement("update school.student set choose3 = ?  where xuehao like ?");
                    sql.setString(1, "");
                    sql.setString(2, HomePage2.input1);
                    sql.executeUpdate();
                    
                    sql=con.prepareStatement("update school.student set choose4 = ?  where xuehao like ?");
                    sql.setString(1, "");
                    sql.setString(2, HomePage2.input1);
                    sql.executeUpdate();
                    
                    sql=con.prepareStatement("update school.student set choose5 = ?  where xuehao like ?");
                    sql.setString(1, "");
                    sql.setString(2, HomePage2.input1);
                    sql.executeUpdate();
                    
                    
                    }    
                    catch(Exception e1)
                    {   
                        e1.printStackTrace();
                    }
                    jf.dispose();
                    }
                }
                else
                {
                    JOptionPane about =new JOptionPane();
                    about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示 
                }
            }
            
            if(num==3)  //当有三个专业时，将选择的专业导回学生表
            {
                if( (i1!=0 && i2!=0 && i3!=0) && ( (i1!=i2)&&(i1!=i3)&&(i2!=i3) ) )//避免有未选择,并且选择上的不能相同
                {
                    if((i1+i2+i3)!=6)//保证每一个专业都选了,6是这些选项刚好选择都不同时的ID的和
                    {
                        JOptionPane about =new JOptionPane();
                        about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                    }
                    else
                    {
                        Connect con1 = new Connect();
                        con=con1.getConnection();
                
                
                        StudentPage.s1.choose1=(String) comboBox1.getSelectedItem();
                        StudentPage.s1.choose2=(String) comboBox2.getSelectedItem();
                        StudentPage.s1.choose3=(String) comboBox3.getSelectedItem();                    
                        try
                        {          
                            sql=con.prepareStatement("update school.student set choose1 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose1);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose2 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose2);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose3 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose3);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose4 = ?  where xuehao like ?");
                            sql.setString(1, "");
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose5 = ?  where xuehao like ?");
                            sql.setString(1, "");
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();                                      
                        }    
                        catch(Exception e1)
                        {
                            e1.printStackTrace();
                        }
                        jf.dispose();
                    }
                }
                else
                {
                    JOptionPane about =new JOptionPane();
                    about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示  
                }
            }   
            
            if(num==4)  //当有4个专业时，将选择的专业导回学生表
            {
                if((i1!=0 && i2!=0 && i3!=0 && i4!=0) && ( (i1!=i2)&&(i1!=i3)&&(i1!=i4)&&(i2!=i3)&&(i2!=i4)&&(i3!=i4)  ))//保证都选了，且选的不一样
                {
                    if((i1+i2+i3+i4)!=10)//保证每一个专业都选了,10是这些选项刚好选择都不同时的ID的和
                    {
                        JOptionPane about =new JOptionPane();
                        about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                    }
                    else
                    {
                        Connect con1 = new Connect();
                        con=con1.getConnection();
                
                
                        StudentPage.s1.choose1=(String) comboBox1.getSelectedItem();
                        StudentPage.s1.choose2=(String) comboBox2.getSelectedItem();
                        StudentPage.s1.choose3=(String) comboBox3.getSelectedItem();
                        StudentPage.s1.choose4=(String) comboBox4.getSelectedItem();
                    
                        try
                        {          
                            sql=con.prepareStatement("update school.student set choose1 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose1);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose2 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose2);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose3 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose3);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose4 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose4);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose5 = ?  where xuehao like ?");
                            sql.setString(1, "");
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();                                       
                        }    
                        catch(Exception e1)
                        {
                            e1.printStackTrace();
                        }
                        jf.dispose();
                    }
                }
                else
                {
                    JOptionPane about =new JOptionPane();
                    about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                }
            }   
            
            
            
            if(num==5)  //当有五个专业时，将选择的专业导回学生表
            {
                if((i1!=0 && i2!=0 && i3!=0 && i4!=0 && i5!=0) &&((i1!=i2)&&(i1!=i3)&&(i1!=i4)&&(i1!=i5)&&(i2!=i3)&&(i2!=i4)&&(i2!=i5)&&(i3!=i4)&&(i3!=i5)&&(i4!=i5)  )  )//保证都选了，且选的不一样
                {
                    if((i1+i2+i3+i4+i5)!=15)//保证每一个专业都选了,15是这些选项刚好选择都不同时的ID的和
                    {
                        JOptionPane about =new JOptionPane();
                        about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                    }
                    else
                    {
                        Connect con1 = new Connect();
                        con=con1.getConnection();
                
                
                        StudentPage.s1.choose1=(String) comboBox1.getSelectedItem();
                        StudentPage.s1.choose2=(String) comboBox2.getSelectedItem();
                        StudentPage.s1.choose3=(String) comboBox3.getSelectedItem();
                        StudentPage.s1.choose4=(String) comboBox4.getSelectedItem();
                        StudentPage.s1.choose5=(String) comboBox5.getSelectedItem();
                        try
                        {          
                            sql=con.prepareStatement("update school.student set choose1 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose1);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose2 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose2);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose3 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose3);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose4 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose4);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                    
                            sql=con.prepareStatement("update school.student set choose5 = ?  where xuehao like ?");
                            sql.setString(1, StudentPage.s1.choose5);
                            sql.setString(2, HomePage2.input1);
                            sql.executeUpdate();
                        }    
                        catch(Exception e1)
                        {
                            e1.printStackTrace();
                        }
                        jf.dispose();
                    }
                }
                else
                {
                    JOptionPane about =new JOptionPane();
                    about.showMessageDialog(null, "请选择正确的专业");//弹出对话空提示   
                }
            }
    }
    
    
}
