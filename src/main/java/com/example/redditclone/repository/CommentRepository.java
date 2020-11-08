package com.example.redditclone.repository;

import com.example.redditclone.model.Comment;
import com.example.redditclone.model.Post;
import com.example.redditclone.model.User;

import java.util.List;


public interface CommentRepository {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
