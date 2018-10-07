package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Workout {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private Long id;

	@Getter
	@Setter
	private String rationale;

	@Getter
	@Setter
	private Date date;

	@Getter
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "workout")
	private Collection<WorkoutStep> steps;

	public Workout() {
	}

	public void addStep(WorkoutStep step) {
		if (step == null) return;
		if (steps == null) {
			steps = new ArrayList<WorkoutStep>();
		}
		steps.add(step);
		step.setWorkout(this);
	}
}
