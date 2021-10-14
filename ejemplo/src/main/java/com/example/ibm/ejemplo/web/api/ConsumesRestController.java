package com.example.ibm.ejemplo.web.api;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ibm.ejemplo.mapping.Mapping;
import com.example.ibm.ejemplo.models.Persona;
import com.example.ibm.ejemplo.services.IHttpConsumes;

import javax.validation.Valid;

@RestController
@RequestMapping(Mapping.ACADEMIA)
public class ConsumesRestController {

	@Autowired
	IHttpConsumes httpConsumes;
	
	@GetMapping("/get-persons")
	public ResponseEntity<List<Persona>> getPersonas() {
	    return new ResponseEntity<>(httpConsumes.sendGet(), HttpStatus.OK) ;
	}

	@GetMapping(value="/get-personsById/{id}")
	public ResponseEntity<List<Persona>> getPersonasById(@PathVariable("id") Long id) {
		return httpConsumes.sendGetById(id).filter(Predicate.not(List::isEmpty))
				.map(personas -> new ResponseEntity<>(personas, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save-person")
	public ResponseEntity<Persona> savePersona(@RequestBody @Valid  Persona persona) {
		return new ResponseEntity<>(httpConsumes.sendPost(persona),HttpStatus.CREATED);
	}
	
	@PutMapping("/update-person")
	public ResponseEntity updatePersona(@RequestBody Persona persona) {
		httpConsumes.sendPut(new Long(1), persona.getEdad());
		return new ResponseEntity( HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete-person", params="id")
	public ResponseEntity deletePersona(@RequestParam int id) {
		return httpConsumes.sendDelete(new Long(id)) ?
				new ResponseEntity(HttpStatus.ACCEPTED) :
				new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
