package com.sample.security.model.entity.user;

import com.sample.security.model.dto.User.Role;
import com.sample.security.model.dto.User.Status;
import com.sample.security.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User extends BaseEntity<Long> {
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Column(name = "isActive")
    private Boolean isActive;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
