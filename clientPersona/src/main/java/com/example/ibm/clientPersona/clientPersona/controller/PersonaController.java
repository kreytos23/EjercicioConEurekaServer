package com.example.ibm.clientPersona.clientPersona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ibm.clientPersona.clientPersona.model.Persona;
import com.example.ibm.clientPersona.clientPersona.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/obtener-personas")
	public List<Persona> getPersonas(){
		return personaService.getPersonas();
	}
	
	@PostMapping("/agregar-persona")
	public String savePersona(@RequestBody Persona persona) {
		return personaService.savePersona(persona);
	}
	
	@PutMapping("/actualizar-persona")
	public String actualizarPersona(@RequestBody Persona persona) {
		return personaService.updatePersona(persona);
	}
	
	@DeleteMapping(value = "/eliminar-persona", params = "id")
	public String eliminarPersona(@RequestParam int id) {
		return personaService.deletePersona(id);
	}
	
}
