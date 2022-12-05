package mx.com.gm.services;

import java.util.List;

import mx.com.gm.domain.Persona;

public interface PersonaService {
	public List<Persona> listaPersonas();
	public void guardar(Persona persona);
	public void eliminar(Persona persona);
	public Persona encontrarPersona(Persona persona);
}
