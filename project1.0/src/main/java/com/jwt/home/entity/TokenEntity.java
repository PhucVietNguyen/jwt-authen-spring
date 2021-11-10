package com.jwt.home.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "token")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenEntity extends BaseEntity{

    @Column(name = "token")
    private String token;
    @Column(name = "token_expiry")
    private Date tokenExpiry;
}
