package com.example.ibm.clientPersona.clientPersona.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ibm.clientPersona.clientPersona.model.Persona;

@FeignClient("${feign.client.persons.name}")
@RequestMapping("${feign.client.persons.uri}")
public interface PersonaFeign {
	
	@GetMapping("${feign.client.persons.get}")
	public List<Persona> getResponseGet();
	
	@PostMapping("${feign.client.persons.post}")
	public String getResponsePost(@RequestBody Persona persona);
	
	@PutMapping("${feign.client.persons.put}")
	public String getResponsePut(@RequestBody Persona persona);
	
	@DeleteMapping(value="${feign.client.persons.delete}", params="id")
	public String getResponseDelete(@RequestParam int id);
}
