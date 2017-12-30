/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.test;

import com.mycompany.pathshala.configure.SpringRootConfig;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.User;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Asif Ahmed
 */
public class TestUserDAO {
    /*
    public static void main(String[]args){
       try{  
          File pdfFile = new File("C:/Users/Gord/Desktop/zzTest.pdf");
byte[] pdfData = new byte[(int) pdfFile.length()];
DataInputStream dis = new DataInputStream(new FileInputStream(pdfFile));
dis.readFully(pdfData);  // read from file into byte[] array
dis.close();

String myConnectionString =
        "jdbc:mysql://localhost:3307/mydb";
dbConnection = DriverManager.getConnection(myConnectionString, "root", "whatever");
PreparedStatement ps = dbConnection.prepareStatement(
        "INSERT INTO project (" +
                "filename, " +
                "pdf_file " +
            ") VALUES (?,?)");
ps.setString(1, "testpdf");
ps.setBytes(2, pdfData);  // byte[] array
ps.executeUpdate();
  

}catch(Exception e){ System.out.println(e);}  
}
*/
    }


