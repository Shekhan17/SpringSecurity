package com.sample.security.controller.rest;

import com.sample.security.model.dto.User.UserDto;
import com.sample.security.model.dto.auth.AuthenticationRequestDto;
import com.sample.security.repository.UserRepository;
import com.sample.security.security.jwt.JwtTokenProvider;
import com.sample.security.utils.converter.Converter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationRestController {


    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final Converter converter;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDto.getLogin(), requestDto.getPassword()));
            UserDto userDto = converter.convert(
                    userRepository.findByLogin(requestDto.getLogin()).orElseThrow(()
                            -> new UsernameNotFoundException("User doesn't exist"))
                    , UserDto.class);
            String token = jwtTokenProvider.createToken(requestDto.getLogin(), userDto.getRole().name());
            Map response = new HashMap<Object, Object>() {{
                put("login", requestDto.getLogin());
                put("token", token);
            }};
            return ResponseEntity.ok(response);
        } catch (AuthenticationException ex) {
            return new ResponseEntity<>("Invalid credential", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request, response, null);
    }
}
