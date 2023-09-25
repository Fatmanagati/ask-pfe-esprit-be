package com.ask.spring.controllers;

import java.util.List;

import javax.decorator.Delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ask.spring.entities.Departement;
import com.ask.spring.services.DepartmentService;

@RestController
@RequestMapping("/departement")
@CrossOrigin(origins="http://localhost:4200")
public class DepartementController {
	
	@Autowired
	DepartmentService depserv;
	
	@PostMapping("/add")
	public void addDepartement(@RequestBody Departement d){
		depserv.addDepartement(d);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteDepartment(@PathVariable("id")Long id){
		depserv.deleteDepartement(id);
	}
	
	@GetMapping("/getall")
	public List<Departement> getallDepartments(){
		return depserv.getallDepartments();
	}

}
