package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Set {
	@Id
	@Getter
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Getter @Setter
	private String label;

	@Getter @Setter
	@Embedded
	private Reps reps;

	@Getter @Setter
	@Embedded
	private Rest rest;

	@ManyToOne
	@Getter @Setter
	private Movement movement; //containing movement

	@Getter @Setter
	@Embedded
	private AbsoluteWeight absoluteWeight;

	@Getter @Setter
	@Embedded
	private Pct1RMWeight pct1RMWeight;

	@Getter @Setter
	@Embedded
	private RPEWeight rpeWeight;

	public Set() {
	}

	private Set(String label, Reps reps, Rest rest) {
		this.label = label;
		this.reps = reps;
		this.rest = rest;
	}

	public Set(String label, AbsoluteWeight weight, Reps reps, Rest rest) {
		this(label, reps, rest);
		this.absoluteWeight = weight;
	}

	public Set(String label, RPEWeight weight, Reps reps, Rest rest) {
		this(label, reps, rest);
		this.rpeWeight = weight;
	}

	public Set(String label, Pct1RMWeight weight, Reps reps, Rest rest) {
		this(label, reps, rest);
		this.pct1RMWeight = weight;
	}
}
