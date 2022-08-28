/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import java.util.List;
import com.mycompany.pojo.Trip;

/**
 *
 * @author HIEU
 */
public interface TripService {
    List<Trip> getTripListByRouteId(int routeId);
    void addTrip(Trip trip);
}
