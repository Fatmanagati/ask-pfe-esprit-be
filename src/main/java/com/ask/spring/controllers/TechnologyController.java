package com.ask.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ask.spring.entities.Technology;
import com.ask.spring.iservices.ITechnologyService;

@RestController
@RequestMapping("/technology")
@CrossOrigin(origins="http://localhost:4200")
public class TechnologyController {
	
	@Autowired
	ITechnologyService techrepo;
	
	//http://localhost:8080/PFE/tech/add
	@PostMapping("/add")
	public Technology addTechnology(@RequestBody Technology t){
		return techrepo.addTechnology(t);
	}
	//http://localhost:8080/PFE/tech/update
	@PutMapping("/update/{id}")
	public Technology updateTechnology(@RequestBody Technology t,@PathVariable("id")Long id){
		return techrepo.updateTechnology(t,id);
	}
	
	//http://localhost:8080/PFE/tech/getall
	@GetMapping("/getall")
	public List<Technology> technologies(){
		return techrepo.getTechnologies();
	}
	
	//http://localhost:8080/PFE/tech/delete/{id}
	@DeleteMapping("/delete/{id}")
	public void deleteTechnology(@PathVariable("id")Long id){
		techrepo.deleteTechnology(id);
	}
}
