package com.ask.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.Departement;
import com.ask.spring.iservices.IDepartementService;
import com.ask.spring.repositories.DepartmentRepository;

@Service
public class DepartmentService implements IDepartementService{
	@Autowired 
	DepartmentRepository deprepo;

	@Override
	public void addDepartement(Departement d) {
		deprepo.save(d);
		
	}

	@Override
	public List<Departement> getallDepartments() {
		// TODO Auto-generated method stub
		return deprepo.findAll();
	}

	@Override
	public void deleteDepartement(Long id) {
		deprepo.deleteById(id);
		
	}

}
