package com.ask.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ask.spring.entities.Departement;
import com.ask.spring.entities.User;
import com.ask.spring.iservices.IUserService;
import com.ask.spring.repositories.DepartmentRepository;
import com.ask.spring.repositories.UserRepository;
import com.ask.spring.response.ResponseHandler;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	IUserService userv;
	
	@Autowired 
	UserRepository userepo;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//http://localhost:8080/PFE/user/add
	@PostMapping("/add")
	public  ResponseEntity<Object>  addUser(@RequestBody User u,HttpServletRequest request){
		User u1 = userepo.findByUsername(u.getUsername());
		if (u1 == null) {
			System.out.println("test1");
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			User a = userv.addUser(u);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, a);
		} else {
			System.out.println("test2");
			return ResponseHandler.generateResponse("UserName already exists", HttpStatus.MULTI_STATUS,
					"UserName already exists");
		}
	}
	
	@PostMapping("/addep/{id}")
	public ResponseEntity<Object> addUserrrr(@Valid @PathVariable("id") Long id, @RequestBody User u, HttpServletRequest request) {
	    User u1 = userepo.findByUsername(u.getUsername());
	    if (u1 == null) {
	        Departement department = departmentRepository.findById(id).orElse(null);
	        if (department != null) {
	            u.setDepartement(department);
	            u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
	            User a = userv.addUserdep(u, department.getIdDepartement()); // Ajouter l'ID du département lors de l'appel de la méthode addUser()
	            
	            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, a);
	        } else {
	            return ResponseHandler.generateResponse("Department not found", HttpStatus.NOT_FOUND, "Department not found");
	        }
	    } else {
	        return ResponseHandler.generateResponse("UserName already exists", HttpStatus.MULTI_STATUS, "UserName already exists");
	    }
	}

	//http://localhost:8080/PFE/user/update
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User u,@PathVariable("id")Long id){
		return userv.updateUser(u,id);
	}
	
	//http://localhost:8080/PFE/user/delete/{id}
	 @DeleteMapping("/delete/{id}")
	 public void deleteUser(@PathVariable("id")Long id ){
		 userv.deleteUser(id);
	 }
	 
	//http://localhost:8080/PFE/user/getbyid/{id}
	  @GetMapping("/getbyid/{id}")
	  public User getUser(@PathVariable("id")Long id){
		  return userv.getUser(id);
	  }
	  
	//http://localhost:8080/PFE/user/getall
	  @GetMapping("/getall")
	  public List<User> getUsers(){
		  return userv.getUsers();
	  }

}
