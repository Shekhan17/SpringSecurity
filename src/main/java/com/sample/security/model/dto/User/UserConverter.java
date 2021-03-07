package com.sample.security.model.dto.User;

import com.sample.security.model.dto.Converter;
import com.sample.security.model.entity.user.User;

public class UserConverter implements Converter<UserDto, User> {
    @Override
    public UserDto toDto(User user) {
        return new UserDto() {{
            setId(user.getId());
            setLogin(user.getLogin());
            setPassword(user.getPassword());
            setIsActive(user.getIsActive());
            setRole(user.getRole());
        }};
    }

    @Override
    public User toEntity(UserDto userDto) {
        return new User() {{
            setId(userDto.getId());
            setLogin(userDto.getLogin());
            setPassword(userDto.getPassword());
            setIsActive(userDto.getIsActive());
            setRole(userDto.getRole());
        }};
    }
}
