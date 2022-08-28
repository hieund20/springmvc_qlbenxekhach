/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Route;
import com.mycompany.repository.RouteRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class RouteRepositoryImpl implements RouteRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Route> getRoutes() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Route");
        
        return q.getResultList();
    }
    
    @Override
    public Route getRouteById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Route.class, id);
    }

    @Override
    public List<Route> getRoutesByGarageId(int garageId, String fromKw, String toKw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root root = q.from(Route.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("garageId"), garageId);
        predicates.add(p);

        if (!"".equals(fromKw) && !fromKw.isEmpty()){
            predicates.add(b.like(root.get("departure"), String.format("%%%s%%", fromKw)));
        }
        
        if (!"".equals(toKw) && !toKw.isEmpty()){
            predicates.add(b.like(root.get("destination"), String.format("%%%s%%", toKw)));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));
        q.orderBy(b.desc(root.get("id")));

        org.hibernate.query.Query query = s.createQuery(q);
                
        return query.getResultList();
    }

    @Override
    public void addRoute(Route route) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(route);
    }
}
