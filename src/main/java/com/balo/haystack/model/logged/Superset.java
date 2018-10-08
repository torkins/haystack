package com.balo.haystack.model.logged;

import com.balo.haystack.model.logged.WorkoutStep;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Superset {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private Long id;

	@Getter @Setter
	private String label;

	@Getter @Setter
	private String description;

	@OneToOne
	@Getter @Setter
	private WorkoutStep workoutStep;

	@Getter
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "parentSuperset")
	private Collection<WorkoutStep> steps;

	public Superset() {
	}

	public Superset(String label, String description) {
		this.label = label;
		this.description = description;
	}

	public void addStep(WorkoutStep step) {
		if (this.steps == null) {
			this.steps = new ArrayList<WorkoutStep>();
		}
		this.steps.add(step);
		step.setParentSuperset(this);
	}
}
