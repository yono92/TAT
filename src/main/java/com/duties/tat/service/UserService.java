package com.duties.tat.service;

import com.duties.tat.entity.User;
import com.duties.tat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // PasswordEncoder 주입

    // 유저 생성
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 비밀번호 암호화
        userRepository.save(user);
        return user;
    }

    // 예시: ID로 유저 찾기
    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    // 사용자 인증
    public User authenticate(String userId, String password) {
        User user = findById(userId);
        // 인코딩된 패스워드 비교
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // 인증 성공 시 리턴
            return user;
        } else {
            // 인증 실패 처리
            return null;
        }
    }
}
