/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.dao;

import com.mycompany.pathshala.domain.ClassRoom;
import com.mycompany.pathshala.domain.User;
import java.util.List;

/**
 *
 * @author Nur137
 */
public interface ClassDao {
    public void save(ClassRoom classRoom);
     public List<ClassRoom> findByProperty(String propName, Object propValue);
     public List<ClassRoom> findAll();
     public ClassRoom findById(int id);
     
}
