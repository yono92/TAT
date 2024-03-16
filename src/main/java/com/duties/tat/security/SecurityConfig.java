package com.duties.tat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 모든 경로에 대해 허용하는 configuration
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests.anyRequest().permitAll()
        );

        return http.build();
    }
    // 비밀번호 암호화
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder ();
     }

}
