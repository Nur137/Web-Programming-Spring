/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.daoImpl;

import com.mycompany.pathshala.dao.BaseDAO;
import com.mycompany.pathshala.dao.StudentDao;
import com.mycompany.pathshala.domain.ClassRoom;
import com.mycompany.pathshala.domain.Student;
import com.mycompany.pathshala.rm.ClassRowMapper;
import com.mycompany.pathshala.rm.StudentRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nur137
 */
@Repository
public class StudentDaoImpl  extends BaseDAO implements StudentDao{

    @Override
    public void save(Student student) {
          String query  = "INSERT INTO student(course_id,student_name)"
               +"VALUES(:course_id, :student_name)";
       
       Map m = new HashMap();
       m.put("course_id", student.getCourse_id());
       m.put("student_name", student.getStudent_name());
       getNamedParameterJdbcTemplate().update(query, m);
    }

     @Override
    public List<Student> findByProperty(String propName, Object propValue){
         String query = "SELECT course_id,student_name"
                + " FROM student WHERE "+propName+"=?";
         return getJdbcTemplate().query(query, new StudentRowMapper(),propValue);
    }
}
    

