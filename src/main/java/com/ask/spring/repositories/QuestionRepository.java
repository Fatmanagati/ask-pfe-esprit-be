package com.ask.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

}
