package com.sample.security.model.dto;

import org.springframework.stereotype.Service;

@Service
public interface Converter<Dto, Entity> {
    public Entity toEntity(Dto dto);
    public Dto toDto(Entity entity);
}
