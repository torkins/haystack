package com.balo.haystack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Movement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	protected Movement() {
	}

	public Movement(String name) {
		this.name = name;
	}
}
