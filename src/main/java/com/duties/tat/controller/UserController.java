package com.duties.tat.controller;

import com.duties.tat.entity.User;
import com.duties.tat.jwt.JwtTokenProvider;
import com.duties.tat.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.duties.tat.jwt.JwtAuthenticationResponse;
import com.duties.tat.dto.LoginRequest;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;



    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@ModelAttribute User user) {
        log.info("registerUser user: {}", user);
        User registeredUser = userService.save(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getUserId(), loginRequest.getPassword());
        if (user != null) {
            // 로그인 성공하면 JWT 토큰 생성하여 반환
            String token = jwtTokenProvider.generateToken(user.getUserId(), user.getRole());
            return ResponseEntity.ok(new JwtAuthenticationResponse(token)); // JWT 토큰 응답으로 반환
        } else {
            // 로그인 실패
            return ResponseEntity.badRequest().body("Invalid username or password");  // 실패 메시지 등을 반환
        }
    }
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
