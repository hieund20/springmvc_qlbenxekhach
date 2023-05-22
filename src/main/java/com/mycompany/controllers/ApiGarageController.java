package com.mycompany.controllers;

import com.mycompany.pojo.Garage;
import com.mycompany.service.GarageService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HIEU
 */
@RestController
public class ApiGarageController {
    
    @Autowired
    private GarageService garageService;

    @PutMapping(path = "/api/put-garage/{id}")
    public ResponseEntity<Garage> editGarage(@PathVariable(value = "id") int id,
            @RequestBody Map<String, String> params) {
        try {
            Boolean isActive =  Boolean.parseBoolean(params.get("isActive"));
            
            Garage baseGarage = this.garageService.getGarageById(id);
            baseGarage.setIsActive(isActive);

            Garage garage = this.garageService.editGarage(id, baseGarage);
            return new ResponseEntity<>(garage, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping(path = "/api/confirm-garage/{id}")
    public ResponseEntity<Garage> confirmGarage(@PathVariable(value = "id") int id,
            @RequestBody Map<String, String> params) {
        try {
            Boolean isAllowed =  Boolean.parseBoolean(params.get("isAllowed"));
            
            Garage baseGarage = this.garageService.getGarageById(id);
            baseGarage.setIsAllowed(isAllowed);

            Garage garage = this.garageService.confirmGarage(id, baseGarage);
            return new ResponseEntity<>(garage, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
