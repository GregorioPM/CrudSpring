package co.edu.ufps.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.demo.model.Persona;

@Repository
public interface PersonaDao extends CrudRepository<Persona, Long> {

}
