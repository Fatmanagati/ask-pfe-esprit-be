package com.ask.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.Technology;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Long>{

}
