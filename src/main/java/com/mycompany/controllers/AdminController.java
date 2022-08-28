/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.Garage;
import com.mycompany.service.GarageService;
import com.mycompany.service.StatService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HIEU
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatService statService;
    
    @Autowired
    private GarageService garageService;
    
    @Autowired
    private Cloudinary cloudinary;
    
    //Quản trị
    @GetMapping("/garage-admin")
    public String garageAdmin(Model model) {
        model.addAttribute("garageList", this.garageService.getGarages());
        return "garage-admin";
    }
    
    @GetMapping("/garage-admin-add")
    public String garageAdminAdd(Model model) {

        model.addAttribute("garage", new Garage());
        return "garage-admin-add";
    }

    @PostMapping("/garage-admin-add")
    public String garageAdminAdd(@ModelAttribute(value = "garage") Garage garage) {

        String garageName = garage.getName();
        Boolean garageIsActive = garage.getIsActive();
        String thumbnail = "";

        try {
            Map r = this.cloudinary.uploader().upload(garage.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            thumbnail = (String) r.get("secure_url");
            
        } catch (IOException ex) {
            System.err.println("Add garage image have error: " + ex.getMessage());
        }

        if (garageName.isEmpty()) {
            System.out.println("Garage name is not Empty");
            return null;
        }

        Garage newGarage = new Garage();
        newGarage.setName(garageName);
        newGarage.setIsActive(garageIsActive);
        newGarage.setThumbnail(thumbnail);

        this.garageService.addGarage(newGarage);
        
        return "garage-admin-add";
    }
    
    @GetMapping("/garage-admin-confirm")
    public String garageAdminConfirm(Model model) {
        model.addAttribute("garageList", this.garageService.getGarages());
        return "garage-admin-confirm";
    }
    

    //Thống kê
    @GetMapping("/garage-stat")
    public String garageStats(Model model) {
        model.addAttribute("garageStat", this.statService.garageStats());
        return "garage-stat";
    }

    @GetMapping("/route-stat")
    public String routeStats(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String kw = params.getOrDefault("kw", null);

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

        model.addAttribute("routeStat",
                this.statService.routeStats(kw, fromDate, toDate));
        return "route-stat";
    }
    
    @GetMapping("/route-month-stat")
    public String routeMonthStats(Model model) {
        model.addAttribute("routeMonthStat",
                this.statService.routeMonthStats(null, null, null));
        return "route-month-stat";
    }
    
    @GetMapping("/route-year-stat")
    public String routeYearStats(Model model) {
        model.addAttribute("routeYearStat",
                this.statService.routeYeatStats(null, null, null));
        return "route-year-stat";
    }
    
    @GetMapping("/route-quarter-stat")
    public String routeQuarterStats(Model model) {
//        model.addAttribute("routeYearStat",
//                this.statService.routeYeatStats(null, null, null));
        return "route-quarter-stat";
    }
    
    
}
