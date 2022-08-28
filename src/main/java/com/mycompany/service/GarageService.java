/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import java.util.List;
import com.mycompany.pojo.Garage;

/**
 *
 * @author HIEU
 */
public interface GarageService {
    List<Garage> getGarages();   
    Garage getGarageById(int id);
    Garage editGarage(int id, Garage garage);
    Garage addGarage(Garage garage);
    Garage confirmGarage(int id, Garage garage);
}
