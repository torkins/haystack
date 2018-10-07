package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Embeddable
public abstract class RPEWeight extends Weight {
	@Getter @Setter
	private String rpe;

	public RPEWeight(String rpe) {
		this.rpe = rpe;
	}
}
