package com.jwt.home.service.impl;

import com.jwt.home.entity.TokenEntity;
import com.jwt.home.repository.TokenRepository;
import com.jwt.home.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public TokenEntity registerToken(TokenEntity token) {
        TokenEntity entity = tokenRepository.save(token);
        return entity;
    }

    @Override
    public TokenEntity findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
