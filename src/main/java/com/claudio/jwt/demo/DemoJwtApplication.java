package com.claudio.jwt.demo;

import com.claudio.jwt.demo.model.Role;
import com.claudio.jwt.demo.model.User;
import com.claudio.jwt.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Claudio", "ClaudioAlonso10", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Brian", "BrianBatista", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "David", "Batela4", "1234", new ArrayList<>()));

			userService.addRoleToUser("ClaudioAlonso10", "ROLE_ADMIN");
			userService.addRoleToUser("BrianBatista", "ROLE_USER");
			userService.addRoleToUser("Batela4", "ROLE_MANAGER");
		};
	}
}
