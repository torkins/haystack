package com.balo.haystack;

import com.balo.haystack.model.Movement;
import com.balo.haystack.model.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class HaystackApplication {

	@Autowired
	MovementRepository mvmtRepo;

	public static void main(String[] args) {
		SpringApplication.run(HaystackApplication.class, args);
	}

	@GetMapping("/")
	public String trainYoSelf() {
		Movement mvmt = new Movement("hey");
		mvmtRepo.save(mvmt);
		return "Train yo self!";
	}
}
