package com.jwt.home.service.impl;

import com.jwt.home.entity.UserEntity;
import com.jwt.home.model.UserPrincipal;
import com.jwt.home.repository.UserRepository;
import com.jwt.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity registerUser(UserEntity user) {
        UserEntity entity = userRepository.save(user);
        return entity;
    }

    @Override
    public UserPrincipal findByUsername(String username) {
        UserEntity user = userRepository.findByUserName(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != user) {
            Set<String> authorities = new HashSet<>();
            if (null != user.getRoles()) user.getRoles().forEach(r -> {
                authorities.add(r.getRoleKey());
                r.getPermissions().forEach(p -> authorities.add(p.getPermissionKey()));
            });

            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getUserName());
            userPrincipal.setPassword(user.getPassword());
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }
}
