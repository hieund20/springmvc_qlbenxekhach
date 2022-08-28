/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;
import com.mycompany.pojo.Seat;
import java.util.List;

/**
 *
 * @author HIEU
 */
public interface SeatService {
    List<Seat> getSeatsByTripId(int tripId);
}
