package com.example.ibm.ejemplo.daos;

import java.util.List;

import com.example.ibm.ejemplo.models.Persona;

public interface IPersonaDao {

	public void save(Persona persona);
	public List<Persona> getPersonas();
	public List<Persona> getPersonaById(Long Id);
	public void actualizar(Long id, int edad);
	public int eliminar(Long id);
}
