package com.example.veterinaryclinic.auth;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority {

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    private String authority;

    public UserRole() {
    }

    public UserRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    };
}
