package com.balo.haystack.model.prescribed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private Long id;

	@Getter @Setter
	private String name;

	public Exercise() {
	}

	public Exercise(String name) {
		super();
		this.setName(name);
	}
}
