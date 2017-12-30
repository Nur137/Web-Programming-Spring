/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.daoImpl;

import com.mycompany.pathshala.dao.BaseDAO;
import com.mycompany.pathshala.dao.ClassDao;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.ClassRoom;
import com.mycompany.pathshala.domain.User;
import com.mycompany.pathshala.rm.ClassRowMapper;
import com.mycompany.pathshala.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDaoImpl extends BaseDAO implements ClassDao{

    @Override
    public void save(ClassRoom classRoom) {
        String query  = "INSERT INTO classroom(course_name,course_no,instructor)"
               +"VALUES(:course_name, :course_no, :instructor)";
       
       Map m = new HashMap();
       m.put("course_name", classRoom.getCourse_name());
       m.put("course_no", classRoom.getCourse_no());
       m.put("instructor", classRoom.getInstructor());
       
       
       KeyHolder kh = new GeneratedKeyHolder();
       SqlParameterSource ps = new MapSqlParameterSource(m);
       getNamedParameterJdbcTemplate().update(query,ps,kh);
       Integer classId = kh.getKey().intValue();
       classRoom.setId(classId);
    }
    
    @Override
    public List<ClassRoom> findByProperty(String propName, Object propValue){
         String query = "SELECT id,course_no,course_name,instructor"
                + " FROM classroom WHERE "+propName+"=?";
         return getJdbcTemplate().query(query, new ClassRowMapper(),propValue);
    }
    
    @Override
    public ClassRoom findById(int id) {
         String query = "SELECT "
                + "             id "
                + "             ,course_no "
                + "              ,course_name "
                + "             ,instructor "
                + " FROM "
                + "             classroom "
                + " WHERE "
                + "             id=:id";
        Map m = new HashMap();
        m.put("id", id);
        return getNamedParameterJdbcTemplate().queryForObject(query, m, new ClassRowMapper());
    }
    
    @Override
    public List<ClassRoom> findAll() {
         String sql = "SELECT id,course_no,course_name,instructor"
                + " FROM classroom";
           /*
           List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
           return users;
           */
           return getJdbcTemplate().query(sql, new ClassRowMapper());
         
    }
}
