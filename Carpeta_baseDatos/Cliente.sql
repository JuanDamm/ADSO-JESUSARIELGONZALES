UPDATE producto SET deleted_at=now() WHERE id = 1;
	
-- Consultar todos los registros físcos
SELECT 
	id,
	codigo,
	nombre,
	precio,
	cantidad,
	state,
	created_at,
	updated_at,
	deleted_at
FROM  
	producto;
	
-- Consultar todos los registro lógicos
SELECT 
	id,
	codigo,
	nombre,
	precio,
	cantidad,
	state,
	created_at,
	updated_at,
	deleted_at
FROM  
	producto
WHERE deleted_at is null;