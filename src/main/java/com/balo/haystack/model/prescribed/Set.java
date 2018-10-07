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
	private Weight weight;

	@Getter @Setter
	@Embedded
	private Reps reps;

	@Getter @Setter
	@Embedded
	private Rest rest;

	public Set() {
	}

	public Set(String label, Weight weight, Reps reps, Rest rest) {
		this.label = label;
		this.weight = weight;
		this.reps = reps;
		this.rest = rest;
	}
}
