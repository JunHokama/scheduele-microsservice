CREATE TABLE paciente (
    paciente_id serial PRIMARY KEY,
    nome varchar(50),
    sobrenome varchar(100),
    cpf varchar(14), -- Alterado para varchar(14) para armazenar CPF
    email varchar(100)
);