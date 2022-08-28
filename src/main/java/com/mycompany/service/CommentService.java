/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.Comment;

/**
 *
 * @author HIEU
 */
public interface CommentService {
    Comment addComment(String content, int garageId, int userId);
}
