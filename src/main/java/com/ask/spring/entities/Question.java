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
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQuestion;
	private String text;
	private String title;
	private Long nbAnswers;
	private Date dateQuestion;
	private Long nbViews;
	private String[] nameuserView;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="question")
	@JsonIgnore
	public List<Answer> answers;
	
	@ManyToOne
	Departement departement;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Technology technology;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="question")
	@JsonIgnore
	public List<Screenshot> screenshots;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="question")
	@JsonIgnore
	public List<Comment> comments;
}
