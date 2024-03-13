package com.duties.tat.repository;

import com.duties.tat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    //유저 목록 전체 가져오기
    List<User> findAll();

    //유저 생성 및 수정
    User save(User user);

    //아이디로 유저 찾기
    User findById(String id);

}
