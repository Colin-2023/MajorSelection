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
//用于连接数据库
public class Connect {    //连接数据库的工厂类，每当连接数据库时，就会创建一个Connection对象，符合简单工厂模式
    
    static Connection con0;
    
    public Connection getConnection() //连接数据库
    {
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            System.out.println("数据库驱动加载成功");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        }
        //用于加载数据库驱动程序
        
        try
        {
            con0=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?&useSSL=false&serverTimezone=UTC", "root", "colin2024");
            System.out.println("数据库连接成功");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        //用于连接数据库，建立连接数据库的Connection对象,每次访问都需要建立一个对象          
        return con0;
    }
    
}
