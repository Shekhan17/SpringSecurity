package com.sample.security.model.dto.User;

import com.sample.security.model.dto.BaseDto;
import lombok.Data;

@Data
public class UserDto extends BaseDto<Long> {
    private String login;
    private String password;
    private Role role;
    private Boolean isActive;
}
