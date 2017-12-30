/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.dao;

import com.mycompany.pathshala.domain.Student;
import java.util.List;

/**
 *
 * @author Nur137
 */
public interface StudentDao {
    public void save(Student student);
    public List<Student> findByProperty(String propName, Object propValue);
}
