package com.example.ibm.clientPersona.clientPersona.service;

import java.util.List;

import com.example.ibm.clientPersona.clientPersona.model.Persona;

public interface PersonaService {
	List<Persona> getPersonas();
	String savePersona(Persona persona);
	String updatePersona(Persona persona);
	String deletePersona(int id);
}
