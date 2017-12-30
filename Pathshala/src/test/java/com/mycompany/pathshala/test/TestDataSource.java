/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.test;

import com.mycompany.pathshala.configure.SpringRootConfig;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Asif Ahmed
 */
public class TestDataSource {
    public static void main(String[]args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
       // DataSource ds = ctx.getBean(DataSource.class);
       DataSource ds  = ctx.getBean(DataSource.class);
       JdbcTemplate jt = new JdbcTemplate(ds);
        
       String sql = "INSERT INTO user(name,phone,email,address,loginName,password) VALUES (?, ?, ?,?,?,?)";
               
        Object[]param = new Object[]{"Asif","01455","gmail.com","45-rid","asif2k13","asifcs"};
        jt.update(sql,param);
        System.out.println("---Success SQL---");
    }
}
