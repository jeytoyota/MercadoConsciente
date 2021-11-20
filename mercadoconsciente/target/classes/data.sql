CREATE TABLE DOADOR(
	id bigint PRIMARY KEY auto_increment,
	cnpj varchar(18),
	razao varchar(100),
	logradouro varchar(100),
	telefone varchar(15),
	email varchar(60),
	senha varchar(200),
	admin varchar(10)
);

CREATE TABLE RECEPTOR(
	id bigint PRIMARY KEY auto_increment,
	cnpj varchar(18),
	razao varchar(100),
	logradouro varchar(100),
	telefone varchar(15),
	email varchar(60),
	senha varchar(200),
	admin varchar(10)
);

CREATE TABLE ALIMENTO(
	id bigint PRIMARY KEY auto_increment,
	nome varchar(30),
	quantidade decimal,
	doador_id int
);

INSERT INTO DOADOR (cnpj, razao, logradouro, telefone, email, senha, admin) VALUES
	('90.451.733/0001-35', 'Rapeizez Bar', 'Avenida estado capital', '(11) 1222-1234', 'rapeizez@email.com', '$2a$10$70BffoBdmtX/geGX/Og7VurVUIIdkZFSeRJjjTWIooIBqbn9Qe23e', 'admin'),
	('76.630.617/0001-52', 'Ruivos Burguer', 'Avenida cidade país', '(11) 0359-2089', 'mateus@email.com', '$2a$10$70BffoBdmtX/geGX/Og7VurVUIIdkZFSeRJjjTWIooIBqbn9Qe23e', 'admin');
	
INSERT INTO RECEPTOR (cnpj, razao, logradouro, telefone, email, senha, admin) VALUES
	('01.000.433/0001-00', 'Centro Beneficente', 'Rua azul vermelho', '(11) 1632-6542', 'centro@email.com', '$2a$10$70BffoBdmtX/geGX/Og7VurVUIIdkZFSeRJjjTWIooIBqbn9Qe23e', 'normal'),
	('22.143.162/0001-11', 'Igreja Beneficente', 'Rodovia copo com leite', '(11) 5126-7569', 'igreja@email.com', '$2a$10$70BffoBdmtX/geGX/Og7VurVUIIdkZFSeRJjjTWIooIBqbn9Qe23e', 'admin');
	
INSERT INTO ALIMENTO (nome, quantidade, doador_id) VALUES
	('Banana', 50.5, 1),
	('Batata', 100, 1),
	('Arroz', 82, 2);