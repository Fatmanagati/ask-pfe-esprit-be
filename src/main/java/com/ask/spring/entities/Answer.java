package com.ask.spring.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAnswer;
	private String text;
	private boolean resolved;
	private Date dateAswer;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Question question;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="answer")
	@JsonIgnore
	public List<Comment> comments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="answer")
	@JsonIgnore
	public List<Screenshot> screenshots;

}
