package co.edu.ufps.demo.dao;

import org.springframework.data.repository.CrudRepository;

import co.edu.ufps.demo.model.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}
