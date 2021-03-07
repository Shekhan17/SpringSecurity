package com.sample.security.model.dto.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Permission {
    READ("read"),
    WRITE("write");

    private final String name;
}
