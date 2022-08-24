package com.shytaani.demoportal.login.service;

import com.shytaani.demoportal.login.entity.LoginUser;
import com.shytaani.demoportal.login.entity.LoginUserDetails;
import com.shytaani.demoportal.login.repository.LoginUserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private LoginUserRepository repository;

    public LoginUserDetailsService(LoginUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser user =  repository.findUser(username).orElseThrow(() ->
            new UsernameNotFoundException("ユーザー名: %s のユーザーは見つかりませんでした。".formatted(username)));
        return new LoginUserDetails(user);
    }

}
