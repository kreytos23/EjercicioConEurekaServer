package com.example.ibm.ejemplo.services;

import java.util.List;
import java.util.Optional;

import com.example.ibm.ejemplo.models.Persona;

public interface IHttpConsumes {
	
	List<Persona> sendGet();
	Optional<List<Persona>> sendGetById(Long Id);
	Persona sendPost(Persona persona);
	void sendPut(Long id, int edad);
	boolean sendDelete(Long id);
	

}
