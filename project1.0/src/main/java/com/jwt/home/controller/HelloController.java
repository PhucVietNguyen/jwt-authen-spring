package com.jwt.home.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api")
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('user_read')")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }
}
