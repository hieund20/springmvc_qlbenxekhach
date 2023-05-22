/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HIEU
 */
@Entity
@Table(name = "trip")
@XmlRootElement
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "start_time")
    private LocalTime start_time;
    
    @NotNull
    @Column(name = "departure_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departure_date;

    @JoinColumn(name = "route_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_trip_route"),
            nullable = false)
    @ManyToOne(optional = false)
    private Route routeId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripId")
    private Set<Seat> seatSet;

    public Trip() {
    }

    public Trip(Integer id) {
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
     * @return the routeId
     */
    public Route getRouteId() {
        return routeId;
    }

    /**
     * @param routeId the routeId to set
     */
    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    /**
     * @return the start_time
     */
    public LocalTime getStart_time() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    /**
     * @return the seatSet
     */
    public Set<Seat> getSeatSet() {
        return seatSet;
    }

    /**
     * @param seatSet the seatSet to set
     */
    public void setSeatSet(Set<Seat> seatSet) {
        this.seatSet = seatSet;
    }

    /**
     * @return the departure_date
     */
    public Date getDeparture_date() {
        return departure_date;
    }

    /**
     * @param departure_date the departure_date to set
     */
    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

}
