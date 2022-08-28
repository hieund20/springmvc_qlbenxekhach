/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.service.RouteService;
import com.mycompany.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author HIEU
 */
@Controller
public class RouteController {
    @Autowired
    private RouteService routeService;
    
    @Autowired
    private TripService tripService;
    
    @GetMapping("/routes/{routeId}")
    public String detail(Model model, 
            @PathVariable(value = "routeId") int routeId) {
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        model.addAttribute("tripList", this.tripService.getTripListByRouteId(routeId));
        
        return "route-detail"; 
    }
}
