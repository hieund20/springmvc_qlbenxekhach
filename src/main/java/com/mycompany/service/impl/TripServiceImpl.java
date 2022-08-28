/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Trip;
import com.mycompany.service.TripService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.repository.TripRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author HIEU
 */
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> getTripListByRouteId(int routeId) {
        return this.tripRepository.getTripListByRouteId(routeId);
    }

    @Override
    public void addTrip(Trip trip) {
        this.tripRepository.addTrip(trip);
    }

}
