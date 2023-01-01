package com.example.projectprac.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecuriyConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable() // ui 쪽 접근 차단
                .csrf().disable() // 크로스 사이트 기능?
                .cors().and()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll() // api/** 허용
                .antMatchers("/api/v1/users/join", "/api/v1/users/login").permitAll() // join, login 허용
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt 사용하는 경우 씀
                .and()
                .build();

    }
}
