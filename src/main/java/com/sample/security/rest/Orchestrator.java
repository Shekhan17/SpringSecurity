package com.sample.security.rest;

import com.sample.security.model.dto.Converter;
import com.sample.security.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class Orchestrator {
    private final UserRepository userRepository;
    private final Converter converter;

    public <Dto> List<Dto> getAll(Class<?> clazz) {

        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(el -> converter.toDto(el))
                .collect(Collectors.toList());
    }

}
