package com.example.ibm.ejemplo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.google.inject.internal.cglib.core.$ClassNameReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ibm.ejemplo.daos.IPersonaDao;
import com.example.ibm.ejemplo.models.Persona;

@Service
public class IHttpConsumesImpl implements IHttpConsumes {
	@Autowired IPersonaDao personaDao;

	@Override
	public List<Persona> sendGet() {
		return personaDao.getPersonas();
	}

	@Override
	public Optional<List<Persona>> sendGetById(Long Id) {
		return Optional.of(personaDao.getPersonaById(Id));
	}

	@Override
	public Persona sendPost(Persona persona) {
		personaDao.save(persona);
		return persona;
	}

	@Override
	public void sendPut(Long id, int edad) {
		personaDao.actualizar(id, edad);
	}

	@Override
	public boolean sendDelete(Long id) {
		return sendGetById(id).filter(Predicate.not(List::isEmpty))
		.map(personas -> {
			personaDao.eliminar(id);
			return true;
		}).orElse(false);
	}

}
