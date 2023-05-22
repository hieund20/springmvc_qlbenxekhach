/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.User;
import com.mycompany.service.UserService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HIEU
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping(value = "/register")
    public String registerProcess(@ModelAttribute(name = "user") User user, 
            BindingResult result) {        
        if (result.hasErrors()) 
            return "register";

        try {
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            String avatar = (String) r.get("secure_url");
            user.setAvatar(avatar);

        } catch (IOException ex) {
            System.err.println("Add garage image have error: " + ex.getMessage());
        }

        userService.addUser(user);

        return "redirect:/login";
    }
}
