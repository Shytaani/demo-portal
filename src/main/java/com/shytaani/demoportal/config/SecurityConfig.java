package com.shytaani.demoportal.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(login -> login
            .loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            .failureUrl("/loginForm?error")
            .permitAll()
        ).logout(logout -> logout
            .logoutSuccessUrl("/"))
        .authorizeHttpRequests(authz -> authz
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll()
            .mvcMatchers("/")
            .permitAll()
            .antMatchers("/h2-console/**")
            .permitAll()
            // 管理者権限を持つユーザーのみアクセス可
            .mvcMatchers("/admin")
            .hasRole("ADMIN")
            // 社員権限を持つユーザーのみアクセス可
            .mvcMatchers("/employee")
            .hasRole("EMPLOYEE")
            // 顧客権限を持つユーザーのみアクセス可
            .mvcMatchers("/client")
            .hasRole("CLIENT")
            .anyRequest().authenticated()
            ).csrf().ignoringAntMatchers("/h2-console/**")
            .and().headers().frameOptions().sameOrigin();
        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
