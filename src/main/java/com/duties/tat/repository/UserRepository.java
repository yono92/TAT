package com.duties.tat.repository;

import com.duties.tat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    //유저 목록 전체 가져오기
    List<User> findAll();

    //유저 생성 및 수정
    User save(User user);

    //유저 삭제
    void delete(User user);

    Optional<User> findById(String id);


    User findByUserId(String userId);
}
