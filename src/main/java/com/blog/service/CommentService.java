package com.blog.service;

import com.blog.pojo.Comment;

import java.util.*;


public interface CommentService {
    List<Comment> ListCommentByBlogId(Long blogId);
    Comment saveComment(Comment comment);

}
