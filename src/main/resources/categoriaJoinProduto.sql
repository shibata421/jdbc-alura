SELECT 	
	c.id AS id, 
	c.nome AS categoria, 
	p.nome AS nome, 
	p.descricao AS descricao 
FROM categoria AS c 
JOIN produto AS p 
ON c.id = p.categoria_id;