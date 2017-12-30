/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.test;

import com.mycompany.pathshala.configure.SpringRootConfig;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Asif Ahmed
 */
public class TestUserDAOUpdate {
    
    public static void main(String[]args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        
        User u = new User();
        u.setUserId(2);
        u.setName("fahim ahmed");
        u.setPhone("0254656");
        u.setEmail("adf@gmail.com");
        u.setAddress("Mumbai, MS");
        u.setRole(1);
        u.setLoginStatus(1);
        
        userDAO.update(u);
        System.out.println("--------Done-------");
    }
}
