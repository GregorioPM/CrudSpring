package co.edu.ufps.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.edu.ufps.demo.dao.GenericImpl;
import co.edu.ufps.demo.dao.PersonaDao;
import co.edu.ufps.demo.model.Persona;
import co.edu.ufps.demo.service.PersonaService;

@Service
public class PersonaServiceImpl extends GenericImpl<Persona, Long> implements PersonaService {
	
	@Autowired
	private PersonaDao personaDao;
	@Override
	public CrudRepository<Persona, Long> getDao(){
		return personaDao;
	}
	
}
