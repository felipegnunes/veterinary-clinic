package com.example.veterinaryclinic;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AuthRequest {

    @NotNull
    @Email
    private String username;

    @NotNull
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
