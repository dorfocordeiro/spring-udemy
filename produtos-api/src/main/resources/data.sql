CREATE TABLE produto (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco NUMERIC(10, 2)
);