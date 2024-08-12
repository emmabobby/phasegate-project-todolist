package com.africa.semicolon.todolistapplication.utils;

import com.africa.semicolon.todolistapplication.data.models.User;

public class UserMapper {
    public static User map(String userName, String password){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        return user;
    }
}
