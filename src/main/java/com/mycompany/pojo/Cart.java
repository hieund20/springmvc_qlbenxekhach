/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

/**
 *
 * @author HIEU
 */
public class Cart {
    private int routeId;
    private int tripId;
    private int seatId;
    private String code;
    private Long routePrice;
    private int quantitySeat;
    private Long totalPrice;

    /**
     * @return the seatId
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * @param routeId the seatId to set
     */
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    /**
     * @return the tripId
     */
    public int getTripId() {
        return tripId;
    }

    /**
     * @param tripId the tripId to set
     */
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    /**
     * @return the quantitySeat
     */
    public int getQuantitySeat() {
        return quantitySeat;
    }

    /**
     * @param quantitySeat the quantitySeat to set
     */
    public void setQuantitySeat(int quantitySeat) {
        this.quantitySeat = quantitySeat;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the routePrice
     */
    public Long getRoutePrice() {
        return routePrice;
    }

    /**
     * @param routePrice the routePrice to set
     */
    public void setRoutePrice(Long routePrice) {
        this.routePrice = routePrice;
    }

    /**
     * @return the totalPrice
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the seatId
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * @param seatId the seatId to set
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
}
