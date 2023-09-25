package com.ask.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.Screenshot;

@Repository
public interface ScreenshotRepository extends CrudRepository<Screenshot, Long> {

}
