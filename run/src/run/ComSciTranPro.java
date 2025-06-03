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
public class ComSciTranPro extends Profession{//计算机科学与技术交通信息工程专业
    ComSciTranPro(int id,String name,int classnum,int perclassnum){
    this.id = id;
    this.name = name;
    this.classnum = classnum;
    this.perclassnum = perclassnum;
    }
}
