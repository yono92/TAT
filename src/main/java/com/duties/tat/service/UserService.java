package com.duties.tat.service;

import com.duties.tat.entity.User;
import com.duties.tat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    // 예시: ID로 유저 찾기
    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public User authenticate(String userId, String password) {
        User user = findById(userId);
        if (user != null && user.getPassword().equals(password)) {
            // 인증 성공 시 리턴
            return user;
        } else {
            // 인증 실패 처리
            return null;
        }
    }
}
