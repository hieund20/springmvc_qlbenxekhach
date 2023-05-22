/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author HIEU
 */
public interface StatRepository {
    List<Object[]> garageStats();
    List<Object[]> routeStats(String kw, Date fromDate, Date toDate);
    List<Object[]> routeMonthStats(String kw, Date fromDate, Date toDate);
    List<Object[]> routeYeatStats(String kw, Date fromDate, Date toDate);
}
