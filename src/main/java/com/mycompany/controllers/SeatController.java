/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.repository.SeatRepository;
import com.mycompany.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HIEU
 */
@Controller
public class SeatController {
    @Autowired
    private RouteService routeService;
    
    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/trips")
    public String detail(Model model,
            @RequestParam(required = true, value = "tripId") int tripId,
            @RequestParam(required = true, value = "routeId") int routeId) {
        model.addAttribute("seatList", this.seatRepository.getSeatsByTripId(tripId));
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        
        return "seat";
    }
}
