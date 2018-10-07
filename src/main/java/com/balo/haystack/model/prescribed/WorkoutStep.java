package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class WorkoutStep {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private Long id;

	@Getter @Setter
	@Embedded
	private Rest rest;

	@ManyToOne
	@Getter @Setter
	private Workout workout;

	@OneToOne(mappedBy = "workoutStep", cascade = CascadeType.ALL)
	@Getter
	private Superset superset;

	public void setSuperset(Superset superset) {
		validateNoMovement();
		validateNoFreeformStep();
		this.superset = superset;
		superset.setWorkoutStep(this);
	}

	@OneToOne(mappedBy = "workoutStep", cascade = CascadeType.ALL)
	@Getter
	private Movement movement;

	public void setMovement(Movement movement) {
		validateNoSuperset();
		validateNoFreeformStep();
		this.movement = movement;
		movement.setWorkoutStep(this);
	}

	@OneToOne(mappedBy = "workoutStep", cascade = CascadeType.ALL)
	@Getter
	private FreeformStep freeformStep;

	public void setFreeformStep(FreeformStep freeformStep) {
		validateNoMovement();
		validateNoSuperset();
		this.freeformStep = freeformStep;
		freeformStep.setWorkoutStep(this);
	}

	@ManyToOne
	@Getter @Setter
	private Superset parentSuperset;

	public WorkoutStep(Superset superset, Rest rest) {
		super();
		this.setSuperset(superset);
		this.setRest(rest);
	}

	public WorkoutStep(FreeformStep freeformStep, Rest rest) {
		super();
		this.setFreeformStep(freeformStep);
		this.setRest(rest);
	}

	public WorkoutStep(Movement movement, Rest rest) {
		super();
		this.setMovement(movement);
		this.setRest(rest);
	}

	private void validateNoMovement() {
		if (this.movement != null)
			throw new RuntimeException("This step already has a Movement assigned");
	}

	private void validateNoSuperset() {
		if (this.superset != null)
			throw new RuntimeException("This step already has a Superset assigned");
	}

	private void validateNoFreeformStep() {
		if (this.freeformStep != null)
			throw new RuntimeException("This step already has a Freeform Step assigned");
	}
}
