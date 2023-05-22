/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HIEU
 */
@Entity
@Table(name="seat")
@XmlRootElement
public class Seat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @NotNull
    @Size(max = 45, min = 1)
    @Column(name="code")
    private String code;
    
    @NotNull
    @Column(name="isEmpty")
    private Boolean isEmpty;
    
    @NotNull
    @Column(name="isBooked")
    private Boolean isBooked;
    
    @NotNull
    @Column(name="isBooking")
    private Boolean isBooking;
    
    @JoinColumn(name = "tripId", referencedColumnName = "id", 
            foreignKey = @ForeignKey(name = "fk_seat_trip"),
            nullable = false)
    @ManyToOne(optional = false)
    private Trip tripId;
    
    public Seat() {
    }
    
    public Seat(Integer id) {
       this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the isEmpty
     */
    public Boolean getIsEmpty() {
        return isEmpty;
    }

    /**
     * @param isEmpty the isEmpty to set
     */
    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    /**
     * @return the isBooked
     */
    public Boolean getIsBooked() {
        return isBooked;
    }

    /**
     * @param isBooked the isBooked to set
     */
    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    /**
     * @return the isBooking
     */
    public Boolean getIsBooking() {
        return isBooking;
    }

    /**
     * @param isBooking the isBooking to set
     */
    public void setIsBooking(Boolean isBooking) {
        this.isBooking = isBooking;
    }

    /**
     * @return the tripId
     */
    public Trip getTripId() {
        return tripId;
    }

    /**
     * @param tripId the tripId to set
     */
    public void setTripId(Trip tripId) {
        this.tripId = tripId;
    }
}
