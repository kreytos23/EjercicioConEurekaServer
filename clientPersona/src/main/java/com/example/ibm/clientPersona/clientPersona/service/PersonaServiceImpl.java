package com.example.ibm.clientPersona.clientPersona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ibm.clientPersona.clientPersona.feign.PersonaFeign;
import com.example.ibm.clientPersona.clientPersona.model.Persona;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonaServiceImpl implements PersonaService{
	@Autowired
	PersonaFeign personaFeign;
	
	@Override
	public List<Persona> getPersonas() {
		return personaFeign.getResponseGet();
	}

	@Override
	public String savePersona(Persona persona) {
		return personaFeign.getResponsePost(persona);
	}

	@Override
	public String updatePersona(Persona persona) {
		return personaFeign.getResponsePut(persona);
	}

	@Override
	public String deletePersona(int id) {
		return personaFeign.getResponseDelete(id);
	}

}
