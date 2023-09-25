package com.ask.spring.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ask.spring.entities.User;
import com.ask.spring.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      User user = userRepository.findByUserName(username);
//        System.out.println(username);
//        System.out.println("testestestesttest");
//
//        final List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole()));
//
//        return  new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
//    }
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException(username);
		
		return new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,true,
				true, true,
				new ArrayList<>());
		
		//return new User(userEntity.getEmail(), userEntity.getEncryptedPaswword() , new ArrayList<>());
	}

}
