-- 1. Criação do Banco de Dados
CREATE DATABASE locadora_db;
USE locadora_db;

-- 2. Criação das Tabelas
CREATE TABLE carros(
 	id INT AUTO_INCREMENT PRIMARY KEY,
	marca VARCHAR(30) NOT NULL,
 	modelo VARCHAR(30) NOT NULL,
 	placa VARCHAR(10) NOT NULL UNIQUE,
 	valor_diaria DECIMAL(10, 2) NOT NULL,
 	ano_de_lancamento INT NOT NULL,
 	disponivel BOOLEAN DEFAULT true 
);

CREATE TABLE clientes(
 	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
 	cpf VARCHAR(14) NOT NULL UNIQUE,
 	idade INT NOT NULL,
 	tempo_aluguel_dias INT NOT NULL,
 	telefone VARCHAR(20)
);

CREATE TABLE alugueis (
	id INT AUTO_INCREMENT PRIMARY KEY,
	cliente_id INT NOT NULL,
	carro_id INT NOT NULL,
	data_de_inicio DATE NOT NULL,
	data_de_fim DATE NOT NULL,
	valor_total DECIMAL(10, 2) NOT NULL,
	-- Restrição de Chave Estrangeira
	CONSTRAINT fk_alugueis_clientes FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_alugueis_carros FOREIGN KEY (carro_id) REFERENCES carros(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 3. Inserção de dados
INSERT INTO carros(marca, modelo, placa, valor_diaria, ano_de_lancamento, disponivel) 
VALUES 
('Chevrolet', 'Onix', 'ABC-1234', 110.00, 2022, TRUE),
('Honda', 'Civic', 'XYZ-5678', 240.00, 2021, TRUE),
('Toyota', 'Corolla', 'JKL-9876', 280.00, 2023, FALSE),
('Hyundai', 'HB20', 'MNO-1122', 95.00, 2020, TRUE),
('Renault', 'Kwid', 'PQR-3344', 80.00, 2022, TRUE),
('Jeep', 'Compass', 'STU-5566', 320.00, 2023, TRUE),
('Volkswagen', 'Gol', 'VWX-7788', 90.00, 2018, FALSE),
('Toyota', 'Corolla Cross', 'YZA-9900', 290.00, 2024, TRUE),
('Chevrolet', 'Tracker', 'BCD-2468', 190.00, 2022, TRUE),
('Honda', 'City', 'EFG-1357', 210.00, 2023, TRUE);

INSERT INTO clientes(nome, cpf, idade, tempo_aluguel_dias, telefone) 
VALUES 
('Carlos Silva', '123.456.789-01', 28, 5, '(11) 98765-4321'),
('Ana Souza', '987.654.321-09', 34, 3, '(21) 91234-5678'),
('Marcos Oliveira', '111.222.333-44', 42, 7, '(31) 99888-7766'),
('Juliana Costa', '222.333.444-55', 25, 2, '(41) 97777-6655'),
('Lucas Pereira', '333.444.555-66', 30, 10, '(51) 96666-5544'),
('Beatriz Lima', '444.555.666-77', 22, 4, '(61) 95555-4433'),
('Gabriel Santos', '555.666.777-88', 45, 15, '(71) 94444-3322'),
('Camila Rocha', '666.777.888-99', 29, 1, '(81) 93333-2211'),
('Roberto Dias', '777.888.999-00', 51, 7, '(91) 92222-1100'),
('Fernanda Mendes', '888.999.000-11', 38, 5, '(31) 91111-0099');

INSERT INTO alugueis(cliente_id, carro_id, data_de_inicio, data_de_fim, valor_total) 
VALUES (1, 8, '2026-05-15', '2026-05-20', 1450.00);

-- 4. Consultas comuns (SELECT)
SELECT * FROM carros WHERE valor_diaria BETWEEN 200.00 AND 300.00;

SELECT * FROM carros WHERE marca = 'Honda' OR marca = 'Renault';
SELECT * FROM carros WHERE marca IN ('Honda', 'Renault');

SELECT * FROM carros ORDER BY valor_diaria DESC;

SELECT * FROM carros WHERE marca LIKE '%A%';

-- 5. Atualização de dados (UPDATE)
UPDATE clientes SET id = 1 WHERE id = 20;

-- 6. Apagar dados (DELETE)
DELETE FROM clientes WHERE id = 99;

-- 7. Consultas com INNER JOIN
SELECT 
	alugueis.id,
	clientes.nome,
	clientes.cpf,
	clientes.telefone,
	carros.modelo,
	alugueis.data_de_inicio,
	alugueis.data_de_fim 
FROM alugueis
INNER JOIN clientes ON cliente_id = clientes.id
INNER JOIN carros ON carro_id = carros.id;

SELECT 
	a.id AS contrato_num,
	c.nome AS cliente,
	c.cpf,
	c.telefone,
	v.modelo AS carro,
	a.data_de_inicio,
	a.data_de_fim 
FROM alugueis a
INNER JOIN clientes c ON cliente_id = c.id
INNER JOIN carros v ON carro_id = v.id;
