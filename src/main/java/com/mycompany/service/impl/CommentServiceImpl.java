/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojo.Comment;
import com.mycompany.pojo.Garage;
import com.mycompany.pojo.User;
import com.mycompany.repository.CommentRepository;
import com.mycompany.repository.GarageRepository;
import com.mycompany.repository.UserReposisory;
import com.mycompany.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HIEU
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private UserReposisory userRepository;

    @Override
    public Comment addComment(String content, int garageId, int userId) {
        Garage g = this.garageRepository.getGarageById(garageId);
        User u = this.userRepository.getUserById(userId);

        Comment c = new Comment();
        c.setContent(content);
        c.setGarageId(g);
        c.setUserId(u);
        c.setCreated_date(new Date());

        return this.commentRepository.addComment(c);
    }
}
