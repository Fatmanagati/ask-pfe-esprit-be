package com.ask.spring.iservices;

import java.util.List;

import com.ask.spring.entities.Technology;

public interface ITechnologyService {

	public Technology addTechnology(Technology t);
	public Technology updateTechnology(Technology t,Long id);
	public void deleteTechnology(Long id);
	public List<Technology> getTechnologies();
	
}
