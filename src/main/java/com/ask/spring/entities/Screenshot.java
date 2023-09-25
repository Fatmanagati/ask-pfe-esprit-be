package com.ask.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Screenshot {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idScreenshot;
	private String nameScreen;
	
	@ManyToOne
	Question question; 
	
	@ManyToOne
	Answer answer;

}
