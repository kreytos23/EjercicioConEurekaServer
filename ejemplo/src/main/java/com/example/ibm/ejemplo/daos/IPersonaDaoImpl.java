package com.example.ibm.ejemplo.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ibm.ejemplo.models.Persona;

@Repository
public class IPersonaDaoImpl implements IPersonaDao {
	@Autowired JdbcTemplate template;

	@Override
	public void save(Persona persona) {
		String query = "INSERT INTO Personas (NOMBRE, EDAD) VALUES (?, ?)";
		this.template.update(query, persona.getNombre(), persona.getEdad());
	}

	@Override
	public List<Persona> getPersonas() {
    	String query = "SELECT * FROM Personas";

        return this.template.query(query, new RowMapper<Persona>() {
            public Persona mapRow(ResultSet rs, int i) throws SQLException {
                Persona persona = new Persona();
                persona.setPersonaID(rs.getLong("PERSONA_ID"));
                persona.setNombre(rs.getString("NOMBRE"));
                persona.setEdad(rs.getInt("EDAD"));
				return persona;
            }
        });
	}

	@Override
	public List<Persona> getPersonaById(Long Id) {
		String query = "SELECT * FROM Personas WHERE PERSONA_ID = ?";

		return this.template.query(query, (rs, i) -> {
			Persona persona = new Persona();
			persona.setPersonaID(rs.getLong("PERSONA_ID"));
			persona.setNombre(rs.getString("NOMBRE"));
			persona.setEdad(rs.getInt("EDAD"));
			return persona;
		}, Id);
	}

	@Override
	public void actualizar(Long id, int edad) {
		String query = "UPDATE PERSONAS SET EDAD = ? where PERSONA_ID = ?";
        this.template.update(query, edad, id);
	}

	@Override
	public int eliminar(Long id) {
		String query = "DELETE FROM PERSONAS WHERE PERSONA_ID = ?";
        return this.template.update(query, id);
	}

}
