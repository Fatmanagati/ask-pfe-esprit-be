package com.ask.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.Technology;
import com.ask.spring.iservices.ITechnologyService;
import com.ask.spring.repositories.TechnologyRepository;

@Service
public class TechnologyService implements ITechnologyService{

	@Autowired
	TechnologyRepository techrepo;
	
	@Override
	public Technology addTechnology(Technology t) {
		// TODO Auto-generated method stub
		return techrepo.save(t);
	}

	@Override
	public Technology updateTechnology(Technology t,Long id) {
		// TODO Auto-generated method stub
		Technology tt=techrepo.findById(id).get();
		tt.setName(t.getName());
		return techrepo.save(tt);
	}

	@Override
	public void deleteTechnology(Long id) {
		// TODO Auto-generated method stub
		techrepo.deleteById(id);
		
	}

	@Override
	public List<Technology> getTechnologies() {
		// TODO Auto-generated method stub
		return (List<Technology>) techrepo.findAll();
	}

}
