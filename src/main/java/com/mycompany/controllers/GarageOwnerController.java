/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.Garage;
import com.mycompany.pojo.Route;
import com.mycompany.pojo.Trip;
import com.mycompany.service.GarageService;
import com.mycompany.service.RouteService;
import com.mycompany.service.TripService;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalTimeParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/garage-owner")
public class GarageOwnerController {

    @Autowired
    private GarageService garageService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TripService tripService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/garage-add")
    public String garageOwnerAdd(Model model) {
        model.addAttribute("garage", new Garage());
        return "garage-owner-add";
    }

    @PostMapping("/garage-add")
    public String garageOwnerAdd(@ModelAttribute(value = "garage") Garage garage) {

        String garageName = garage.getName();
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
        newGarage.setIsActive(false);
        newGarage.setThumbnail(thumbnail);

        this.garageService.addGarage(newGarage);

        return "garage-owner-add";
    }

    @GetMapping("/garage-add-route")
    public String garageOwnerAddRoute(Model model) {
        model.addAttribute("route", new Route());
        return "garage-add-route";
    }

    @PostMapping("/garage-add-route")
    public String garageOwnerAddRoute(@ModelAttribute(value = "route") Route route) {

        String departure = route.getDeparture();
        String destination = route.getDestination();
        Long price = route.getPrice();

        String thumbnail = "";

        try {
            Map r = this.cloudinary.uploader().upload(route.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            thumbnail = (String) r.get("secure_url");

        } catch (IOException ex) {
            System.err.println("Add garage image have error: " + ex.getMessage());
        }

        Garage currentGarage = this.garageService.getGarageById(2);

        Route newRoute = new Route();
        newRoute.setDeparture(departure);
        newRoute.setDestination(destination);
        newRoute.setPrice(price);
        newRoute.setThumbnail(thumbnail);
        newRoute.setGarageId(currentGarage);

        this.routeService.addRoute(newRoute);

        return "garage-add-route";
    }

    @GetMapping("/garage-add-trip")
    public String garageOwnerAddTrip(@RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

        Date departure_date = null;
        LocalTime start_time = null;
        
        try {
            String departure_date_str = params.getOrDefault("departure_date", null);
            if (departure_date_str != null) {
                departure_date = format.parse(departure_date_str);
            }
            String start_time_str = params.getOrDefault("start_time", null);
            if (start_time_str != null) {
                start_time = LocalTime.parse(start_time_str, formatter);
            }
        } catch (ParseException ex) {
            System.err.println("Error when parse: " + ex);
        }

        Route currentRoute = this.routeService.getRouteById(2);

        Trip newTrip = new Trip();
        newTrip.setDeparture_date(departure_date);
        newTrip.setStart_time(start_time);
        newTrip.setRouteId(currentRoute);

        this.tripService.addTrip(newTrip);

        return "garage-add-trip";
    }
}
