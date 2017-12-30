/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.rm;

import com.mycompany.pathshala.domain.ClassRoom;
import com.mycompany.pathshala.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nur137
 */
public class ClassRowMapper implements RowMapper<ClassRoom>{

    @Override
    public ClassRoom mapRow(ResultSet rs, int i) throws SQLException {
        ClassRoom classRoom =new ClassRoom();
        classRoom.setCourse_name(rs.getString("course_name"));
        classRoom.setCourse_no(rs.getString("course_no"));
        classRoom.setId(rs.getInt("id"));
        classRoom.setInstructor(rs.getString("instructor"));
        return classRoom;
    }
}
