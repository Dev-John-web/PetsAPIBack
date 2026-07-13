-- Criar banco
CREATE DATABASE IF NOT EXISTS petshop;

-- Usar banco
USE petshop;

-- =========================
-- TABELA CLIENTE
-- =========================
CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100)
);

-- =========================
-- TABELA PET
-- =========================
CREATE TABLE IF NOT EXISTS pet (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    tipo VARCHAR(50),
    raca VARCHAR(50),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- =========================
-- TABELA SERVICO
-- =========================
CREATE TABLE IF NOT EXISTS servico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco DECIMAL(10,2)
);

-- =========================
-- TABELA AGENDAMENTO
-- =========================
CREATE TABLE IF NOT EXISTS agendamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME,
    pet_id BIGINT,
    servico_id BIGINT,
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (servico_id) REFERENCES servico(id)
);

-- =========================
-- INSERINDO CLIENTES
-- =========================
INSERT INTO cliente (nome, telefone, email) VALUES
('João Silva', '21999990001', 'joao@email.com'),
('Maria Souza', '21999990002', 'maria@email.com'),
('Carlos Pereira', '21999990003', 'carlos@email.com'),
('Ana Costa', '21999990004', 'ana@email.com');

-- =========================
-- INSERINDO PETS
-- =========================
INSERT INTO pet (nome, tipo, raca, cliente_id) VALUES
('Rex', 'Cachorro', 'Labrador', 1),
('Mimi', 'Gato', 'Siamês', 2),
('Thor', 'Cachorro', 'Bulldog', 1),
('Luna', 'Gato', 'Persa', 3),
('Bob', 'Cachorro', 'Poodle', 4);

-- =========================
-- INSERINDO SERVIÇOS
-- =========================
INSERT INTO servico (nome, preco) VALUES
('Banho', 50.00),
('Tosa', 70.00),
('Consulta Veterinária', 120.00),
('Vacinação', 90.00);

-- =========================
-- INSERINDO AGENDAMENTOS
-- =========================
INSERT INTO agendamento (data_hora, pet_id, servico_id) VALUES
('2026-07-15 10:00:00', 1, 1),
('2026-07-15 11:00:00', 2, 2),
('2026-07-16 09:30:00', 3, 3),
('2026-07-16 14:00:00', 4, 1),
('2026-07-17 16:00:00', 5, 4);