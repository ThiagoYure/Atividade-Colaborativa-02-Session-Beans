CREATE TABLE cliente(
    id serial PRIMARY KEY,
    nome VARCHAR(50),
    cpf VARCHAR(15) UNIQUE
);
CREATE TABLE produto(
    id SERIAL PRIMARY KEY,
    descricao TEXT,
    valor FLOAT
);
CREATE TABLE Venda(
    id SERIAL PRIMARY KEY,
    total FLOAT,
    id_cliente int,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE RESTRICT
);
CREATE TABLE item(
    quantidade int,
    id_produto int,
    id_venda int,
    FOREIGN KEY (id_produto) REFERENCES produto(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_venda) REFERENCES venda(id) ON DELETE RESTRICT,
    PRIMARY KEY(id_venda,id_produto)
)
