package com.ask.spring.iservices;

import java.util.List;

import com.ask.spring.entities.Departement;

public interface IDepartementService {
	
	public void addDepartement(Departement d);
	public List<Departement> getallDepartments();
	public void deleteDepartement(Long id );

}
