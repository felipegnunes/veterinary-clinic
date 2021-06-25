package com.example.veterinaryclinic.auth.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SignupRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Email
    @NotEmpty
    private String email;

    public SignupRequest() {
    }

    public SignupRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
