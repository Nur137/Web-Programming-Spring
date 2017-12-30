/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.dao;

import com.mycompany.pathshala.domain.User;
import java.util.List;

/**
 *
 * @author Asif Ahmed
 */
public interface UserDAO {
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public void delete(Integer userId);
    public User findById(Integer userId);
    public User findByName(String name);
    public List<User> findAll();
    public List<User> findByProperty(String propName, Object propValue);
}
