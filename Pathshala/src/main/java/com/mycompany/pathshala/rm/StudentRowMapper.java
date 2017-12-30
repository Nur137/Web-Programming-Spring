/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.rm;

import com.mycompany.pathshala.domain.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nur137
 */
public class StudentRowMapper implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student=new Student();
        student.setCourse_id(rs.getInt("course_id"));
        student.setStudent_name(rs.getString("student_name"));
        return student;
    }
    
}
