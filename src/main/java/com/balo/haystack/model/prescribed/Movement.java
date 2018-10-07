package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Movement {

	@Id
	@Getter
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Getter @Setter
	private String label;

	@OneToOne
	@Getter @Setter
	private WorkoutStep workoutStep;

	public Movement() {
	}

	public Movement(String label) {
		super();
		this.setLabel(label);
	}
}
