/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;
import com.mycompany.pojo.User;
import java.util.List;

/**
 *
 * @author HIEU
 */
public interface UserReposisory {
    User getUserById(int id);
//    User getUserByUsername(String username);
    List<User> getUsers(String username);
    void addUser(User user);
}
