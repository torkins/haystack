package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Weight {
	@Getter @Setter
	private String weightLabel;
}
