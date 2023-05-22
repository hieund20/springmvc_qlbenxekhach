/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Route;
import com.mycompany.service.RouteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.RouteRepository;


/**
 *
 * @author HIEU
 */
@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getRoutes() {
        return this.routeRepository.getRoutes();
    }

    @Override
    public Route getRouteById(int id) {
        return this.routeRepository.getRouteById(id);
    }

    @Override
    public List<Route> getRoutesByGarageId(int id, String fromKw, String toKw) {
        return this.routeRepository.getRoutesByGarageId(id, fromKw, toKw);
    }

    @Override
    public void addRoute(Route route) {
        this.routeRepository.addRoute(route);
    }
    
}
