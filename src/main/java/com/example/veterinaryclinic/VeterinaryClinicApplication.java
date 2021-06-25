package com.example.veterinaryclinic;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;

import com.example.veterinaryclinic.auth.User;
import com.example.veterinaryclinic.auth.UserRepository;
import com.example.veterinaryclinic.auth.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VeterinaryClinicApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryClinicApplication.class, args);
	}

	@RequestMapping("onlyadmin")
	@Transactional
	@RolesAllowed(UserRole.ADMIN)
	public String onlyadmin() {
		return "You're an admin";
	}

	@RequestMapping("onlyuser")
	@RolesAllowed(UserRole.USER)
	public String onlyuser() {
		return "You're an user";
	}

}
