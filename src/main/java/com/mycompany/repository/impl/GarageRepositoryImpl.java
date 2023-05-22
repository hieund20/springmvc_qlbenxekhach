/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Garage;
import com.mycompany.repository.GarageRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class GarageRepositoryImpl implements GarageRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Garage> getGarages() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Garage");
        
        return q.getResultList();
    }

    @Override
    public Garage getGarageById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Garage.class, id);
    }

    @Override
    public Garage editGarage(int id, Garage garage) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("update Garage set isActive = :isActive where id = :id");
        
        query.setParameter("isActive", garage.getIsActive());
        query.setParameter("id", id);

        try {
            query.executeUpdate();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    @Override
    public Garage confirmGarage(int id, Garage garage) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("update Garage set isAllowed = :isAllowed where id = :id");
        
        query.setParameter("isAllowed", garage.getIsAllowed());
        query.setParameter("id", id);

        try {
            query.executeUpdate();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Garage addGarage(Garage garage) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            s.save(garage);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    
}
