package com.balo.haystack.model.prescribed;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovementRepository extends CrudRepository<Movement, Long> {
	List<Movement> findByLabel(String label);
}
