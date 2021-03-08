package com.sample.security.model.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
