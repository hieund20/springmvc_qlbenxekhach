/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.pojo.User;
import com.mycompany.service.GarageService;
import com.mycompany.service.RouteService;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
public class GarageController {
    @Autowired
    private GarageService garageService;
    
    @Autowired
    private RouteService routeService;

    @GetMapping("/garages/{garageId}")
    public String routeList(Model model,
            @PathVariable(value = "garageId") int garageId, 
            @RequestParam(required = false) Map<String, String> params,
            HttpSession session) {
        model.addAttribute("garage", this.garageService.getGarageById(garageId));
        
        String fromKw = params.getOrDefault("fromKw", "");
        String toKw = params.getOrDefault("toKw", "");
        
        model.addAttribute("routeList", this.routeService.getRoutesByGarageId(garageId, fromKw, toKw));
        
        User u = (User) session.getAttribute("currentUser");        
        model.addAttribute("currentUser", u);

        return "route-list";
    }
}
