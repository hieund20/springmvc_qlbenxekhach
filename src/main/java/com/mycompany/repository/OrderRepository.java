/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Cart;
import java.util.Map;

/**
 *
 * @author HIEU
 */
public interface OrderRepository {
    boolean addReceipt(Map<Integer, Cart> cart);
}
