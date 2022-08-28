/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Seat;
import com.mycompany.repository.SeatRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class SeatRepositoryImpl implements SeatRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Seat> getSeatsByTripId(int tripId) {       
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Seat> q = b.createQuery(Seat.class);
        Root root = q.from(Seat.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("tripId"), tripId);
        
        predicates.add(p);
        q.where(predicates.toArray(new Predicate[]{}));
        q.orderBy(b.asc(root.get("id")));

        Query query = s.createQuery(q);
        
        return query.getResultList(); 
    }

    @Override
    public Seat getSeatById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Seat.class, id);
    }

}
