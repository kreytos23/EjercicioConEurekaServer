package com.example.ibm.clientPersona.clientPersona.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Persona {
	private Long personaID;
	private String nombre;
	private int	edad;
	
	/* public Persona() {}

	public Persona(Long personaID, String nombre, int edad) {
		super();
		this.personaID = personaID;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Long getPersonaID() {
		return personaID;
	}

	public void setPersonaID(Long personaID) {
		this.personaID = personaID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}*/
	
}
