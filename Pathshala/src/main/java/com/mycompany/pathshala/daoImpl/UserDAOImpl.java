/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.daoImpl;

import com.mycompany.pathshala.dao.BaseDAO;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.User;
import com.mycompany.pathshala.rm.UserRowMapper;
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
 * @author Asif Ahmed
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

    @Override
    public void save(User user) {
       String query  = "INSERT INTO user(name,phone,email,address,loginName,password,role,loginStatus)"
               +"VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
       Map m = new HashMap();
       m.put("name", user.getName());
       m.put("phone",user.getPhone());
       m.put("email", user.getEmail());
       m.put("address", user.getAddress());
       m.put("loginName",user.getLoginName());
       m.put("password",user.getPassword());
       m.put("role",user.getRole());
       m.put("loginStatus",user.getLoginStatus());
       
       KeyHolder kh = new GeneratedKeyHolder();
       SqlParameterSource ps = new MapSqlParameterSource(m);
       getNamedParameterJdbcTemplate().update(query,ps,kh);
       Integer userId = kh.getKey().intValue();
       user.setUserId(userId);
       
       
    }

    @Override
    public void update(User user) {
       String query  ="UPDATE user SET name=:name, phone=:phone, email=:email,address=:address,role=:role,loginStatus=:loginStatus WHERE userId=:userId";
       Map m = new HashMap();
       m.put("name", user.getName());
       m.put("phone",user.getPhone());
       m.put("email", user.getEmail());
       m.put("address", user.getAddress());
       m.put("role",user.getRole());
       m.put("loginStatus",user.getLoginStatus());
       m.put("userId",user.getUserId());
       getNamedParameterJdbcTemplate().update(query, m);
    }

    @Override
    public void delete(User user) {
        this.delete(user.getUserId());
    }

    @Override
    public void delete(Integer userId) {
        String query = "DELETE FROM user WHERE userId=:userId";
        Map m =  new HashMap();
        m.put("userId",userId);
        getNamedParameterJdbcTemplate().update(query, m);
    }
    
    @Override
    public User findById(Integer userId) {
       String query = "SELECT "
                + "             userId "
                + "             ,name "
                + "              ,phone "
                + "             ,email "
                + "             ,address "
                + "             ,loginName "
                + "             ,password "
                + "             ,role "
                + "             ,loginStatus "
                + " FROM "
                + "             user "
                + " WHERE "
                + "             userId=:userId";
        Map m = new HashMap();
        m.put("userId", userId);
        return getNamedParameterJdbcTemplate().queryForObject(query, m, new UserRowMapper());
    }
    
    @Override
    public User findByName(String name) {
         String query = "SELECT "
                + "             userId "
                + "             ,name "
                + "              ,phone "
                + "             ,email "
                + "             ,address "
                + "             ,loginName "
                + "             ,password "
                + "             ,role "
                + "             ,loginStatus "
                + " FROM "
                + "             user "
                + " WHERE "
                + "             loginName=:loginName";
        Map m = new HashMap();
        m.put("loginName", name);
        return getNamedParameterJdbcTemplate().queryForObject(query, m, new UserRowMapper());
    }


    @Override
    public List<User> findAll() {
         String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user";
           /*
           List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
           return users;
           */
           return getJdbcTemplate().query(sql, new UserRowMapper());
         
    }

    @Override
    public List<User> findByProperty(String propName, Object propValue) {
         String query = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE "+propName+"=?";
         return getJdbcTemplate().query(query, new UserRowMapper(),propValue);
         
    }
 }
