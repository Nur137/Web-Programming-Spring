/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.test;

import com.mycompany.pathshala.configure.SpringRootConfig;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Asif Ahmed
 */
public class TestUserDAOFindByProperty {
    
    public static void main(String[]args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        List<User> users = userDAO.findByProperty("name","asif");
       
        System.out.println("--------Done-------");
        for(User u: users){
        System.out.print(u.getName());
        System.out.print(u.getEmail());
        System.out.print(u.getPassword());
        }

        
    }
}
