package com.duties.tat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties({"password"})
public class User {

    // 글자수 16자로 제한 (아이디)
    @Id
    @NonNull
    private String userId;

    private String password;
    private String name;
    private String email;
    private String phone;
    private String role;

    public User() {

    }
}
