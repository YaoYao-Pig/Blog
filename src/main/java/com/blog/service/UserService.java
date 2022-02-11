package com.blog.service;

import com.blog.pojo.User;

public interface UserService {
    User checkUser(String username,String password);
}
