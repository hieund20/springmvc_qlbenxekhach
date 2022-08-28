/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import java.util.List;
import com.mycompany.pojo.Route;


/**
 *
 * @author HIEU
 */
public interface RouteService {
    List<Route> getRoutes();
    List<Route> getRoutesByGarageId(int id);
    Route getRouteById(int id);
    void addRoute(Route route);
}
