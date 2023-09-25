package com.ask.spring.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Departement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idDepartement;
	private String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="departement")
	@JsonIgnore
	public List<User> users;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="departement")
	@JsonIgnore
	public List<Question> questions;
}
