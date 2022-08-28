/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Garage;
import java.util.List;

/**
 *
 * @author HIEU
 */
public interface GarageRepository {
    List<Garage> getGarages(); 
    Garage getGarageById(int id);
    Garage editGarage(int id, Garage garage);
    Garage addGarage(Garage garage);
    Garage confirmGarage(int id, Garage garage);
}
