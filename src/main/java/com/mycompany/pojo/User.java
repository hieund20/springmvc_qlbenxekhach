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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name="user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.first_name = :first_name"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.last_name = :last_name"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.user_name = :user_name"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByUserRole", query = "SELECT u FROM User u WHERE u.role = :role")})
public class User implements Serializable {
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String GARAGE_OWNER = "GARAGE_OWNER";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @NotNull
    @Size(max = 45, min = 1)
    @Column(name = "first_name")
    private String first_name;
    
    @NotNull
    @Size(max = 45, min = 1)
    @Column(name = "last_name")
    private String last_name;
    
    @Size(max = 20, min = 1)
    @Column(name = "role")
    private String role;
    
    @NotNull
    @Size(max = 45, min = 1)
    @Column(name = "user_name")
    private String user_name;
    
    @NotNull
    @Size(max = 100, min = 1)
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Column(name = "phone")
    private Integer phone;
    
    @NotNull
    @Size(max = 45, min = 1)
    @Column(name = "email")
    private String email;
    
    @NotNull
    @Column(name = "active")
    private Boolean active;
    
    @NotNull
    @Size(max = 500, min = 1)
    @Column(name = "avatar")
    private String avatar;
    
    @Transient
    private MultipartFile file;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<SaleOrder> orderSaleSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Comment> commentSet;
    
    @Transient
    private String confirmPassword;
    
    {
        active = true;
        role = GARAGE_OWNER;
    }
    
    public User() {
        
    }
    
    public User (Integer id) {
        this.id = id;
    }

    public User(Integer id, String first_name, String last_name, String role, String user_name, String password, Integer phone, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
        this.user_name = user_name;
        this.password = password;
        this.phone = phone;
        this.email = email;
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
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the phone
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the orderSaleSet
     */
    public Set<SaleOrder> getOrderSaleSet() {
        return orderSaleSet;
    }

    /**
     * @param orderSaleSet the orderSaleSet to set
     */
    public void setOrderSaleSet(Set<SaleOrder> orderSaleSet) {
        this.orderSaleSet = orderSaleSet;
    }

    /**
     * @return the commentSet
     */
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    /**
     * @param commentSet the commentSet to set
     */
    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public String getUserRole() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
