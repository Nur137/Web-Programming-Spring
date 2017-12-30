/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asif Ahmed
 */
@Controller
public class TestController {
    @RequestMapping("/test/hello")  
    public String helloWorld(){
        return "hello"; // -> /WEB-INF/view/hello.jsp
    }
     @RequestMapping("/test/ajax_test")  
    public String testPage(){
        return "test"; // -> /WEB-INF/view/hello.jsp
    }
    
}
