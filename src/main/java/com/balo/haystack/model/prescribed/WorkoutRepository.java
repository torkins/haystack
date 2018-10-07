package com.balo.haystack.model.prescribed;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
	List<Workout> findByRationale(String rationale);
}
