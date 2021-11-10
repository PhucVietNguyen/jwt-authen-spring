package com.jwt.home.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "permission")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PermissionEntity extends BaseEntity{

    @Column(name = "permission_key")
    private String permissionKey;
    @Column(name = "permission_name")
    private String permissionName;

    @ManyToMany(mappedBy = "permissions")
    private Set<RoleEntity> roles;
}
