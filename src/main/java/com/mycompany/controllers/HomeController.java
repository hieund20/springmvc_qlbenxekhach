/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.service.GarageService;
import com.mycompany.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HIEU
 */
@Controller
public class HomeController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private GarageService garageService;
    
    @RequestMapping("/")
    public String index(Model model) {   
        model.addAttribute("routeList", this.routeService.getRoutes());
        model.addAttribute("garageList", this.garageService.getGarages());
        return "index";
    }
   
}
