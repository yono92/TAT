package com.duties.tat.repository;

import com.duties.tat.entity.User;
import com.duties.tat.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.List;



@Slf4j
@RequiredArgsConstructor
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private UserService userService;


    // 유저 생성 테스트
    @Test
    @Transactional
    @Rollback(false)
    void save() {
        User user = new User();
        user.setId("test");
        user.setPassword("test");
        user.setName("test");
        user.setEmail ( "test" );
        user.setPhone ( "test" );
        user.setRole ( "test" );
        userService.save(user);
    }

    // 유저정보 전체 가져오는 테스트코드
    @Test
    void findAll() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            log.info("user : {}", user);
        }
    }

    @Test
    void findById() {
        User user = userRepository.findById("test");
        log.info("user 나와라요 : {}", user);
    }

}