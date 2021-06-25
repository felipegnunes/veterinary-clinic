package com.example.veterinaryclinic;

import java.util.List;

import com.example.veterinaryclinic.auth.User;
import com.example.veterinaryclinic.auth.UserRepository;

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

	@RequestMapping("test")
	public List<User> test() {
		User user = new User("felipeguimaraesnunes@gmail.com", passwordEncoder.encode("1234"));
		userRepository.save(user);
		return userRepository.findAll();
	}

}
