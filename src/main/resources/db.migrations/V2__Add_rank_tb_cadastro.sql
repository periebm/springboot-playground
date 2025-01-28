-- V2: Migration para adcionar a coluna de RNAk na tabela de cadastro

ALTER TABLE tb-cadastro
ADD COLUMN rank VARCHAR(255);