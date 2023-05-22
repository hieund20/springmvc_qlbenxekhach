/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Trip;
import com.mycompany.repository.TripRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class TripRepositoryImpl implements TripRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Trip> getTripListByRouteId(int routeId, Date from, Date to) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Trip> q = b.createQuery(Trip.class);
        Root root = q.from(Trip.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("routeId"), routeId);
        predicates.add(p);
        
        if (from != null) {
            predicates.add(b.greaterThanOrEqualTo(root.get("departure_date"), from));
        }
        
        if (to != null) {
            predicates.add(b.lessThanOrEqualTo(root.get("departure_date"), to));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));
        q.orderBy(b.desc(root.get("id")), b.desc(root.get("start_time")));

        Query query = s.createQuery(q);
                
        return query.getResultList();
    }

    @Override
    public void addTrip(Trip trip) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(trip);
    }
    
}
