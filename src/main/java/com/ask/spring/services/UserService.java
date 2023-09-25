package com.ask.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.Departement;
import com.ask.spring.entities.User;
import com.ask.spring.iservices.IUserService;
import com.ask.spring.repositories.DepartmentRepository;
import com.ask.spring.repositories.UserRepository;


@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userepo;
	@Autowired
	DepartmentRepository deprepo;
	@Autowired
	EmailSenderService eService; 
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userepo.save(u) ;
	}

	@Override
	public User updateUser(User u,Long id) {
		// TODO Auto-generated method stub
		User uu=userepo.findById(id).get();
		uu.setEmail(u.getEmail());
		uu.setPassword(u.getPassword());
		uu.setRole(u.getRole());
		uu.setUsername(u.getUsername());
		return userepo.save(u);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userepo.deleteById(id);
		
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userepo.findById(id).get();
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userepo.findAll();
	}

	@Override
	public User findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userepo.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userepo.findByUsername(username);
		if (userEntity == null) throw new UsernameNotFoundException(username);
		
		return new  org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(), true,true,
				true, true,
				new ArrayList<>());
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userepo.findUserByUsername(username);
	}

	@Override
	public User addUserdep(User u, Long iddep) {
			Departement d=deprepo.findById(iddep).get();
			u.setDepartement(d);
		
			d.users.add(u);
			eService.sendSimpleEmail(u.getEmail(), "*** Welcome to WeCare ***  \n" + "Your Username :    "
					+ u.getUsername() + "\nYour Password :    " + u.getCpassword(), "Welcome To WeCare");
			return userepo.save(u);
		}
	

}
