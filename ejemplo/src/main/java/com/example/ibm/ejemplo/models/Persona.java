package com.example.ibm.ejemplo.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personaId;

	@NotNull(message = "No debe ser nulo el nombre")
	@NotBlank(message = "No debe estar vacio el nombre")
	private String nombre;

	@NotNull(message = "No debe ser nulo la edad")
	@Min(value = 18)
	private Integer	edad;

	public Persona() {};

	public Persona(Long personaId, String nombre, Integer edad) {
		super();
		this.personaId = personaId;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Long getPersonaID() {
		return personaId;
	}

	public void setPersonaID(Long personaId) {
		this.personaId = personaId;
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

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [personaID=" + personaId + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
}
