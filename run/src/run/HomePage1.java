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



public class HomePage1 extends Page{

    /**
     * @param args the command line arguments
     */
    public JFrame jf = new JFrame("计算机大类专业分流软件");
    public JButton jb = new JButton("点击进入");
    
    
    
    
    
    public void show()  //显示首页窗体
    {
        
        jf.setLocation(500,200);
        JLabel imgLabel = new JLabel(new ImageIcon(HomePage1.class.getResource("/pic/1.png")));  //可以打包进jar包的
        jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        imgLabel.setSize(900,600);   
        Container c = jf.getContentPane();//定义容器
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景
        jf.setLayout(null);
        jf.setSize(900,600);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口方式，直接关闭
        jf.setVisible(true); //窗口可见
        
        
        jb.setBounds(375, 400, 160, 62);
        jb.setContentAreaFilled(false); //设置按钮透明
        jb .setFont(new  java.awt.Font("华文行楷",  2,  25));   //设置按钮字体
        jb.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb.addMouseListener(new MouseListener() {    
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb.setBorder(BorderFactory.createLoweredBevelBorder());  
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发   
            jb.setBorder(BorderFactory.createRaisedBevelBorder()); 
            jf.dispose();//销毁窗口
         
            HomePage2 homepage = new HomePage2();
            homepage.show();
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发
       
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }
   
    });
        c.add(jb);
    }
    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        HomePage1 homepage1 = new HomePage1();
//        homepage1.show();
//    }
    
}


