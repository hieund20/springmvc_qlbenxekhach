/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comment")
@XmlRootElement
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Size(max = 255, min = 1)
    @Column(name = "content")
    private String content;
    
    @Column(name = "created_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created_date;
    
    @JoinColumn(name = "garageId", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_comment_garage"),
            nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Garage garageId;
    
    @JoinColumn(name = "userId", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_comment_user"),
            nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonIgnore
    private User userId;
    
    public Comment() {
    }
    
    public Comment(Integer id) {
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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
}
