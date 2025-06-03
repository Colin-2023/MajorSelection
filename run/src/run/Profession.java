/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class Profession {//抽象的专业
    
    public void setdb(){//将专业的数据加入数据库
    boolean flag=true;
     Connection con;
     PreparedStatement sql;
     Connect con1 = new Connect();
     con=con1.getConnection();
     try
        {          
           sql=con.prepareStatement("insert into school.profession values(?,?,?,?)");  
           sql.setString(1, String.valueOf(id));  
           sql.setString(2, name);  
           sql.setString(3, String.valueOf(classnum));  
           sql.setString(4, String.valueOf(perclassnum));  
           int i=sql.executeUpdate();
            if(i==0){
                flag=false;
            }
        }    
        catch(Exception e)
        {
            e.printStackTrace();
        }
    };
    
    public int id;
    public String name;
    public int classnum;
    public int perclassnum;
    
}
