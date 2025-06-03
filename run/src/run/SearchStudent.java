/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author HP
 */
public class SearchStudent extends Page{ //老师查找单个学生分流的窗口
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public JFrame jf1 = new JFrame("计算机大类专业分流软件");//第一个窗体用来输入学生姓名
    public JFrame jf2 = new JFrame("计算机大类专业分流软件");//第二个窗体用来显示学生信息
    Container c1 = jf1.getContentPane();//定义容器
    Container c2 = jf2.getContentPane();//定义容器
    
    JTextField jtf1 = new JTextField();//输入学生姓名
    
    JLabel jl8 = new JLabel();
    JLabel jl9 = new JLabel();
    JLabel jl10 = new JLabel();
    JLabel jl11 = new JLabel();
    JLabel jl12 = new JLabel();
    Student s1 ; //建立学生对象
    public void show()
    {
        //设置查询窗体
        jf1.setLocation(500,200);
       // JLabel imgLabel = new JLabel(new ImageIcon(Run.class.getResource("/pic/1.png")));  //可以打包进jar包的
        //jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        //imgLabel.setSize(900,600);   
        
        ((JPanel)c1).setOpaque(false);//将控件显示为透明，漏出背景
        jf1.setLayout(null);
        jf1.setSize(550, 400);
        jf1.setResizable(false);  //用户不能改变窗口的大小
        jf1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//关闭窗口方式，直接关闭
        jf1.setVisible(true); //窗口可见
       
        
        JLabel jl1 = new JLabel("请输入需要查看的学生姓名");
        jl1.setFont(new Font("华文行楷",  2,  30));
        jl1.setBounds(100,20,425,50);
        c1.add(jl1);
        
        
        jtf1.setFont(new Font("黑体",  2,  23));
        jtf1.setBounds(150,125,200,50);
        c1.add(jtf1);
        
        JButton jb1 = new JButton("确定");
        jb1.setBounds(175, 250, 143, 47); 
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
            if(getMessageRow()==0)
            {
                int type = JOptionPane.ERROR_MESSAGE;
                String  message = "查询失败没有该学生！";
                String  title="失败";
                JOptionPane.showMessageDialog(null,message, title, type);
            }
            else
            {
            
            jf1.dispose();//销毁窗口
            getMessage();//获取学生信息
            jf2.setVisible(true); //窗口可见
            }
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c1.add(jb1);
        
        
        
        //显示学生信息窗体设置
        
        jf2.setLocation(500,200);
        ((JPanel)c1).setOpaque(false);//将控件显示为透明，漏出背景
        jf2.setLayout(null);
        jf2.setSize(900, 600);
        jf2.setResizable(false);  //用户不能改变窗口的大小
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口方式，直接关闭
        
        
        JLabel jl2 = new JLabel("姓名：");
        jl2.setFont(new Font("黑体",  2,  23));
        jl2.setBounds(320,125,100,50);
        c2.add(jl2);
        
        JLabel jl3 = new JLabel("学号：");
        jl3.setFont(new Font("黑体",  2,  23));
        jl3.setBounds(320,175,100,50);
        c2.add(jl3);
        
        JLabel jl4 = new JLabel("学院：信息学院");
        jl4.setFont(new Font("黑体",  2,  23));
        jl4.setBounds(320,225,250,50);
        c2.add(jl4);
        
        JLabel jl5 = new JLabel("入学时间：");
        jl5.setFont(new Font("黑体",  2,  23));
        jl5.setBounds(270,275,250,50);
        c2.add(jl5);
        
        JLabel jl6 = new JLabel("专业：");
        jl6.setFont(new Font("黑体",  2,  23));
        jl6.setBounds(310,325,250,50);
        c2.add(jl6);
        
        JLabel jl7 = new JLabel("班级：");
        jl7.setFont(new Font("黑体",  2,  23));
        jl7.setBounds(310,375,250,50);
        c2.add(jl7);
        
        JButton jb2 = new JButton("确定");
        jb2.setBounds(350, 450, 143, 47); 
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
            jf2.dispose();//销毁窗口

        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c2.add(jb2);
    }
    
    public void getMessage()  //获取学生详细信息的方法
    {
        
        
        //与数据库进行联系
        /*Connect con1 = new Connect();
        con=con1.getConnection();
        try
        {          
            sql=con.prepareStatement("select * from school.student where name like ?");  
            sql.setString(1,jtf1.getText());    //显示对应学号的学生信息
            res=sql.executeQuery();           
            //遍历查询结果
            while(res.next())
            {               
                //将数据从数据库中导出来                                              
                s1.name = res.getString("name");
                s1.student_id = res.getString("student_id");
                s1.time = res.getString("time");
                s1.major = res.getString("major");
                s1.class0= res.getString("class");                                
            }                      
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        } */
        
        s1 = new StudentFactory().making(jtf1.getText());//使用学生工厂根据不同的学生姓名生产不同的学生实例对象
        jl8.setText(s1.name);
        jl8.setFont(new Font("黑体",  2,  23));
        jl8.setBounds(390,125,100,50);
        c2.add(jl8);
                
                
        jl9.setText(s1.student_id);
        jl9.setFont(new Font("黑体",  2,  23));
        jl9.setBounds(390,175,150,50);
        c2.add(jl9);
                
                
        jl10.setText(s1.time);
        jl10.setFont(new Font("黑体",  2,  23));
        jl10.setBounds(390,275,250,50);
        c2.add(jl10);
                
                
        jl11.setText(s1.major);
        jl11.setFont(new Font("黑体",  2,  23));
        jl11.setBounds(390,325,250,50);
        c2.add(jl11);
                
        jl12.setText(s1.class0);
        jl12.setFont(new Font("黑体",  2,  23));
        jl12.setBounds(390,375,250,50);
        c2.add(jl12);
        
        
    }
    public int getMessageRow()  //获取学生是否存在方法
    {
        int i=0;
        Connect con1 = new Connect();
        con=con1.getConnection();
        try
        {          
            sql=con.prepareStatement("select * from school.student where name like ?");  
            sql.setString(1,jtf1.getText());    //显示对应学号的学生信息
            res=sql.executeQuery();       
            res.last();
            i=res.getRow();
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }
    
}
