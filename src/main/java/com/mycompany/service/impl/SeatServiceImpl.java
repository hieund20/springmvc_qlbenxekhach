/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Seat;
import com.mycompany.service.SeatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.SeatRepository; 

/**
 *
 * @author HIEU
 */
@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    private SeatRepository seatRepository;
    
    @Override
    public List<Seat> getSeatsByTripId(int tripId) {
        return this.seatRepository.getSeatsByTripId(tripId);
    }
    
}
