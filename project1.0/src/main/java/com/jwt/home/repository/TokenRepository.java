package com.jwt.home.repository;

import com.jwt.home.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    TokenEntity findByToken(String token);
}
