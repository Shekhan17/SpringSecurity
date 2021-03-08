package com.sample.security.controller.rest;

import com.sample.security.model.dto.User.UserDto;
import com.sample.security.model.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private Orchestrator orchestrator;

    @GetMapping
    public List getAll() throws ClassNotFoundException {
        return orchestrator.getAll(UserDto.class);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) throws ClassNotFoundException {
        return orchestrator.get(id, UserDto.class);
    }

    @PutMapping
    public UserDto put(@RequestBody UserDto dto) throws ClassNotFoundException {
        return orchestrator.put(dto, UserDto.class, User.class);
    }

    @PostMapping
    public UserDto post(@RequestBody UserDto dto) throws ClassNotFoundException {
        return orchestrator.post(dto, UserDto.class, User.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ClassNotFoundException {
        orchestrator.delete(id, UserDto.class);
    }

}
