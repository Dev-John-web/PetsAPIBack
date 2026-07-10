CREATE DATABASE petshop;

USE petshop;

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE pet (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    tipo VARCHAR(50),
    raca VARCHAR(50),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco DECIMAL(10,2)
);

CREATE TABLE agendamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME,
    pet_id BIGINT,
    servico_id BIGINT,
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (servico_id) REFERENCES servico(id)
);