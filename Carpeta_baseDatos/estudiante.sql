CREATE database IF NOT EXISTS estudiantes;


use estudiantes;

CREATE TABLE estudiante (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_estudiante VARCHAR(20) NOT NULL,
    apellido_estudiante VARCHAR(50) NOT NULL,
    tarjeta_identidad BIGINT NOT NULL,
    cumpleaños DATETIME,
    email VARCHAR(100) NOT NULL,
    state BIT NOT NULL DEFAULT 1,
    deleted_at DATETIME,
    updated_at DATETIME,
    created_at DATETIME
);

CREATE TABLE materia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_materia VARCHAR(20) NOT NULL,
    codigo_materia VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    hora_materia INT,
    state BIT NOT NULL DEFAULT 1,
    deleted_at DATETIME,
    updated_at DATETIME,
    created_at DATETIME
);

CREATE TABLE matricula (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(6) NOT NULL,
    nota DECIMAL(10,2),
    observacion VARCHAR(200) NOT NULL,
    estado BIT DEFAULT 1,
    materia_id INT,
    estudiante_id INT,
    FOREIGN KEY (materia_id) REFERENCES materia(id),
    FOREIGN KEY (estudiante_id) REFERENCES estudiante(id)
);

INSERT INTO estudiante (nombre_estudiante, apellido_estudiante, tarjeta_identidad, cumpleaños, email)
VALUES
    ('Juan', 'Rodolfo', 123456789, '2003-05-20', 'juan.rodolfo@email.com'),
    ('Ana', 'Gomez', 987654321, '2001-08-15', 'ana.gomez@email.com'),
    ('Carlos', 'Hitler', 456789012, '1999-02-10', 'carlos.hitler@email.com');


INSERT INTO materia (nombre_materia, codigo_materia, descripcion, hora_materia)
VALUES
    ('Matemáticas', 'MAT101', 'Curso de matemáticas básicas', 8),
    ('Historia', 'HIS201', 'Curso de historia general', 6),
    ('Programación', 'PROG301', 'Introducción a la programación', 10);


INSERT INTO matricula (codigo, materia_id, estudiante_id, nota, observacion)
VALUES
    ('MAT002', 2, 1, 4.5, 'Aprobado con excelencia'),
    ('PROG302', 3, 2, 3.7, 'Aprobado'),
    ('MAT003', 1, 3, NULL, 'En curso');

    
    
    

select * from estudiante;
select * from materia;
select * from matricula;
SELECT e.nombre_estudiante, m.nombre_materia, ma.nota
FROM estudiante e
INNER JOIN matricula ma ON e.id = ma.estudiante_id
INNER JOIN materia m ON ma.materia_id = m.id
WHERE ma.nota IS NOT NULL;


