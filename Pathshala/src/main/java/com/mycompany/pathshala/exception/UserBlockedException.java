/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.exception;

/**
 *
 * @author Asif Ahmed
 */
public class UserBlockedException extends Exception{
    
    /**
     * Creates User object without error description
     */

    public UserBlockedException(){
    }
    /**
     * Creates User object with error description
     * @param errDesc 
     */
    public UserBlockedException(String errDesc){
        super(errDesc);
    }
}
