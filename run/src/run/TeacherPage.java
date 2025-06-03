/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 *
 * @author DELL
 */
public class TeacherPage extends Page {  //老师界面的类
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;

    public JButton jb1 = new JButton("进入专业设置");
    public static JFrame jf = new JFrame("计算机大类专业分流软件");
    Container c = jf.getContentPane();//定义容器
    public static JLabel jl7 = new JLabel();
    public static JLabel jl8 = new JLabel();
    public static JLabel jl9 = new JLabel();
    public static JLabel jl10 = new JLabel();
    
    public static Teacher t1 = new Teacher(); //建立老师对象
    @Override
    public void show() {
        jf.setLocation(500,200);
       // JLabel imgLabel = new JLabel(new ImageIcon(Run.class.getResource("/pic/1.png")));  //可以打包进jar包的
        //jf.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE)); //以图片为背景的语法
        //imgLabel.setSize(900,600);   
        
        ((JPanel)c).setOpaque(false);//将控件显示为透明，漏出背景

         JLabel jl1 = new JLabel("欢迎登陆计算机专业分流系统");
        jl1.setFont(new Font("华文行楷",  2,  30));
        jl1.setBounds(0,20,425,50);
        c.add(jl1);
        
        JLabel jl2 = new JLabel("姓名：");
        jl2.setFont(new Font("黑体",  2,  23));
        jl2.setBounds(320,125,100,50);
        c.add(jl2);
        
        JLabel jl3 = new JLabel("职工号：");
        jl3.setFont(new Font("黑体",  2,  23));
        jl3.setBounds(320,175,100,50);
        c.add(jl3);
        
        JLabel jl4 = new JLabel("学院：信息学院");
        jl4.setFont(new Font("黑体",  2,  23));
        jl4.setBounds(320,225,250,50);
        c.add(jl4);
        

        
        JButton jb1 = new JButton("修改密码");
        jb1.setBounds(200, 400, 143, 47); 
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
        
        JButton jb2 = new JButton("设置专业");
        jb2.setBounds(550, 400, 143, 47); 
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
            SetProfessionPage setpro = new SetProfessionPage();
            setpro.show();
        }            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb2);
        
        JButton jb3 = new JButton("专业分流");//专业分流按钮//需要编写
        jb3.setBounds(550, 500, 143, 47); 
        jb3.setContentAreaFilled(false); //设置按钮透明
        jb3 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb3.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb3.addMouseListener(new MouseListener() {    
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb3.setBorder(BorderFactory.createLoweredBevelBorder());
            
            
        }
        public void mouseReleased(MouseEvent e) 
        {
                int type = JOptionPane.PLAIN_MESSAGE;
                String  message = "专业分流成功";
                String  title="成功";
                JOptionPane.showMessageDialog(null,message, title, type);
            //鼠标按键被释放时被触发   
            //一是学生人数从数据库获取，有多少学生创建多少学生对象
            //二是专业数在设置专业时勾选，哪个专业被勾选则哪个专业会出现在数据库profession表中，其他没有被勾选的专业则不能被读出
            //三是每个专业设置的班数也应该从数据库profession表中读取
            //综上，对每个班分学生采取的是：序号/专业班级数，取余；这种方法在给班级分学生的时候不用判断班的人数满没满，只需判断这个专业人满没满，专业人未满则能合理分配；
            jb3.setBorder(BorderFactory.createRaisedBevelBorder()); 
            Connect con11 = new Connect();
            Connection con1 =con11.getConnection();
           try
          {      
            Statement sta = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql1="select * from school.student"; 
            ResultSet res1=sta.executeQuery(sql1); 
            //首先获取学生的数量
            int numstudent=0;
            while(res1.next())
            {
                numstudent++;
            }//遍历一遍，每次加1
            //jl7.setText(String.valueOf(numstudent));
            Statement sta1 = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql2="select * from school.student"; 
            ResultSet res2=sta.executeQuery(sql2); 
            Student stu[]=new Student[numstudent];//创建student类的对象数组，有count个学生
            for (int i = 0; i < stu.length; i++)
            {
                stu[i] = new Student();
            }
            int i=0;
            while(res2.next())
            {
                stu[i].name=res2.getString("name");
                stu[i].xuehao=res2.getString("xuehao");
                stu[i].code=res2.getString("code");
                stu[i].time=res2.getString("time");
                stu[i].major=res2.getString("major");
                stu[i].choose1=res2.getString("choose1");
                stu[i].choose2=res2.getString("choose2");
                stu[i].choose3=res2.getString("choose3");
                stu[i].choose4=res2.getString("choose4");
                stu[i].choose5=res2.getString("choose5");
                stu[i].class0=res2.getString("class");
                stu[i].jidian=res2.getString("jidian");
                i++;
            }//将学生表中的所有学生信息放到对象数组中，如果只有三个专业开放,那么choose4，choose5为空    
            for (int k=0;k<stu.length-1;k++)//对学生数组按照绩点进行排序
            { 
                Student stu1=new Student();
                for(int j=0;j<stu.length-k-1;j++)
                {
                    if(Double.valueOf(stu[j].jidian) < Double.valueOf(stu[j+1].jidian))
                    {
                        stu1.name=stu[j].name;
                        stu1.xuehao=stu[j].xuehao;
                        stu1.code=stu[j].code;
                        stu1.time=stu[j].time;
                        stu1.major=stu[j].major;
                        stu1.choose1=stu[j].choose1;
                        stu1.choose2=stu[j].choose2;
                        stu1.choose3=stu[j].choose3;
                        stu1.choose4=stu[j].choose4;
                        stu1.choose5=stu[j].choose5;
                        stu1.class0=stu[j].class0;
                        stu1.jidian=stu[j].jidian;
                       
                        stu[j].name=stu[j+1].name;
                        stu[j].xuehao=stu[j+1].xuehao;
                        stu[j].code=stu[j+1].code;
                        stu[j].time=stu[j+1].time;
                        stu[j].major=stu[j+1].major;
                        stu[j].choose1=stu[j+1].choose1;
                        stu[j].choose2=stu[j+1].choose2;
                        stu[j].choose3=stu[j+1].choose3;
                        stu[j].choose4=stu[j+1].choose4;
                        stu[j].choose5=stu[j+1].choose5;
                        stu[j].class0=stu[j+1].class0;
                        stu[j].jidian=stu[j+1].jidian;
                  
                        stu[j+1].name=stu1.name;
                        stu[j+1].xuehao=stu1.xuehao;
                        stu[j+1].code=stu1.code;
                        stu[j+1].time=stu1.time;
                        stu[j+1].major=stu1.major;
                        stu[j+1].choose1=stu1.choose1;
                        stu[j+1].choose2=stu1.choose2;
                        stu[j+1].choose3=stu1.choose3;
                        stu[j+1].choose4=stu1.choose4;
                        stu[j+1].choose5=stu1.choose5;
                        stu[j+1].class0=stu1.class0;
                        stu[j+1].jidian=stu1.jidian;
                    }
                }
            }
            //jl7.setText(stu[0].jidian);
            Statement sta2 = con1.createStatement();
            String sql3="select * from school.profession"; 
            ResultSet res3=sta2.executeQuery(sql3); 
            //获取专业数
            int numprofession=0;
            while(res3.next())
            {
                numprofession++;
            }
            Profession pro[]=new Profession[5];//创建5个Profession类的对象数组
            for (int j = 0; j < pro.length; j++)//初始化5个专业对象为id,空，0，0
            {
                pro[j] = new Profession();
            }
            for (int j = 0; j < pro.length; j++)//初始化5个专业对象为id,空，0，0
            {
                //pro[j] = new Profession();
                pro[j].id=(j+1);
                pro[j].name=" ";
                pro[j].classnum=0;
                pro[j].perclassnum=0;
            }
            int n=0;
            //1为计科，2为计卓，3为软工，4为物联网，5为计交
            Statement sta3 = con1.createStatement();
            String sql4="select * from school.profession"; 
            ResultSet res4=sta3.executeQuery(sql4);
            while(res4.next())//读取数据表中有的专业行
            {
                if("计算机科学与技术".equals(res4.getString("name")))
                {
                    pro[0].name=res4.getString("name");
                    pro[0].classnum=res4.getInt("classnum");
                    pro[0].perclassnum=res4.getInt("perclassnum");
                }
                else
                {
                    if("计算机科学与技术卓越工程师".equals(res4.getString("name")))
                    {
                        pro[1].name=res4.getString("name");
                        pro[1].classnum=res4.getInt("classnum");
                        pro[1].perclassnum=res4.getInt("perclassnum");
                    }
                    else
                    {
                        if("软件工程".equals(res4.getString("name")))
                        {
                            pro[2].name=res4.getString("name");
                            pro[2].classnum=res4.getInt("classnum");
                            pro[2].perclassnum=res4.getInt("perclassnum");
                        }
                        else
                        {
                            if("物联网工程".equals(res4.getString("name")))
                            {
                                pro[3].name=res4.getString("name");
                                pro[3].classnum=res4.getInt("classnum");
                                pro[3].perclassnum=res4.getInt("perclassnum");
                            }
                            else
                            {
                                 if("计算机科学与技术交通信息工程".equals(res4.getString("name")))
                                {
                                    pro[4].name=res4.getString("name");
                                    pro[4].classnum=res4.getInt("classnum");
                                    pro[4].perclassnum=res4.getInt("perclassnum");
                                }
                            }
                        }
                    }
                }
                n++;
            }//将专业表中的对应专业信息放到对应的对象数组中 
            //jl7.setText(pro[3].name);
            //以上，得到学生人数numstudent，开放的专业数numprofession，降序排序的学生对象数组（若只有三个专业，学生的choose4，choose5=0）
            //专业对象数组（恒定大小为5个对象。放开的专业即数据表中有的，对应的数组不为空；数据表中没有的，专业对象为空，班级数和人数为0）
            int count1=0,count11=(pro[0].classnum * pro[0].perclassnum);//用来记录计科专业的现有人数和最大人数
            int count2=0,count22=(pro[1].classnum * pro[1].perclassnum);//用来记录计卓专业的现有人数和最大人数
            int count3=0,count33=(pro[2].classnum * pro[2].perclassnum);//用来记录软工专业的现有人数和最大人数
            int count4=0,count44=(pro[3].classnum * pro[3].perclassnum);//用来记录物联网专业的现有人数和最大人数
            int count5=0,count55=(pro[4].classnum * pro[4].perclassnum);//用来记录计交专业的现有人数和最大人数
            int numclass=0;
            for(int j=0;j<5;j++)
            {
                numclass+=pro[j].classnum;
            }
            int classnumber[]=new int[numclass];//根据设置的班级数创建对应的班级数组，用来记录每个班的现有人数
            for(int k=0;k<numclass;k++)//一共有numclass个班，用classnumber数组来记录每个班的人数
            {
                 classnumber[k]=0;
            }
            
                for (Student stu1 : stu) //numstudent个学生
                {
                    if ("计算机科学与技术".equals(stu1.choose1) & count1<count11) {
                        stu1.major = "计算机科学与技术"; //设置学生的专业为计科
                        int num;
                        do //随机分配班级号
                        {
                            num=(int)(Math.random()*pro[0].classnum+1);//随机产生1-pro[0].classnum的随机数，作为班号
                            stu1.class0 = String.valueOf(num);
                            classnumber[num-1]++;
                        } while (classnumber[num-1]>pro[0].perclassnum);
                        count1++;
                    } else {
                        if ("计算机科学与技术卓越工程师".equals(stu1.choose1) & count2<count22) {
                            stu1.major = "计算机科学与技术卓越工程师";
                            int num;
                            do //随机分配班级号
                            {
                                num=(int)(Math.random()*pro[1].classnum+pro[0].classnum+1);//随机产生pro[0].classnum-pro[1].classnum的随机数，作为班号
                                stu1.class0 = String.valueOf(num);
                                classnumber[num-1]++;
                            } while (classnumber[num-1]>pro[1].perclassnum);
                            count2++;
                        } else {
                            if ("软件工程".equals(stu1.choose1) & count3<count33) {
                                stu1.major = "软件工程";
                                int num;
                                do //随机分配班级号
                                {
                                    num=(int)(Math.random()*pro[2].classnum+pro[0].classnum+pro[1].classnum+1);//随机产生pro[0].classnum+pro[1].classnum-pro[2].classnum的随机数，作为班号
                                    stu1.class0 = String.valueOf(num);
                                    classnumber[num-1]++;
                                } while (classnumber[num-1]>pro[2].perclassnum);
                                count3++;
                            } else {
                                if ("物联网工程".equals(stu1.choose1) & count4<count44) {
                                    stu1.major = "物联网工程";
                                    int num;
                                    do //随机分配班级号
                                    {
                                        num=(int)(Math.random()*pro[3].classnum+pro[0].classnum+pro[1].classnum+pro[2].classnum+1);//随机产生pro[0].classnum+pro[1].classnum+pro[2].classnum-pro[3].classnum的随机数，作为班号
                                        stu1.class0 = String.valueOf(num);
                                        classnumber[num-1]++;
                                    } while (classnumber[num-1]>pro[3].perclassnum);
                                    count4++;
                                } else {
                                    if ("计算机科学与技术交通信息工程".equals(stu1.choose1) & count5<count55) {
                                        stu1.major = "计算机科学与技术交通信息工程";
                                        int num;
                                        do //随机分配班级号
                                        {
                                            num=(int)(Math.random()*pro[4].classnum+pro[0].classnum+pro[1].classnum+pro[2].classnum+pro[3].classnum+1);//随机产生(pro[0].classnum+pro[1].classnum+pro[2].classnum+pro[3].classnum)-pro[4].classnum的随机数，作为班号
                                            stu1.class0 = String.valueOf(num);
                                            classnumber[num-1]++;
                                        } while (classnumber[num-1]>pro[4].perclassnum);
                                        count5++;
                                    }
                                }
                            }
                        }
                    }
                    if ("未定".equals(stu1.major)) {
                        if ("计算机科学与技术".equals(stu1.choose2) & count1 < count11) {
                            stu1.major = "计算机科学与技术"; //设置学生的专业为计科
                            int num;
                            do //随机分配班级号
                            {
                                num = (int) (Math.random() * pro[0].classnum + 1);//随机产生1-pro[0].classnum的随机数，作为班号
                                stu1.class0 = String.valueOf(num);
                                classnumber[num - 1]++;
                            } while (classnumber[num - 1] > pro[0].perclassnum);
                            count1++;
                        } else if ("计算机科学与技术卓越工程师".equals(stu1.choose2) & count2 < count22) {
                            stu1.major = "计算机科学与技术卓越工程师";
                            int num;
                            do //随机分配班级号
                            {
                                num = (int) (Math.random() * pro[1].classnum + pro[0].classnum + 1);//随机产生pro[0].classnum-pro[1].classnum的随机数，作为班号
                                stu1.class0 = String.valueOf(num);
                                classnumber[num - 1]++;
                            } while (classnumber[num - 1] > pro[1].perclassnum);
                            count2++;
                        } else {
                            if ("软件工程".equals(stu1.choose2) & count3 < count33) {
                                stu1.major = "软件工程";
                                int num;
                                do //随机分配班级号
                                {
                                    num = (int) (Math.random() * pro[2].classnum + pro[0].classnum + pro[1].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum-pro[2].classnum的随机数，作为班号
                                    stu1.class0 = String.valueOf(num);
                                    classnumber[num - 1]++;
                                } while (classnumber[num - 1] > pro[2].perclassnum);
                                count3++;
                            } else {
                                if ("物联网工程".equals(stu1.choose2) & count4 < count44) {
                                    stu1.major = "物联网工程";
                                    int num;
                                    do //随机分配班级号
                                    {
                                        num = (int) (Math.random() * pro[3].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum+pro[2].classnum-pro[3].classnum的随机数，作为班号
                                        stu1.class0 = String.valueOf(num);
                                        classnumber[num - 1]++;
                                    } while (classnumber[num - 1] > pro[3].perclassnum);
                                    count4++;
                                } else {
                                    if ("计算机科学与技术交通信息工程".equals(stu1.choose2) & count5 < count55) {
                                        stu1.major = "计算机科学与技术交通信息工程";
                                        int num;
                                        do //随机分配班级号
                                        {
                                            num = (int) (Math.random() * pro[4].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + pro[3].classnum + 1);//随机产生(pro[0].classnum+pro[1].classnum+pro[2].classnum+pro[3].classnum)-pro[4].classnum的随机数，作为班号
                                            stu1.class0 = String.valueOf(num);
                                            classnumber[num - 1]++;
                                        } while (classnumber[num - 1] > pro[4].perclassnum);
                                        count5++;
                                    }
                                }
                            }
                        }
                    }
                    if ("未定".equals(stu1.major)) {
                        if ("计算机科学与技术".equals(stu1.choose3) & count1 < count11) {
                            stu1.major = "计算机科学与技术"; //设置学生的专业为计科
                            int num;
                            do //随机分配班级号
                            {
                                num = (int) (Math.random() * pro[0].classnum + 1);//随机产生1-pro[0].classnum的随机数，作为班号
                                stu1.class0 = String.valueOf(num);
                                classnumber[num - 1]++;
                            } while (classnumber[num - 1] > pro[0].perclassnum);
                            count1++;
                        } else {
                            if ("计算机科学与技术卓越工程师".equals(stu1.choose3) & count2 < count22) {
                                stu1.major = "计算机科学与技术卓越工程师";
                                int num;
                                do //随机分配班级号
                                {
                                    num = (int) (Math.random() * pro[1].classnum + pro[0].classnum + 1);//随机产生pro[0].classnum-pro[1].classnum的随机数，作为班号
                                    stu1.class0 = String.valueOf(num);
                                    classnumber[num - 1]++;
                                } while (classnumber[num - 1] > pro[1].perclassnum);
                                count2++;
                            } else {
                                if ("软件工程".equals(stu1.choose3) & count3 < count33) {
                                    stu1.major = "软件工程";
                                    int num;
                                    do //随机分配班级号
                                    {
                                        num = (int) (Math.random() * pro[2].classnum + pro[0].classnum + pro[1].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum-pro[2].classnum的随机数，作为班号
                                        stu1.class0 = String.valueOf(num);
                                        classnumber[num - 1]++;
                                    } while (classnumber[num - 1] > pro[2].perclassnum);
                                    count3++;
                                } else {
                                    if ("物联网工程".equals(stu1.choose3) & count4 < count44) {
                                        stu1.major = "物联网工程";
                                        int num;
                                        do //随机分配班级号
                                        {
                                            num = (int) (Math.random() * pro[3].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum+pro[2].classnum-pro[3].classnum的随机数，作为班号
                                            stu1.class0 = String.valueOf(num);
                                            classnumber[num - 1]++;
                                        } while (classnumber[num - 1] > pro[3].perclassnum);
                                        count4++;
                                    } else {
                                        if ("计算机科学与技术交通信息工程".equals(stu1.choose3) & count5 < count55) {
                                            stu1.major = "计算机科学与技术交通信息工程";
                                            int num;
                                            do //随机分配班级号
                                            {
                                                num = (int) (Math.random() * pro[4].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + pro[3].classnum + 1);//随机产生(pro[0].classnum+pro[1].classnum+pro[2].classnum+pro[3].classnum)-pro[4].classnum的随机数，作为班号
                                                stu1.class0 = String.valueOf(num);
                                                classnumber[num - 1]++;
                                            } while (classnumber[num - 1] > pro[4].perclassnum);
                                            count5++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if ("未定".equals(stu1.major)) {
                        if ("计算机科学与技术".equals(stu1.choose4) & count1 < count11) {
                            stu1.major = "计算机科学与技术"; //设置学生的专业为计科
                            int num;
                            do //随机分配班级号
                            {
                                num = (int) (Math.random() * pro[0].classnum + 1);//随机产生1-pro[0].classnum的随机数，作为班号
                                stu1.class0 = String.valueOf(num);
                                classnumber[num - 1]++;
                            } while (classnumber[num - 1] > pro[0].perclassnum);
                            count1++;
                        } else {
                            if ("计算机科学与技术卓越工程师".equals(stu1.choose4) & count2 < count22) {
                                stu1.major = "计算机科学与技术卓越工程师";
                                int num;
                                do //随机分配班级号
                                {
                                    num = (int) (Math.random() * pro[1].classnum + pro[0].classnum + 1);//随机产生pro[0].classnum-pro[1].classnum的随机数，作为班号
                                    stu1.class0 = String.valueOf(num);
                                    classnumber[num - 1]++;
                                } while (classnumber[num - 1] > pro[1].perclassnum);
                                count2++;
                            } else {
                                if ("软件工程".equals(stu1.choose4) & count3 < count33) {
                                    stu1.major = "软件工程";
                                    int num;
                                    do //随机分配班级号
                                    {
                                        num = (int) (Math.random() * pro[2].classnum + pro[0].classnum + pro[1].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum-pro[2].classnum的随机数，作为班号
                                        stu1.class0 = String.valueOf(num);
                                        classnumber[num - 1]++;
                                    } while (classnumber[num - 1] > pro[2].perclassnum);
                                    count3++;
                                } else {
                                    if ("物联网工程".equals(stu1.choose4) & count4 < count44) {
                                        stu1.major = "物联网工程";
                                        int num;
                                        do //随机分配班级号
                                        {
                                            num = (int) (Math.random() * pro[3].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum+pro[2].classnum-pro[3].classnum的随机数，作为班号
                                            stu1.class0 = String.valueOf(num);
                                            classnumber[num - 1]++;
                                        } while (classnumber[num - 1] > pro[3].perclassnum);
                                        count4++;
                                    } else {
                                        if ("计算机科学与技术交通信息工程".equals(stu1.choose4) & count5 < count55) {
                                            stu1.major = "计算机科学与技术交通信息工程";
                                            int num;
                                            do //随机分配班级号
                                            {
                                                num = (int) (Math.random() * pro[4].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + pro[3].classnum + 1);//随机产生(pro[0].classnum+pro[1].classnum+pro[2].classnum+pro[3].classnum)-pro[4].classnum的随机数，作为班号
                                                stu1.class0 = String.valueOf(num);
                                                classnumber[num - 1]++;
                                            } while (classnumber[num - 1] > pro[4].perclassnum);
                                            count5++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if ("未定".equals(stu1.major)) {
                        if ("计算机科学与技术".equals(stu1.choose5) & count1 < count11) {
                            stu1.major = "计算机科学与技术"; //设置学生的专业为计科
                            int num;
                            do //随机分配班级号
                            {
                                num = (int) (Math.random() * pro[0].classnum + 1);//随机产生1-pro[0].classnum的随机数，作为班号
                                stu1.class0 = String.valueOf(num);
                                classnumber[num - 1]++;
                            } while (classnumber[num - 1] > pro[0].perclassnum);
                            count1++;
                        } else {
                            if ("计算机科学与技术卓越工程师".equals(stu1.choose5) & count2 < count22) {
                                stu1.major = "计算机科学与技术卓越工程师";
                                int num;
                                do //随机分配班级号
                                {
                                    num = (int) (Math.random() * pro[1].classnum + pro[0].classnum + 1);//随机产生pro[0].classnum-pro[1].classnum的随机数，作为班号
                                    stu1.class0 = String.valueOf(num);
                                    classnumber[num - 1]++;
                                } while (classnumber[num - 1] > pro[1].perclassnum);
                                count2++;
                            } else {
                                if ("软件工程".equals(stu1.choose5) & count3 < count33) {
                                    stu1.major = "软件工程";
                                    int num;
                                    do //随机分配班级号
                                    {
                                        num = (int) (Math.random() * pro[2].classnum + pro[0].classnum + pro[1].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum-pro[2].classnum的随机数，作为班号
                                        stu1.class0 = String.valueOf(num);
                                        classnumber[num - 1]++;
                                    } while (classnumber[num - 1] > pro[2].perclassnum);
                                    count3++;
                                } else {
                                    if ("物联网工程".equals(stu1.choose5) & count4 < count44) {
                                        stu1.major = "物联网工程";
                                        int num;
                                        do //随机分配班级号
                                        {
                                            num = (int) (Math.random() * pro[3].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + 1);//随机产生pro[0].classnum+pro[1].classnum+pro[2].classnum-pro[3].classnum的随机数，作为班号
                                            stu1.class0 = String.valueOf(num);
                                            classnumber[num - 1]++;
                                        } while (classnumber[num - 1] > pro[3].perclassnum);
                                        count4++;
                                    } else {
                                        if ("计算机科学与技术交通信息工程".equals(stu1.choose5) & count5 < count55) {
                                            stu1.major = "计算机科学与技术交通信息工程";
                                            int num;
                                            do //随机分配班级号
                                            {
                                                num = (int) (Math.random() * pro[4].classnum + pro[0].classnum + pro[1].classnum + pro[2].classnum + pro[3].classnum + 1);//随机产生(pro[0].classnum+pro[1].classnum+pro[2].classnum+pro[3].classnum)-pro[4].classnum的随机数，作为班号
                                                stu1.class0 = String.valueOf(num);
                                                classnumber[num - 1]++;
                                            } while (classnumber[num - 1] > pro[4].perclassnum);
                                            count5++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            String str1[]=new String[stu.length];//numstudent个学生的专业
            String str2[]=new String[stu.length];//numstudent个学生的班级
            String str3[]=new String[stu.length];//numstudent个学生的姓名
            String sql11[]=new String[stu.length];
            String sql22[]=new String[stu.length];
            for(int k=0;k<stu.length;k++)
            {
                str1[k]=stu[k].major;
                str2[k]=stu[k].class0;
                str3[k]=stu[k].name;
                sql11[k]="update school.student set major=? where name=? "; 
                sql22[k]="update school.student set class=? where name=? ";
            }
            PreparedStatement ps1[]=new PreparedStatement[stu.length];//创建对应数量的PreparedStatement对象
            PreparedStatement ps2[]=new PreparedStatement[stu.length];//创建对应数量的PreparedStatement对象
            for(int k=0;k<stu.length;k++)//设置对应姓名的专业，班级
            {
                ps1[k]=con1.prepareStatement(sql11[k]);
                ps1[k].setString(1, str1[k]);
                ps1[k].setString(2, str3[k]);
                ps1[k].executeUpdate();//执行sql语句
                ps2[k]=con1.prepareStatement(sql22[k]);
                ps2[k].setString(1, str2[k]);
                ps2[k].setString(2, str3[k]);
                ps2[k].executeUpdate();//执行sql语句
            }
            /*String str1=stu[0].major;
            String str2=stu[0].class0;
            String str3=stu[0].name;
            String str4=stu[1].major;
            String str5=stu[1].class0;
            String str6=stu[1].name;
            String sql5="update school.student set major=? where name=? "; 
            PreparedStatement ps1=con1.prepareStatement(sql5);//创建PreparedStatement对象
            ps1.setString(1,str1);//为第一个问号赋值
            ps1.setString(2, str3);//为第二个问号赋值            
            int c1=ps1.executeUpdate();//执行sql语句
            String sql6="update school.student set class=? where name=? "; 
            PreparedStatement ps2=con1.prepareStatement(sql6);
            ps2.setString(1,str2);
            ps2.setString(2, str3);            
            int c2=ps2.executeUpdate();
            String sql7="update school.student set major=? where name=? "; 
            PreparedStatement ps3=con1.prepareStatement(sql7);
            ps3.setString(1,str4);
            ps3.setString(2, str6);           
            int c3=ps3.executeUpdate();
            String sql8="update school.student set class=? where name=? "; 
            PreparedStatement ps4=con1.prepareStatement(sql8);
            ps4.setString(1,str5);
            ps4.setString(2, str6);           
            int c4=ps4.executeUpdate();*/
            //jl7.setText(stu[0].class0);
          }
          catch(Exception ee)
          {
            ee.printStackTrace();
          }              
            //jf.dispose();//销毁窗口
           
        }            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb3);
        
        
        JButton jb4 = new JButton("导出成Excel");//导出成Excel按钮
        jb4.setBounds(200, 500, 143, 47); 
        jb4.setContentAreaFilled(false); //设置按钮透明
        jb4 .setFont(new  java.awt.Font("黑体",  2,  16));   //设置按钮字体
        jb4.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb4.addMouseListener(new MouseListener() {    
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb4.setBorder(BorderFactory.createLoweredBevelBorder());  
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发   
            int type = JOptionPane.PLAIN_MESSAGE;
                String  message = "导出EXCEL成功";
                String  title="成功";
                JOptionPane.showMessageDialog(null,message, title, type);
            jb4.setBorder(BorderFactory.createRaisedBevelBorder()); 
            //jf.dispose();//销毁窗口
            int i=0;
            Connect con1 = new Connect();
            con=con1.getConnection(); 
            Student s = new Student();
            List list = new ArrayList();
            
            // 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook();  
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.createSheet("学生专业分流表");  
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = sheet.createRow((int) 0);  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle style = wb.createCellStyle();  
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式 
        
            HSSFCell cell = row.createCell((short) 0);  
            cell.setCellValue("序号");  
            cell.setCellStyle(style);  
            cell = row.createCell((short) 1);  
            cell.setCellValue("姓名");  
            cell.setCellStyle(style);  
            cell = row.createCell((short) 2);  
            cell.setCellValue("学号");  
            cell.setCellStyle(style);  
            cell = row.createCell((short) 3);  
            cell.setCellValue("入学时间");  
            cell.setCellStyle(style); 
            cell = row.createCell((short) 4);  
            cell.setCellValue("专业");  
            cell.setCellStyle(style);  
            cell = row.createCell((short) 5);  
            cell.setCellValue("班级");  
            cell.setCellStyle(style);
            cell = row.createCell((short) 6);  
            cell.setCellValue("绩点");  
            cell.setCellStyle(style);  
        
        
        
            try
            {               
                sql=con.prepareStatement("select * from school.student ");   //检验输入的学号/密码是否正确                                
                res=sql.executeQuery();   
                
                while(res.next())
                {                        
                    s.name = res.getString("name");
                    s.xuehao = res.getString("xuehao");
                    s.time = res.getString("time");
                    s.major = res.getString("major");
                    s.class0= res.getString("class");  
                    s.jidian=res.getString("jidian");
                    
                    //list.add(s); 
                    
                        row = sheet.createRow((int) i + 1);              
                        // 第四步，创建单元格，并设置值 
                        row.createCell((short) 0).setCellValue(i+1);
                        row.createCell((short) 1).setCellValue(s.name);  
                        row.createCell((short) 2).setCellValue(s.xuehao);  
                        row.createCell((short) 3).setCellValue(s.time); 
                        row.createCell((short) 4).setCellValue(s.major);  
                        row.createCell((short) 5).setCellValue(s.class0);  
                        row.createCell((short) 6).setCellValue(s.jidian); 
                        i++;                                
                }                                 
            }    
            catch(Exception e2)
            {              
                e2.printStackTrace();
            }
            
            try  
            {  
                FileOutputStream fout = new FileOutputStream("D:/计算机专业分流学生表.xls");  
                wb.write(fout);  
                fout.close();  
            }  
            catch (Exception e3)  
            {  
                e3.printStackTrace();  
            }             
        }            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb4);
        
        JButton jb5 = new JButton("查询");//查询按钮
        jb5.setBounds(200, 600, 143, 47); 
        jb5.setContentAreaFilled(false); //设置按钮透明
        jb5 .setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb5.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起 
        jb5.addMouseListener(new MouseListener() {    
        public void mouseEntered(MouseEvent e) 
        {//移入组件时被触发          
        }
        public void mousePressed(MouseEvent e) 
        {//鼠标按键按下时被触发
            jb5.setBorder(BorderFactory.createLoweredBevelBorder());  
        }
        public void mouseReleased(MouseEvent e) 
        {//鼠标按键被释放时被触发   
            jb5.setBorder(BorderFactory.createRaisedBevelBorder()); 
            //jf.dispose();//销毁窗口
            SearchStudent st = new SearchStudent();
            st.show();
            
           
        }            
        public void mouseClicked(MouseEvent e) 
        {//发生单击事件时被触发      
        }
        public void mouseExited(MouseEvent e) 
        {//移出组件时被触发
        }  
    });
        c.add(jb5);
        
        
        getMessage();//调用获取对应登录者的信息并显示
        
        
        jf.setLayout(null);
        jf.setSize(900, 750);
        jf.setResizable(false);  //用户不能改变窗口的大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口方式，直接关闭
        //c.add(jb1);
        jf.setVisible(true); //窗口可见
    }
    

    public void getMessage() {  //获取老师详细信息
        Connect con1 = new Connect();
        con=con1.getConnection();
        try
        {          
            sql=con.prepareStatement("select * from school.teacher where zhigonghao like ?");  
            sql.setString(1, HomePage2.input1);    //显示对应职工号的学生信息
            res=sql.executeQuery();           
            //遍历查询结果
            while(res.next())
            {               
                //将数据从数据库中导出来                                              
                t1.name = res.getString("name");
                t1.zhigonghao = res.getString("zhigonghao");
                
                
                jl7.setText(t1.name);
                jl7.setFont(new Font("黑体",  2,  23));
                jl7.setBounds(390,125,100,50);
                c.add(jl7);
                
                
                jl8.setText(t1.zhigonghao);
                jl8.setFont(new Font("黑体",  2,  23));
                jl8.setBounds(400,175,150,50);
                c.add(jl8);
                
            }                      
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }   
        
    }
            
    }


