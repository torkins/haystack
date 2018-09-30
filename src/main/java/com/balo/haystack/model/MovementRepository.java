package com.balo.haystack.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovementRepository extends CrudRepository<Movement, Long> {
	List<Movement> findByName(String name);
}
