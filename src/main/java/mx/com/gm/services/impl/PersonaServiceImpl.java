package mx.com.gm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;
import mx.com.gm.services.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listaPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional()
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional()
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		return personaDao.findById(persona.getId()).orElse(null);
	}

}
