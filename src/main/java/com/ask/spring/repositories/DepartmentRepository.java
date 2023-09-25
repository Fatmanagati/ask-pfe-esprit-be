package com.ask.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ask.spring.entities.Departement;
@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Long>{



}
