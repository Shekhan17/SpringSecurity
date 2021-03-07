package com.sample.security.model.dto;

import lombok.Data;

@Data
public abstract class BaseDto <T> {
    private T Id;
}
