package com.balo.haystack;

import com.balo.haystack.model.WeightUOM;
import com.balo.haystack.model.prescribed.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		List<Set> squatSets = new ArrayList<Set>();
		squatSets.add(new Set("top set", new AbsoluteWeight(100, WeightUOM.POUNDS),
						new Reps(RepsType.NUM_OF_REPS, 6), new Rest(RestType.UNSPECIFIED)));
		squatSets.add(new Set("backoff set 1", new AbsoluteWeight(80, WeightUOM.POUNDS),
						new Reps(RepsType.NUM_OF_REPS, 6), new Rest(RestType.UNSPECIFIED)));
		wkt.addStep(new WorkoutStep(new Movement("Comp Squat", squatSets, new Rest(RestType.UNSPECIFIED)), new Rest(RestType.MINUTES, 2)));
		wkt.addStep(new WorkoutStep(new FreeformStep("Do something free", "and awesome"), new Rest(RestType.UNSPECIFIED)));
		Superset superset = new Superset("cool superset", "desc");
		List<Set> invertRowsSets = new ArrayList<Set>();
		invertRowsSets.add(new Set("", new RPEWeight("8"), new Reps(RepsType.AMRAP), new Rest(RestType.MINUTES, 1)));
		List<Set> pushupSets = new ArrayList<Set>();
		invertRowsSets.add(new Set("", new RPEWeight("8"), new Reps(RepsType.AMRAP), new Rest(RestType.MINUTES, 1)));
		superset.addStep(new WorkoutStep(new Movement("AMRAP Inverted Rows", invertRowsSets, new Rest(RestType.UNSPECIFIED)), new Rest(RestType.UNSPECIFIED)));
		superset.addStep(new WorkoutStep(new Movement("Pushups", pushupSets, new Rest(RestType.UNSPECIFIED)), new Rest(RestType.UNSPECIFIED)));
		wkt.addStep(new WorkoutStep(superset, new Rest(RestType.UNSPECIFIED)));
		workoutRepo.save(wkt);
		return "Train yo self!";
	}
}
