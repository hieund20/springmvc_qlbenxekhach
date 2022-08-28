/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.pojo.Cart;
import com.mycompany.service.OrderService;
import com.mycompany.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HIEU
 */
@RestController
public class ApiCartController {
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/api/cart")
    public int addtoCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new HashMap<>();
        }
        
        int routeId = params.getRouteId();
        int seatId = params.getSeatId();
        if (cart.containsKey(routeId) == true) { //da co san pham tron gio
            Cart c = cart.get(seatId);
            c.setQuantitySeat(c.getQuantitySeat() + 1);
        } else { //san pham chua co trong gio
            cart.put(seatId, params);
        }
        
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);
    }

    @DeleteMapping("/api/cart/{seatId}")
    public int deleteCartItem(@PathVariable(value = "seatId") int seatId, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        
        if (cart != null && cart.containsKey(seatId)) {
            cart.remove(seatId);
            session.setAttribute("cart", cart);
        }
        
        return Utils.countCart(cart);
    }
    
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session) {
        if (this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart")) == true) {
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
