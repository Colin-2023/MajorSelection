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
public class HomePage2 extends Page{
    //用于接收与数据库连接后的信息
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    public static String input1;
    public static String input2;
    public JButton jb1 = new JButton("登录");
    public JTextField jt1 = new JTextField(20);
    public JTextField jt2 = new JTextField(20);
    public JFrame jf = new JFrame("计算机大类专业分流软件");
    public static int i=0;  //用来匹配到的是老师还是学生，0代表输入的既不是老师也不是学生
    
    
   
    
    
    
    public void show()
    {
        
        jf.setLocation(500,200);
       // JLabel imgLabel = new JLabel(new ImageIcon(Run.class.getResource("/pic/1.png")));  //可以打包进jar包的
        //jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        //imgLabel.setSize(900,600);   
        Container c = jf.getContentPane();//定义容器
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景
        jf.setLayout(null);
        jf.setSize(900, 600);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口方式，直接关闭
        jf.setVisible(true); //窗口可见
        
       
        jt1.setFont(new Font("黑体",  2,  20));
        jt1.setBounds(350,180,250,35);
        c.add(jt1);
        
        
        jt2.setFont(new Font("黑体",  2,  20));
        jt2.setBounds(350,280,250,35);
        c.add(jt2);
              
        
        jb1.setBounds(250, 400, 143, 47); 
        jb1.setContentAreaFilled(false); //设置按钮透明
        jb1 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        
        jb1.addMouseListener(new MouseListener() {    //给登录按钮添加鼠标事件监听器
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发
        }
        public void mousePressed(MouseEvent e)     
        {//鼠标按键按下时被触发
            jb1.setBorder(BorderFactory.createLoweredBevelBorder());    
            examInput();//调用验证登录信息的方法
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发    
          jb1.setBorder(BorderFactory.createRaisedBevelBorder());   
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
        jb2.setBounds(500, 400, 143, 47); 
        jb2.setContentAreaFilled(false); //设置按钮透明
        jb2 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb2.addMouseListener(new MouseListener() {    //给取消按钮添加鼠标事件监听器
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
        
        JLabel jl1 = new JLabel("计算机大类专业分流软件");
        jl1.setFont(new Font("黑体",  2,  30));
        jl1.setBounds(275,45,375,50);
        c.add(jl1);
        
        JLabel jl2 = new JLabel("职工号/学号：");
        jl2.setFont(new Font("黑体",  2,  20));
        jl2.setBounds(225,150,200,100);
        c.add(jl2);
        
        JLabel jl3 = new JLabel("      密码：");
        jl3.setFont(new Font("黑体",  2,  20));
        jl3.setBounds(225,250,200,100);
        c.add(jl3);                               
    }
    
    public void examInput()   //验证登录信息的方法
    {
            i=0;
            jb1.setBorder(BorderFactory.createRaisedBevelBorder()); 
            input1=jt1.getText();
            input2=jt2.getText();
            
            Connect con1 = new Connect();
            con=con1.getConnection(); //       
            
            try
            {             
                sql=con.prepareStatement("select * from school.student where xuehao like ?");   //检验输入的学号/密码是否正确                
                sql.setString(1, input1);
                res=sql.executeQuery(); 
                String xuehao;
                String code;                                               
                while(res.next())
                {                        
                    xuehao = res.getString("xuehao");
                    code = res.getString("code");                                     
                    if(input2.equals(code))
                    {//如果密码正确
                        jf.dispose();//销毁窗口
                        StudentPage studentpage = new StudentPage();
                        studentpage.show();
                       
                        i=1; //匹配成功，则将i置为1
                        break;
                    }                   
                }                                     
                //下面再检查一遍老师的表
               sql=con.prepareStatement("select * from school.teacher where zhigonghao like ?");   //检验输入的学号/密码是否正确                
                sql.setString(1, input1);
                res=sql.executeQuery(); 
                String zhigonghao;
                String taeachercode;                                               
                while(res.next())
                {                        
                    zhigonghao = res.getString("zhigonghao");
                     taeachercode = res.getString("code");                                     
                    if(input2.equals( taeachercode))
                    {//如果密码正确
                        jf.dispose();//销毁窗口
                        TeacherPage teacherPage = new TeacherPage();
                        teacherPage.show();
                        i=2; //匹配成功，则将i置为2
                        break;
                    }                   
                } 
            }    
            catch(Exception e2)
            {
              ;
                e2.printStackTrace();
            }
            if(i==0)  //当i等于0时，证明学号和密码不匹配
            {
                jt1.setText("");//将输入清空
                jt2.setText("");
                JOptionPane about =new JOptionPane();
                about.showMessageDialog(null, "学号/职工号输入错误，请重新输入");//弹出对话空提示   
            }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        HomePage2 homepage2 = new HomePage2();
        homepage2.show();
    }
}
