package com.balo.haystack.model.logged;

import com.balo.haystack.model.logged.WorkoutStep;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class FreeformStep {
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

	public FreeformStep() {
	}

	public FreeformStep(String label, String description) {
		this.label = label;
		this.description = description;
	}
}
