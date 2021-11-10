package com.jwt.home.service;

import com.jwt.home.entity.TokenEntity;

public interface TokenService {
    TokenEntity registerToken(TokenEntity token);

    TokenEntity findByToken(String token);
}
