select * from estudiante;
select * from materia;
select * from matricula;
SELECT e.nombre_estudiante, m.nombre_materia, ma.nota
FROM estudiante e
INNER JOIN matricula ma ON e.id = ma.estudiante_id
INNER JOIN materia m ON ma.materia_id = m.id
WHERE ma.nota IS NOT NULL;