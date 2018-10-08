package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Embeddable
public class Pct1RMWeight {
	@Getter @Setter
	private Integer percentage = -1;

	public Pct1RMWeight(int percentage) {
		this.percentage = percentage;
	}
}
