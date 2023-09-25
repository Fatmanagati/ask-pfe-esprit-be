package com.ask.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
