package com.fatec.login.config;

import com.fatec.login.security.JwtAuthFilterSecurity;
import com.fatec.login.security.UserDetailsSecurity;
import com.fatec.login.security.jwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class securityConfig {

    private final jwtService jwtService;
    private final UserDetailsSecurity userDetailsSecurity;

    public securityConfig(jwtService jwtService, UserDetailsSecurity userDetailsSecurity) {
        this.jwtService = jwtService;
        this.userDetailsSecurity = userDetailsSecurity;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public JwtAuthFilterSecurity jwtAuthFilter() {
        return new JwtAuthFilterSecurity(jwtService, userDetailsSecurity);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}