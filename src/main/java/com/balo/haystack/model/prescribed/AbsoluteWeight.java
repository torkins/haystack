package com.balo.haystack.model.prescribed;

import com.balo.haystack.model.WeightUOM;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Embeddable
public class AbsoluteWeight {
	@Getter @Setter
	private Integer weight;

	@Getter @Setter
	private WeightUOM weightUOM;

	public AbsoluteWeight(int weight, WeightUOM weightUOM) {
		this.weight = weight;
		this.weightUOM = weightUOM;
	}

	public AbsoluteWeight() {
	}
}
