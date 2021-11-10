package com.jwt.home.controller;

import com.jwt.home.entity.TokenEntity;
import com.jwt.home.entity.UserEntity;
import com.jwt.home.model.UserPrincipal;
import com.jwt.home.service.TokenService;
import com.jwt.home.service.UserService;
import com.jwt.home.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    @ResponseBody
    public UserEntity register(@RequestBody UserEntity user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        UserPrincipal userPrincipal = userService.findByUsername(user.getUserName());
        if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("username or password is not incorrect");
        }
        TokenEntity token = new TokenEntity();
        token.setToken(jwtUtil.generateToken(userPrincipal));
        token.setTokenExpiry(jwtUtil.generateExpirationDate());
//        token.setCr(userPrincipal.getUserId());
        tokenService.registerToken(token);
        return ResponseEntity.ok(token);
    }

}
