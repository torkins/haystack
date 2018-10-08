package com.balo.haystack.model.logged;

import com.balo.haystack.model.logged.WorkoutStep;
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
	private String comments;

	//the step containing this movement
	@OneToOne
	@Getter @Setter
	private WorkoutStep workoutStep;

	@Getter @Setter
	private Boolean completed = false;



	public Movement() {}

	public Movement(String comments) {
		this.comments = comments;
	}
}
