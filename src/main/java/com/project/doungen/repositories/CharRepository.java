package com.project.doungen.repositories;

import java.util.List;

import com.project.doungen.models.Char;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CharRepository extends CrudRepository<Char,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
