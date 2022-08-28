/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.pojo.User;
import com.mycompany.service.GarageService;
import com.mycompany.service.RouteService;
import javax.servlet.http.HttpSession;
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
public class GarageController {
    @Autowired
    private GarageService garageService;
    
    @Autowired
    private RouteService routeService;

    @GetMapping("/garages/{garageId}")
    public String routeList(Model model,
            @PathVariable(value = "garageId") int garageId, 
            HttpSession session) {
        model.addAttribute("garage", this.garageService.getGarageById(garageId));
        model.addAttribute("routeList", this.routeService.getRoutesByGarageId(garageId));
        
        User u = (User) session.getAttribute("currentUser");        
        model.addAttribute("currentUser", u);

        return "route-list";
    }
}
