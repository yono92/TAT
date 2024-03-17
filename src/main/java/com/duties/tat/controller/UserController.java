package com.duties.tat.controller;

import com.duties.tat.entity.User;
import com.duties.tat.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    // 유저 회원가입 API

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@ModelAttribute User user) {
        log.info("registerUser user: {}", user);
        log.info("Username: {}", user.getName()); // 추가된 로그
        User registeredUser = userService.save(user);
        return ResponseEntity.ok(registeredUser);
    }

    // 유저 로그인 API
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User loginUser = userService.findById(user.getId());
        return ResponseEntity.ok(loginUser);
    }

    // 유저 정보 수정 API
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
