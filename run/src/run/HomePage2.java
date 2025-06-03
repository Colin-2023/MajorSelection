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
    public JButton jbRegister = new JButton("注册");  // 新增注册按钮
    public JTextField jt1 = new JTextField(20);
    public JTextField jt2 = new JTextField(20);
    public JFrame jf = new JFrame("计算机大类专业分流软件");
    public static int i=0;  //用来匹配到的是老师还是学生，0代表输入的既不是老师也不是学生

    public void show()
    {
        jf.setLocation(500,200);
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

        // 登录按钮
        jb1.setBounds(200, 400, 120, 47);
        jb1.setContentAreaFilled(false); //设置按钮透明
        jb1.setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起
        jb1.addMouseListener(new MouseListener() {    //给登录按钮添加鼠标事件监听器
            public void mouseEntered(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                jb1.setBorder(BorderFactory.createLoweredBevelBorder());
                examInput(); //调用验证登录信息的方法
            }
            public void mouseReleased(MouseEvent e) {
                jb1.setBorder(BorderFactory.createRaisedBevelBorder());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        c.add(jb1);

        // 注册按钮
        jbRegister.setBounds(360, 400, 120, 47);
        jbRegister.setContentAreaFilled(false);
        jbRegister.setFont(new java.awt.Font("黑体",  2,  25));
        jbRegister.setBorder(BorderFactory.createRaisedBevelBorder());
        jbRegister.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                jbRegister.setBorder(BorderFactory.createLoweredBevelBorder());
                registerUser(); //注册逻辑
            }
            public void mouseReleased(MouseEvent e) {
                jbRegister.setBorder(BorderFactory.createRaisedBevelBorder());
            }
            public void mouseClicked(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        c.add(jbRegister);

        // 取消按钮
        JButton jb2 = new JButton("取消");
        jb2.setBounds(520, 400, 120, 47);
        jb2.setContentAreaFilled(false); //设置按钮透明
        jb2.setFont(new  java.awt.Font("黑体",  2,  25));   //设置按钮字体
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());  //设置按钮凸起
        jb2.addMouseListener(new MouseListener() {    //给取消按钮添加鼠标事件监听器
            public void mouseEntered(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                jb2.setBorder(BorderFactory.createLoweredBevelBorder());
            }
            public void mouseReleased(MouseEvent e) {
                jb2.setBorder(BorderFactory.createRaisedBevelBorder());
                jf.dispose();//销毁窗口
            }
            public void mouseClicked(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
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
        input1=jt1.getText().trim();
        input2=jt2.getText().trim();

        if(input1.isEmpty() || input2.isEmpty()){
            JOptionPane.showMessageDialog(null, "请输入账号和密码");
            return;
        }

        Connect con1 = new Connect();
        con=con1.getConnection(); //
        try
        {
            sql=con.prepareStatement("select * from school.student where student_id = ?");   //检验输入的学号/密码是否正确
            sql.setString(1, input1);
            res=sql.executeQuery();
            String student_id;
            String code;
            while(res.next())
            {
                student_id = res.getString("student_id");
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
            sql=con.prepareStatement("select * from school.teacher where teacher_id = ?");
            sql.setString(1, input1);
            res=sql.executeQuery();
            String teacher_id;
            String taeachercode;
            while(res.next())
            {
                teacher_id = res.getString("teacher_id");
                taeachercode = res.getString("code");
                if(input2.equals(taeachercode))
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
            e2.printStackTrace();
        }
        if(i==0)  //当i等于0时，证明学号和密码不匹配
        {
            jt1.setText("");//将输入清空
            jt2.setText("");
            JOptionPane.showMessageDialog(null, "学号/职工号或密码输入错误，请重新输入");//弹出对话框提示
        }
    }

    // 注册用户的方法
    public void registerUser() {
        input1 = jt1.getText().trim();
        input2 = jt2.getText().trim();
        if(input1.isEmpty() || input2.isEmpty()){
            JOptionPane.showMessageDialog(null, "请输入要注册的账号和密码");
            return;
        }

        Connect con1 = new Connect();
        con = con1.getConnection();
        try {
            // 先检查学号/职工号是否已存在学生表
            sql = con.prepareStatement("select count(*) from school.student where student_id = ?");
            sql.setString(1, input1);
            res = sql.executeQuery();
            if(res.next() && res.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "该学号已被注册为学生，请直接登录或使用其他账号");
                return;
            }
            // 再检查是否存在老师表
            sql = con.prepareStatement("select count(*) from school.teacher where teacher_id = ?");
            sql.setString(1, input1);
            res = sql.executeQuery();
            if(res.next() && res.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "该账号已被注册为老师，请直接登录或使用其他账号");
                return;
            }
            // 插入到学生表中
            sql = con.prepareStatement("insert into school.student(student_id, code) values(?, ?)");
            sql.setString(1, input1);
            sql.setString(2, input2);
            int rows = sql.executeUpdate();
            if(rows > 0) {
                JOptionPane.showMessageDialog(null, "注册成功，请使用新账号登录");
                jt1.setText("");
                jt2.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "注册失败，请重试");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "注册时发生数据库错误");
        }
    }

    public static void main(String[] args) {
        HomePage2 homepage2 = new HomePage2();
        homepage2.show();
    }
}
