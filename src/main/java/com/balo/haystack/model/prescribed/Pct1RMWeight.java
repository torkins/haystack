package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Embeddable
public abstract class Pct1RMWeight extends Weight {
	@Getter @Setter
	private int percentage;

	public Pct1RMWeight(int percentage) {
		this.percentage = percentage;
	}
}
