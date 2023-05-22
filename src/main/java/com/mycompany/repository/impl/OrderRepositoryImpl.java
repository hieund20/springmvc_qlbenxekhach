/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojo.Cart;
import com.mycompany.pojo.OrderDetail;
import com.mycompany.pojo.SaleOrder;
import com.mycompany.repository.OrderRepository;
import com.mycompany.repository.UserReposisory;
import com.mycompany.repository.RouteRepository;
import com.mycompany.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HIEU
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository{
    @Autowired
    private UserReposisory userReposisory;
    
    @Autowired
    private RouteRepository routeRepository;
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            SaleOrder order = new SaleOrder();
            order.setUserId(this.userReposisory.getUserById(1));
            order.setCreated_date(new Date());

            Map<String, String> stats = Utils.cartStats(cart);
            order.setAmount(Long.parseLong(stats.get("amount")));

            session.save(order);

            for (Cart c : cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setOrderId(order);
                d.setRouteId(this.routeRepository.getRouteById(c.getRouteId()));
                d.setUnitPrice(c.getRoutePrice());
                d.setNum(c.getQuantitySeat());

                session.save(d);
            }
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

}
