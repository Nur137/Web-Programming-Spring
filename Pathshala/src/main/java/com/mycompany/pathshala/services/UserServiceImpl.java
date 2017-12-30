/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.services;

import com.mycompany.pathshala.dao.BaseDAO;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.User;
import com.mycompany.pathshala.exception.UserBlockedException;
import com.mycompany.pathshala.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asif Ahmed
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService{

    @Autowired
     private UserDAO userDAO;
    @Override
    public void register(User user) {
        userDAO.save(user);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName"
                + " FROM user WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
            } else {
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
       return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        String query="UPDATE user SET loginStatus=:lst WHERE userId=:uid";
        Map m = new HashMap();
        m.put("uid",userId);
        m.put("lst",loginStatus);
        getNamedParameterJdbcTemplate().update(query, m);
    }   
    

    @Override
    public Boolean isUsernameExist(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
