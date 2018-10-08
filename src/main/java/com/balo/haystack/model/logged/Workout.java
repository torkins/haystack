package com.balo.haystack.model.logged;

import com.balo.haystack.model.logged.WorkoutStep;
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

	@Getter @Setter
	@OneToOne
	private com.balo.haystack.model.prescribed.Workout prescribedWorkout;

	//there's a date specified for this And prescribed because even if
	//it was prescribed on one day, maybe it happened on another one
	@Getter @Setter
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
