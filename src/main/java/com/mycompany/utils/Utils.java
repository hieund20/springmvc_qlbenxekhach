/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.mycompany.pojo.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HIEU
 */
public class Utils {
    
    public static int countCart(Map<Integer, Cart> cart) {
        int quantity = 0;

        if (cart != null) {
            for (Cart c : cart.values()) {
                quantity += c.getQuantitySeat();
            }
        }

        return quantity;
    }
    
    public static Map<String, String> cartStats(Map<Integer, Cart> cart) {
        Long s = 0l;
        
        if (cart != null) {
            for (Cart c : cart.values()) {       
                s += c.getRoutePrice();
            }
        }
        
        Map<String, String> kq = new HashMap<>();
        kq.put("amount", String.valueOf(s));
        
        return kq;
    }
    
}
