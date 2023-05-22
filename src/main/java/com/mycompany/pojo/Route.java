/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HIEU
 */
@Entity
@Table(name="route")
@XmlRootElement
public class Route implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @NotNull
    @Size(max = 50, min = 1)
    @Column(name = "departure")
    private String departure;
    
    @NotNull
    @Size(max = 50, min = 1)
    @Column(name = "destination")
    private String destination;
    
    @Column(name = "price")
    private Long price;

    @Size(max = 500, min = 1)
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Transient
    private MultipartFile file;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<Trip> tripSet;

    @JoinColumn(name = "garageId", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_route_garage"),
            nullable = false)
    @ManyToOne(optional = false)
    private Garage garageId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<OrderDetail> orderDetailSet;

    public Route() {
    }
    
    public Route(Integer id) {
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
     * @return the departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the tripSet
     */
    public Set<Trip> getTripSet() {
        return tripSet;
    }

    /**
     * @param tripSet the tripSet to set
     */
    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail the thumbnail to set
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }   

    /**
     * @return the garageId
     */
    public Garage getGarageId() {
        return garageId;
    }

    /**
     * @param garageId the garageId to set
     */
    public void setGarageId(Garage garageId) {
        this.garageId = garageId;
    }

    /**
     * @return the orderDetailSet
     */
    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    /**
     * @param orderDetailSet the orderDetailSet to set
     */
    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
