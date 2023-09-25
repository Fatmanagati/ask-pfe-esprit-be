package com.ask.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);
	 User findUserByUsername(String userName);

}
