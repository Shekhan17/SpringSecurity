package com.sample.security.rest.controller;

import com.sample.security.model.dto.User.UserDto;
import com.sample.security.model.entity.user.User;
import com.sample.security.rest.Orchestrator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private Orchestrator orchestrator;

    @GetMapping
    public List<UserDto> getAll() {
        return orchestrator.getAll(UserDto.class);
    }

}
