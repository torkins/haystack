package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

	@Getter @Setter
	@ManyToOne
	private Exercise exercise;

	@OneToMany(mappedBy="movement", cascade = CascadeType.ALL)
	@Getter
	private List<Set> sets;

	public void setSets(List<Set> sets) {
		for (Set set : sets) {
			set.setMovement(this);
		}

		this.sets = sets;
	}

	@Embedded
	@Getter @Setter
	private Rest rest;

	public Movement() {
	}

	public Movement(String label, List<Set> sets, Rest rest) {
		super();
		this.setLabel(label);
		this.setSets(sets);
		this.setRest(rest);
	}
}
