DROP TABLE IF EXISTS Personas;

CREATE TABLE Personas (
    personaId BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    edad INT NOT NULL
);

INSERT INTO Personas (nombre, edad) VALUES ('cesar', 20);