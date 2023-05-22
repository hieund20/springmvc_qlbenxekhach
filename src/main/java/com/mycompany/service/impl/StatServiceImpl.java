/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.repository.StatRepository;
import com.mycompany.service.StatService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HIEU
 */
@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatRepository statRepository;

    @Override
    public List<Object[]> garageStats() {
        return this.statRepository.garageStats();
    }

    @Override
    public List<Object[]> routeStats(String kw, Date fromDate, Date toDate) {
        return this.statRepository.routeStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> routeMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statRepository.routeMonthStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> routeYeatStats(String kw, Date fromDate, Date toDate) {
        return this.statRepository.routeYeatStats(kw, fromDate, toDate);
    }

}
