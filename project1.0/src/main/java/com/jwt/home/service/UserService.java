package com.jwt.home.service;

import com.jwt.home.entity.UserEntity;
import com.jwt.home.model.UserPrincipal;

public interface UserService {
    UserEntity registerUser(UserEntity user);

    UserPrincipal findByUsername(String username);
}
