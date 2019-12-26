package com.mongodb.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.example.document.User;
import com.mongodb.example.repository.UserRepository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> {
			List<User> list = new ArrayList<>();
			list.add(new User(1, "Piyush", "Pune", 30));
			list.add(new User(2, "Ram", "Ayodhya", 20));
			list.add(new User(3, "Ravish", "Mumbai", 40));
			list.add(new User(4, "Tohru", "Kyoto", 10));

			list.forEach(x -> {
				userRepository.save(x);
			});
		};
	}
}
