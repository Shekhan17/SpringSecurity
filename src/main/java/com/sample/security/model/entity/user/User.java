package com.sample.security.model.entity.user;

import com.sample.security.model.dto.User.Role;
import com.sample.security.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User extends BaseEntity<Long> {
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Column(name = "isActive")
    private Boolean isActive;
}
