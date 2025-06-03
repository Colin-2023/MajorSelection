/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//学生工厂，根据不同的名字生产不同的学生对象
package run;
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author HP
 */
public class StudentFactory {
    static Connection con;
    static PreparedStatement sql;
    static ResultSet res;
    Student s1 = new Student();   
    public Student making(String name)
    {
        Connect con1 = new Connect();
        con=con1.getConnection();
        try
        {          
            sql=con.prepareStatement("select * from school.student where name like ?");  
            sql.setString(1,name);    //显示对应学号的学生信息
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
            }                      
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return s1;
    }
    
    
}
