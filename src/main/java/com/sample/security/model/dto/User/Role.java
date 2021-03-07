package com.sample.security.model.dto.User;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
public enum Role {
    USER(new HashSet<Permission>() {{
        add(Permission.READ);
    }}),
    ADMIN(new HashSet<Permission>() {{
        add(Permission.READ);
        add(Permission.WRITE);
    }});

    private final Set<Permission> permissions;

}
