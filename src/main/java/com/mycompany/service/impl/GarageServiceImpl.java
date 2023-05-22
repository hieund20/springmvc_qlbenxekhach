/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Garage;
import com.mycompany.repository.GarageRepository;
import com.mycompany.service.GarageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HIEU
 */
@Service
public class GarageServiceImpl implements GarageService{
    @Autowired
    private GarageRepository garageRepository;
    
    @Override
    public List<Garage> getGarages() {
        return this.garageRepository.getGarages();
    }

    @Override
    public Garage getGarageById(int id) {
        return this.garageRepository.getGarageById(id);
    }

    @Override
    public Garage editGarage(int id, Garage garage) {
        return this.garageRepository.editGarage(id, garage);
    }

    @Override
    public Garage addGarage(Garage garage) {
        return this.garageRepository.addGarage(garage);
    }

    @Override
    public Garage confirmGarage(int id, Garage garage) {
        return this.garageRepository.confirmGarage(id, garage);
    }
    
}
