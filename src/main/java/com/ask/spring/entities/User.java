package com.ask.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String username;
	private String password;
	private String cpassword;
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	public List<Question> questions;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<Answer> answers;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "departement_id")
	Departement departement;
	

}
