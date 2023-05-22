/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.service.RouteService;
import com.mycompany.service.TripService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
            @PathVariable(value = "routeId") int routeId,
            @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null;
        Date toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = format.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = format.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        
        model.addAttribute("tripList", this.tripService.getTripListByRouteId(routeId, fromDate, toDate));
        
        return "route-detail"; 
    }
}
