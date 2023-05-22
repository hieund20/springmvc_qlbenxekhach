/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.User;
import com.mycompany.repository.UserReposisory;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HIEU
 */
@Repository
@Transactional
public class UserRepositoryIml implements UserReposisory {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public User getUserById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }
    
    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(user);    
    }
    
    @Override
    public List<User> getUsers(String username) {
        List<User> users;
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = builder.createQuery(User.class);

        Root<User> root = cr.from(User.class);

        CriteriaQuery<User> query = cr.select(root);
        query.where(builder.equal(root.get("user_name"), username));

        users = session.createQuery(query).getResultList();
        
        return users;
    }
}
