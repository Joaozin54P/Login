package com.fatec.login.config;

import com.fatec.login.security.JwtAuthFilterSecurity;
import com.fatec.login.security.UserDetailsSecurity;
import com.fatec.login.security.JwtSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class securityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity httpSecurity,
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) throws Exception {

        AuthenticationManagerBuilder builder = httpSecurity
                .getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

        return builder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(
            JwtSecurity jwtSecurity,
            UserDetailsSecurity userDetailsSecurity,
            HttpSecurity httpSecurity) throws Exception {

        JwtAuthFilterSecurity jwtFilter =
                new JwtAuthFilterSecurity(jwtSecurity, userDetailsSecurity);

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login/**"
                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}