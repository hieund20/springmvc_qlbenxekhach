/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author HIEU
 */
public interface UserService extends UserDetailsService {

    User getUserById(int id);

    User getUserByUsername(String username);
    
    void addUser(User user);
}
