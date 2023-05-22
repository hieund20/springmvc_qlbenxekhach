/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Trip;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HIEU
 */
public interface TripRepository {
    List<Trip> getTripListByRouteId(int routeId, Date from, Date to);
    void addTrip (Trip trip);
}
