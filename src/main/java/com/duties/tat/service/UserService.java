package com.duties.tat.service;

import com.duties.tat.entity.User;
import com.duties.tat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    // 유저 생성
    public void save(User user) {
        user.setPassword ( passwordEncoder.encode(user.getPassword()) );
        userRepository.save(user);
    }


}
