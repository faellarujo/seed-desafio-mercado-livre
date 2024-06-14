package com.pt.mercadolivre.service;

import com.pt.mercadolivre.config.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String password) {
        final String encode = passwordEncoder.bCryptPasswordEncoder().encode(String.valueOf(password));
        return encode;
    }
}
