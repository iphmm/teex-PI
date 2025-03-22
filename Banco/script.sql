CREATE SCHEMA `sistemaestoque` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE SistemaEstoque;

CREATE TABLE produto (
id_produto INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
descricao TEXT,
preco_custo DECIMAL(10,2),
preco_venda DECIMAL(10,2),
codigo_barras VARCHAR(50) UNIQUE NOT NULL,
id_categoria INT NOT NULL,
id_fornecedor INT NOT NULL,
data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id_fornecedor)
);

CREATE TABLE categoria (
id_categoria INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255) UNIQUE,
descricao TEXT
);

CREATE TABLE fornecedor (
id_fornecedor INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
cnpj VARCHAR(18) UNIQUE,
telefone VARCHAR(20),
email VARCHAR(255),
data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tipo_movimentacao (
id_tipo INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(50) UNIQUE
);

CREATE TABLE movimentacao (
id_movimentacao INT PRIMARY KEY AUTO_INCREMENT,
id_produto INT NOT NULL,
id_tipo INT NOT NULL,
id_usuario INT NOT NULL,
quantidade INT CHECK (quantidade > 0),
preco_unitario DECIMAL(10,2),
data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
FOREIGN KEY (id_tipo) REFERENCES tipo_movimentacao(id_tipo),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
observacao TEXT
);

CREATE TABLE usuario (
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
email VARCHAR(255) UNIQUE,
senha_hash TEXT,
perfil VARCHAR(50) NOT NULL CHECK (perfil IN ('Admin', 'Operador')), 
status_usuario BOOLEAN DEFAULT TRUE,
data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- TESTES DO BANCO:

-- DADOS
-- Inserindo categorias
INSERT INTO categoria (nome, descricao) VALUES 
('Eletrônicos', 'Produtos eletrônicos em geral'),
('Alimentos', 'Produtos alimentícios');

-- Inserindo fornecedores
INSERT INTO fornecedor (nome, cnpj, telefone, email) VALUES 
('TechSupply', '12.345.678/0001-99', '11999999999', 'contato@techsupply.com'),
('FoodSupplier', '98.765.432/0001-55', '11888888888', 'contato@foodsupplier.com');

-- Inserindo tipos de movimentação
INSERT INTO tipo_movimentacao (descricao) VALUES 
('Entrada'),
('Saída');

-- Inserindo usuários
INSERT INTO usuario (nome, email, senha_hash, perfil) VALUES 
('Admin User', 'admin@email.com', 'hashed_password_123', 'Admin'),
('Operador User', 'operador@email.com', 'hashed_password_456', 'Operador');

INSERT INTO produto (nome, descricao, preco_custo, preco_venda, codigo_barras, id_categoria, id_fornecedor) VALUES 
('Notebook Dell', 'Notebook i7 com 16GB RAM', 3500.00, 4500.00, '1234567890123', 1, 1),
('Arroz 5kg', 'Pacote de arroz tipo 1', 10.00, 15.00, '9876543210987', 2, 2);

-- MOVIMENTAÇÕES 
-- Entrada de produtos (estoque recebendo itens)
INSERT INTO movimentacao (id_produto, id_tipo, id_usuario, quantidade, preco_unitario, observacao) VALUES 
(1, 1, 1, 10, 4500.00, 'Compra de notebooks para estoque'),
(2, 1, 2, 50, 15.00, 'Compra de arroz para revenda');

-- Saída de produtos (venda ou uso interno)
INSERT INTO movimentacao (id_produto, id_tipo, id_usuario, quantidade, preco_unitario, observacao) VALUES 
(1, 2, 2, 2, 4500.00, 'Venda de 2 notebooks'),
(2, 2, 1, 5, 15.00, 'Venda de 5 pacotes de arroz');

-- CONSULTAS
-- produtos e suas categorias:

SELECT p.nome AS Produto, p.preco_venda, c.nome AS Categoria, f.nome AS Fornecedor
FROM produto p
JOIN categoria c ON p.id_categoria = c.id_categoria
JOIN fornecedor f ON p.id_fornecedor = f.id_fornecedor;

-- historico de movimentações
SELECT m.id_movimentacao, p.nome AS Produto, t.descricao AS Tipo, u.nome AS Usuário, 
       m.quantidade, m.preco_unitario, m.data_movimentacao, m.observacao
FROM movimentacao m
JOIN produto p ON m.id_produto = p.id_produto
JOIN tipo_movimentacao t ON m.id_tipo = t.id_tipo
JOIN usuario u ON m.id_usuario = u.id_usuario
WHERE p.id_produto = 1; -- Filtrando pelo produto específico (Notebook Dell)

-- Estoque Atual:

SELECT p.nome AS Produto, 
       COALESCE(SUM(CASE WHEN t.descricao = 'Entrada' THEN m.quantidade ELSE 0 END), 0) - 
       COALESCE(SUM(CASE WHEN t.descricao = 'Saída' THEN m.quantidade ELSE 0 END), 0) AS Estoque_Atual
FROM produto p
LEFT JOIN movimentacao m ON p.id_produto = m.id_produto
LEFT JOIN tipo_movimentacao t ON m.id_tipo = t.id_tipo
GROUP BY p.nome;
