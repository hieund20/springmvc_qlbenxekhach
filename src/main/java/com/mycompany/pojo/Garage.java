/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "garage")
@XmlRootElement
public class Garage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Size(max = 100, min = 1)
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Size(max = 500, min = 1)
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Transient
    private MultipartFile file;
    
    @NotNull
    @Column(name = "isActive")
    private Boolean isActive;
    
    @NotNull
    @Column(name = "isAllowed")
    private Boolean isAllowed;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garageId")
    private Set<Route> routeSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garageId", fetch = FetchType.EAGER)
    private Collection<Comment> commentCollection;
    
    {
        isAllowed = false;
    }
    
    public Garage() {
    }
    
    public Garage(Integer id) {
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the routeSet
     */
    public Set<Route> getRouteSet() {
        return routeSet;
    }

    /**
     * @param routeSet the routeSet to set
     */
    public void setRouteSet(Set<Route> routeSet) {
        this.routeSet = routeSet;
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
     * @return the commentSet
     */
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    /**
     * @param commentSet the commentSet to set
     */
    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    /**
     * @return the isAllowed
     */
    public Boolean getIsAllowed() {
        return isAllowed;
    }

    /**
     * @param isAllowed the isAllowed to set
     */
    public void setIsAllowed(Boolean isAllowed) {
        this.isAllowed = isAllowed;
    }
}
