package com.sivalabs.springbootelkdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootElkDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElkDemoApplication.class, args);
	}

	@Autowired
	MessageRepository repo;

	@Override
	public void run(String... args) {
		for (int i = 0; i < 20; i++) {
			Message m = new Message();
			m.setText("My message "+i);
			repo.save(m);
		}
	}
}
