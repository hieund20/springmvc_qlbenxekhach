/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
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
@Table(name = "sale_order")
@XmlRootElement
public class SaleOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "created_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created_date;
    
    @JoinColumn(name = "userId", referencedColumnName = "id", 
            foreignKey = @ForeignKey(name = "fk_saleorder_user"),
            nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Set<OrderDetail> orderDetailSet;
    
    public SaleOrder() {
        created_date = new Date();
    }
    
    public SaleOrder(Integer id) {
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
     * @return the amount
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return the created_date
     */
    public Date getCreated_date() {
        return created_date;
    }

    /**
     * @param created_date the created_date to set
     */
    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
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
    
    
    
}
