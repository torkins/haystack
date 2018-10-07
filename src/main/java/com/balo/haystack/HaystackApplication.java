package com.balo.haystack;

import com.balo.haystack.model.prescribed.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@RestController
public class HaystackApplication {

	@Autowired
	WorkoutRepository workoutRepo;

	public static void main(String[] args) {
		SpringApplication.run(HaystackApplication.class, args);
	}

	@GetMapping("/")
	public String trainYoSelf() {
		Workout wkt = new Workout();
		wkt.setRationale("hypertrophy");
		wkt.setDate(new Date());
		ArrayList<WorkoutStep> steps = new ArrayList<WorkoutStep>();
		wkt.addStep(new WorkoutStep(new Movement("Comp Squat"), new Rest(RestType.MINUTES, 2)));
		wkt.addStep(new WorkoutStep(new FreeformStep("Do something free", "and awesome"), new Rest(RestType.UNSPECIFIED)));
		Superset superset = new Superset("cool superset", "desc");
		superset.addStep(new WorkoutStep(new Movement("AMRAP Inverted Rows"), new Rest(RestType.UNSPECIFIED)));
		superset.addStep(new WorkoutStep(new Movement("Pushups"), new Rest(RestType.UNSPECIFIED)));
		wkt.addStep(new WorkoutStep(superset, new Rest(RestType.UNSPECIFIED)));
		workoutRepo.save(wkt);
		return "Train yo self!";
	}
}
