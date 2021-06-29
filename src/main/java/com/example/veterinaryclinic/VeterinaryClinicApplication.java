package com.example.veterinaryclinic;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;

import com.example.veterinaryclinic.auth.UserRole;
import com.example.veterinaryclinic.model.Animal;
import com.example.veterinaryclinic.model.Appointment;
import com.example.veterinaryclinic.repository.AnimalRepository;
import com.example.veterinaryclinic.repository.AppointmentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VeterinaryClinicApplication {

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

	@Bean
	@Transactional
	CommandLineRunner commandLineRunner(AnimalRepository animalRepository,
			AppointmentRepository appointmentRepository) {
		return args -> {
			Animal animal = new Animal("John", "Dog", 2);
			animalRepository.save(animal);

			System.out.println(animalRepository.findAll().toString());

			Timestamp ts = Timestamp.valueOf("2017-11-15 15:30:14.332");

			Appointment app1 = new Appointment(new BigDecimal("10.22"), ts, animal);
			appointmentRepository.save(app1);

			System.out.println("================= Fetch animal =================");
			System.out.println(app1.getAnimal());

			System.out.println(appointmentRepository.findAll().toString());
		};
	}

}
