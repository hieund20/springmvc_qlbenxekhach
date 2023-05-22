/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Cart;
import com.mycompany.repository.OrderRepository;
import com.mycompany.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HIEU
 */
@Service
public class OrderServiceIml implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addReceipt(Map<Integer, Cart> cart) {
        if (cart != null) {
            return this.orderRepository.addReceipt(cart);
        }
        return false;
    }

}
