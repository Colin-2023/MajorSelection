/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class SetProfessionPage extends Page{  //设置专业的类

    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    
    private JFrame jf = new JFrame("计算机大类专业分流软件");
    private JLabel pjl1 = new JLabel("专业1");
    private JLabel pjl2 = new JLabel("专业2");
    private JLabel pjl3 = new JLabel("专业3");
    private JLabel pjl4 = new JLabel("专业4");
    private JLabel pjl5 = new JLabel("专业5");
    private JLabel cjl1 = new JLabel("班级数");
    private JLabel cjl2 = new JLabel("班级数");
    private JLabel cjl3 = new JLabel("班级数");
    private JLabel cjl4 = new JLabel("班级数");
    private JLabel cjl5 = new JLabel("班级数");
    private JLabel cpjl1 = new JLabel("每班人数");
    private JLabel cpjl2 = new JLabel("每班人数");
    private JLabel cpjl3 = new JLabel("每班人数");
    private JLabel cpjl4 = new JLabel("每班人数");
    private JLabel cpjl5 = new JLabel("每班人数");
    private JCheckBox pbox1 =new JCheckBox("计算机科学与技术",false);
    private JCheckBox pbox2 =new JCheckBox("计算机科学与技术卓越工程师",false);
    private JCheckBox pbox3 =new JCheckBox("软件工程",false);
    private JCheckBox pbox4 =new JCheckBox("物联网工程",false);
    private JCheckBox pbox5 =new JCheckBox("计算机科学与技术交通信息工程",false);
    private JTextField ctf1 = new JTextField();
    private JTextField ctf2 = new JTextField();
    private JTextField ctf3 = new JTextField();
    private JTextField ctf4 = new JTextField();
    private JTextField ctf5 = new JTextField();
    private JTextField cptf1 = new JTextField();
    private JTextField cptf2 = new JTextField();
    private JTextField cptf3 = new JTextField();
    private JTextField cptf4 = new JTextField();
    private JTextField cptf5 = new JTextField();

    private JButton jb = new JButton("确定");
    @Override
    void show() {
        Container c = jf.getContentPane();//定义容器
        jf.setLocation(600,300);
       // JLabel imgLabel = new JLabel(new ImageIcon(Run.class.getResource("/pic/1.png")));  //可以打包进jar包的
        //jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        //imgLabel.setSize(900,600);   

       
        pjl1.setFont(new Font("黑体",  2,  23));
        pjl1.setBounds(50,125,70,50);
        c.add(pjl1);
        
        pjl2.setFont(new Font("黑体",  2,  23));
        pjl2.setBounds(50,180,70,50);
        c.add(pjl2);
        
        pjl3.setFont(new Font("黑体",  2,  23));
        pjl3.setBounds(50,235,70,50);
        c.add(pjl3);
        
        pjl4.setFont(new Font("黑体",  2,  23));
        pjl4.setBounds(50,290,70,50);
        c.add(pjl4);
        
        pjl5.setFont(new Font("黑体",  2,  23));
        pjl5.setBounds(50,345,70,50);
        c.add(pjl5);
        
        cjl1.setFont(new Font("黑体",  2,  23));
        cjl1.setBounds(470,125,70,50);
        c.add(cjl1);
        
        cjl2.setFont(new Font("黑体",  2,  23));
        cjl2.setBounds(470,180,70,50);
        c.add(cjl2);
        
        cjl3.setFont(new Font("黑体",  2,  23));
        cjl3.setBounds(470,235,70,50);
        c.add(cjl3);
        
        cjl4.setFont(new Font("黑体",  2,  23));
        cjl4.setBounds(470,290,70,50);
        c.add(cjl4);
        
        cjl5.setFont(new Font("黑体",  2,  23));
        cjl5.setBounds(470,345,70,50);
        c.add(cjl5);
        
        cpjl1.setFont(new Font("黑体",  2,  23));
        cpjl1.setBounds(600,125,100,50);
        c.add(cpjl1);
        
        cpjl2.setFont(new Font("黑体",  2,  23));
        cpjl2.setBounds(600,180,100,50);
        c.add(cpjl2);
        
        cpjl3.setFont(new Font("黑体",  2,  23));
        cpjl3.setBounds(600,235,100,50);
        c.add(cpjl3);
        
        cpjl4.setFont(new Font("黑体",  2,  23));
        cpjl4.setBounds(600,290,100,50);
        c.add(cpjl4);
        
        cpjl5.setFont(new Font("黑体",  2,  23));
        cpjl5.setBounds(600,345,100,50);
        c.add(cpjl5);
        
        
        pbox1.setBounds(120, 125, 350, 50);
        pbox1.setFont(new Font("黑体",  2,  23));
        c.add(pbox1);
        
        
        pbox2.setBounds(120, 180, 350, 50);
        pbox2.setFont(new Font("黑体",  2,  23));
        c.add(pbox2);
        
        
        pbox3.setBounds(120, 235, 350, 50);
        pbox3.setFont(new Font("黑体",  2,  23));
        c.add(pbox3);
        
        
        pbox4.setBounds(120, 290, 350, 50);
        pbox4.setFont(new Font("黑体",  2,  23));
        c.add(pbox4);
        
        
        
        pbox5.setBounds(120, 345, 350, 50);
        pbox5.setFont(new Font("黑体",  2,  23));
        c.add(pbox5);
        
        ctf1.setFont(new Font("黑体",  2,  23));
        ctf1.setBounds(545,125,50,50);
        c.add(ctf1);
        
        ctf2.setFont(new Font("黑体",  2,  23));
        ctf2.setBounds(545,180,50,50);
        c.add(ctf2);
        
        ctf3.setFont(new Font("黑体",  2,  23));
        ctf3.setBounds(545,235,50,50);
        c.add(ctf3);
        
        ctf4.setFont(new Font("黑体",  2,  23));
        ctf4.setBounds(545,290,50,50);
        c.add(ctf4);
        
        ctf5.setFont(new Font("黑体",  2,  23));
        ctf5.setBounds(545,345,50,50);
        c.add(ctf5);
        
        cptf1.setFont(new Font("黑体",  2,  23));
        cptf1.setBounds(700,125,50,50);
        c.add(cptf1);
        
        cptf2.setFont(new Font("黑体",  2,  23));
        cptf2.setBounds(700,180,50,50);
        c.add(cptf2);
        
        cptf3.setFont(new Font("黑体",  2,  23));
        cptf3.setBounds(700,235,50,50);
        c.add(cptf3);
        
        cptf4.setFont(new Font("黑体",  2,  23));
        cptf4.setBounds(700,290,50,50);
        c.add(cptf4);
        
        cptf5.setFont(new Font("黑体",  2,  23));
        cptf5.setBounds(700,345,50,50);
        c.add(cptf5);
        
        jb.setFont(new Font("黑体",  2,  23));
        jb.setBounds(400,450,100,50);
        jb.setContentAreaFilled(false); //设置按钮透明
        jb.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        c.add(jb);
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
            
            jb.setBorder(BorderFactory.createRaisedBevelBorder());   //将设置的专业，班级数，人数导回数据库
            deleteProDb();
            if (pbox1.isSelected()) {
                String a = pbox1.getText();
                String b = ctf1.getText();
                String c = cptf1.getText();
                ComSciPro comscipro = new  ComSciPro(getDbId()+1,a,Integer.valueOf(b),Integer.valueOf(c));
                comscipro.setdb();
            }
            if (pbox2.isSelected()) {
                String a = pbox2.getText();
                String b = ctf2.getText();
                String c = cptf2.getText();
                 ComSciRemarkPro comsciremarkpro = new  ComSciRemarkPro(getDbId()+1,a,Integer.valueOf(b),Integer.valueOf(c));
                comsciremarkpro.setdb();
            }
            if (pbox3.isSelected()) {
                String a = pbox3.getText();
                String b = ctf3.getText();
                String c = cptf3.getText();
                 ComSciTranPro comscitranpro = new  ComSciTranPro(getDbId()+1,a,Integer.valueOf(b),Integer.valueOf(c));
                comscitranpro.setdb();
            }
            if (pbox4.isSelected()) {
                String a = pbox4.getText();
                String b = ctf4.getText();
                String c = cptf4.getText();
                InternetOfThPro internetofthpro = new  InternetOfThPro(getDbId()+1,a,Integer.valueOf(b),Integer.valueOf(c));
                internetofthpro.setdb();
            }
            if (pbox5.isSelected()) {
                String a = pbox5.getText();
                String b = ctf5.getText();
                String c = cptf5.getText();
                SoftwareEngPro softwareengpro = new  SoftwareEngPro(getDbId()+1,a,Integer.valueOf(b),Integer.valueOf(c));
                softwareengpro.setdb();
            }
            

            jf.dispose();//销毁窗口
            
        }
            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        } 
        });
        
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景
        jf.setLayout(null);
        jf.setSize(900, 600);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭窗口方式，直接关闭
        jf.setVisible(true); //窗口可见
    }
    public int getDbId(){
        Connect con1 = new Connect();
        con=con1.getConnection();
        int i = 0;
        try
        {          
            sql=con.prepareStatement("select * from school.profession ");  
            res=sql.executeQuery();           
            //遍历查询结果
            if(res.next())
            {
            res.last();
            i = res.getRow();
            }
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }
    public void deleteProDb(){
        boolean flag=true;
        Connect con1 = new Connect();
        con=con1.getConnection();
        int s = 0;
        try
        {          
            sql=con.prepareStatement("delete from school.profession");  
            s=sql.executeUpdate();
            if(s==0){
                flag=false;
            }
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
