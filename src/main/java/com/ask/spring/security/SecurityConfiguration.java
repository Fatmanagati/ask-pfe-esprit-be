package com.ask.spring.security;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ask.spring.services.MyUserDetailsService;




@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final MyUserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public SecurityConfiguration(MyUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.cors().and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll();
		http.csrf().disable().authorizeRequests()
		.antMatchers("/user/add").permitAll()
//		.antMatchers("/admin").permitAll()
//		.antMatchers("/forum/**").permitAll()
//		.antMatchers("/cagnotte/**").permitAll()
//		.antMatchers("/donation/**").permitAll()
//		.antMatchers("/drawal/**").permitAll()
		//.antMatchers(HttpMethod.POST , //url)
		//.permitAll()
		.anyRequest().authenticated() //sign up authorized be9i lkol le
		.and()
		.addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager())) //lkool lezem iconectiw ken sign up
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // bch nkoulou l spring security eli rest api te3na lezem ikounou stateless
				// maghir matsir http session
	
	
	}
	
		@Override
		public void configure (AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); //tkolou anehi interface taa service eli theb testaamlha o bch tnjm taaml authentication
		}
		
		public AuthenticationFilter getAuthenticationFilter() throws Exception {
			final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
			filter.setFilterProcessesUrl("/user/login");
			return filter;
		}  //bch tbadel url taa login
	
	
	
	
	

}
