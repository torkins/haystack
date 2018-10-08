package com.balo.haystack.model.logged;

import com.balo.haystack.model.logged.Workout;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class WorkoutStep {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private Long id;

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

	public WorkoutStep(Superset superset) {
		super();
		this.setSuperset(superset);
	}

	public WorkoutStep(FreeformStep freeformStep) {
		super();
		this.setFreeformStep(freeformStep);
	}

	public WorkoutStep(Movement movement) {
		super();
		this.setMovement(movement);
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
