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
public class ModifyCodePage extends Page {  //修改密码的页面类
    //用于接收与数据库连接后的信息
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public JFrame jf = new JFrame("计算机大类专业分流软件");
    public JTextField jt1 = new JTextField(20);
    public JTextField jt2 = new JTextField(20);
    
    public void show()
    {
        
        jf.setLocation(700,350);       
        Container c = jf.getContentPane();//定义容器
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景
        jf.setLayout(null);
        jf.setSize(500, 300);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭窗口方式，直接关闭
        jf.setVisible(true); //窗口可见
        
        JLabel jl1 = new JLabel("新密码：");               
        jl1.setFont(new Font("黑体",  2,  23));
        jl1.setBounds(90,25,100,50);
        c.add(jl1);
        
        JLabel jl2 = new JLabel("请再次输入：");               
        jl2.setFont(new Font("黑体",  2,  23));
        jl2.setBounds(40,125,150,50);
        c.add(jl2);
        
        
        jt1.setFont(new Font("黑体",  2,  20));
        jt1.setBounds(190,32,250,35);
        c.add(jt1);
        
       
        jt2.setFont(new Font("黑体",  2,  20));
        jt2.setBounds(190,132,250,35);
        c.add(jt2);
        
        JButton jb1 = new JButton("确定");
        jb1.setBounds(75, 200, 143, 47); 
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
            modifyCode(HomePage2.i);    //调用修改密码的方法           
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb1);
        
        JButton jb2 = new JButton("取消");
        jb2.setBounds(280, 200, 143, 47); 
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
            jf.dispose();//销毁窗口           
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
    
    public void modifyCode(int i)  //修改密码的方法
    {
        if(i==1)
        {
            String input1 = jt1.getText();   //判断输入的两次密码是否一样
            String input2 = jt2.getText();
            if(input1.equals(input2))
            {
                JOptionPane about =new JOptionPane();
                about.showMessageDialog(null, "你已成功修改密码，请重新登录！");//弹出对话空提示
                jf.dispose(); //退出当前窗口
                
                StudentPage.jf.dispose();   
                HomePage2 homepage2 =new HomePage2(); //进入登录界面
                homepage2.show();
                
                //连接数据库，将修改的密码存入
                String code;
                StudentPage.s1.code = jt1.getText();
                Connect con1 = new Connect();
                con=con1.getConnection();
                try
                {          
                    sql=con.prepareStatement("update school.student set code = ?  where student_id like ?");
                    sql.setString(1, StudentPage.s1.code);
                    sql.setString(2, HomePage2.input1);
                    sql.executeUpdate();
                }    
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }          
            }
            else
            {
                jt1.setText("");//将输入清空
                jt2.setText("");
                JOptionPane about =new JOptionPane();
                about.showMessageDialog(null, "两次密码不一致，请重新输入");//弹出对话空提示   
            }
        }
        else
        {
            String input1 = jt1.getText();   //判断输入的两次密码是否一样
            String input2 = jt2.getText();
            if(input1.equals(input2))
            {
                JOptionPane about =new JOptionPane();
                about.showMessageDialog(null, "你已成功修改密码，请重新登录！");//弹出对话空提示
                jf.dispose(); //退出当前窗口
                
                TeacherPage.jf.dispose();   
                HomePage2 homepage2 =new HomePage2(); //进入登录界面
                homepage2.show();
                
                //连接数据库，将修改的密码存入
                String code;
                TeacherPage.t1.code = jt1.getText();
                Connect con1 = new Connect();
                con=con1.getConnection();
                try
                {          
                    sql=con.prepareStatement("update school.teacher set code = ?  where teacher_id like ?");
                    sql.setString(1, TeacherPage.t1.code);
                    sql.setString(2, HomePage2.input1);
                    sql.executeUpdate();
                }    
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }          
            }
            else
            {
                jt1.setText("");//将输入清空
                jt2.setText("");
                JOptionPane about =new JOptionPane();
                about.showMessageDialog(null, "两次密码不一致，请重新输入");//弹出对话空提示   
            }
        }
    }
    
}
