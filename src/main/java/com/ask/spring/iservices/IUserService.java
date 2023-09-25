package com.ask.spring.iservices;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ask.spring.entities.User;

public interface IUserService extends UserDetailsService
{

	public User addUser(User u );
	public User updateUser(User u,Long id);
	public void deleteUser(Long id);
	public User getUser(Long id );
	public User getUser(String username );
	public List<User> getUsers();
	public User findUserByUserName(String userName);
	public User addUserdep(User u , Long iddep);
}
