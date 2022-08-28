/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Garage;
import com.mycompany.pojo.OrderDetail;
import com.mycompany.pojo.Route;
import com.mycompany.pojo.SaleOrder;
import com.mycompany.pojo.Seat;
import com.mycompany.pojo.Trip;
import com.mycompany.repository.StatRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class StatRepositoryImpl implements StatRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> garageStats() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootG = q.from(Garage.class);
        Root rootR = q.from(Route.class);
        
        q.where(b.equal(rootR.get("garageId"), rootG.get("id")));
        
        q.multiselect(rootG.get("id"), rootG.get("name"), 
                b.count(rootR.get("id")));
        
        q.groupBy(rootG.get("id"));
        
        Query query = s.createQuery(q);
                
        return query.getResultList();    
    }

    @Override
    public List<Object[]> routeStats(String kw, Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootR = q.from(Route.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicate = new ArrayList<>();
        predicate.add(b.equal(rootR.get("id"), rootD.get("routeId")));
        predicate.add(b.equal(rootO.get("id"), rootD.get("orderId")));
        
        q.multiselect(rootR.get("id"), rootR.get("departure"), 
                rootR.get("destination"),
                b.sum(b.prod(rootD.get("unitPrice").as(Long.TYPE), rootD.get("num"))));
        
        if (kw != null && !kw.isEmpty()){
            predicate.add(b.like(rootR.get("departure"), String.format("%%%s%%", kw)));
        }
        
        if (fromDate != null) {
            predicate.add(b.greaterThanOrEqualTo(rootO.get("created_date"), fromDate));
        }
        
        if (toDate != null) {
            predicate.add(b.lessThanOrEqualTo(rootO.get("created_date"), toDate));
        }
            
        
        q.where(predicate.toArray(new Predicate[] {}));
        q.groupBy(rootR.get("id"));
        
        Query query = s.createQuery(q);
                
        return query.getResultList(); 
    }

    @Override
    public List<Object[]> routeMonthStats(String kw, Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootR = q.from(Route.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicate = new ArrayList<>();
        predicate.add(b.equal(rootR.get("id"), rootD.get("routeId")));
        predicate.add(b.equal(rootO.get("id"), rootD.get("orderId")));

        q.multiselect(b.function("MONTH", Integer.class, rootO.get("created_date")),
                b.function("YEAR", Integer.class, rootO.get("created_date")),
                rootR.get("departure"),
                rootR.get("destination"),
                b.sum(b.prod(rootD.get("unitPrice").as(Long.TYPE), rootD.get("num"))),
                b.count(rootD.get("orderId")));

        if (kw != null && !kw.isEmpty()) {
            predicate.add(b.like(rootR.get("departure"), String.format("%%%s%%", kw)));
        }

        if (fromDate != null) {
            predicate.add(b.greaterThanOrEqualTo(rootO.get("created_date"), fromDate));
        }

        if (toDate != null) {
            predicate.add(b.lessThanOrEqualTo(rootO.get("created_date"), toDate));
        }
            
        
        q.where(predicate.toArray(new Predicate[] {}));
        q.groupBy(b.function("MONTH", Integer.class, rootO.get("created_date")),
                b.function("YEAR", Integer.class, rootO.get("created_date")));
        
        Query query = s.createQuery(q);
                
        return query.getResultList(); 
    }
    
    @Override
    public List<Object[]> routeYeatStats(String kw, Date fromDate, Date toDate) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootR = q.from(Route.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicate = new ArrayList<>();
        predicate.add(b.equal(rootR.get("id"), rootD.get("routeId")));
        predicate.add(b.equal(rootO.get("id"), rootD.get("orderId")));

        q.multiselect(b.function("YEAR", Integer.class, rootO.get("created_date")),
                rootR.get("departure"),
                rootR.get("destination"),
                b.sum(b.prod(rootD.get("unitPrice").as(Long.TYPE), rootD.get("num"))),
                b.count(rootD.get("orderId")));

        if (kw != null && !kw.isEmpty()) {
            predicate.add(b.like(rootR.get("departure"), String.format("%%%s%%", kw)));
        }

        if (fromDate != null) {
            predicate.add(b.greaterThanOrEqualTo(rootO.get("created_date"), fromDate));
        }

        if (toDate != null) {
            predicate.add(b.lessThanOrEqualTo(rootO.get("created_date"), toDate));
        }
            
        
        q.where(predicate.toArray(new Predicate[] {}));
        q.groupBy(b.function("YEAR", Integer.class, rootO.get("created_date")));
        
        Query query = s.createQuery(q);
                
        return query.getResultList(); 
    }

}
