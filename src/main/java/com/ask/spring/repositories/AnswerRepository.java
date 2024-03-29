package com.ask.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
