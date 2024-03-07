CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS tb_product(
    id_product      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name            VARCHAR,
    price           BIGINT,
    description     VARCHAR,
    imageUri        TEXT
);

CREATE TABLE IF NOT EXISTS tb_input(
    id_input        uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    id_product      uuid,
    price           BIGINT,
    amount          INT,
    date_input      TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tb_output(
    id_output        uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    id_product      uuid,
    price           BIGINT,
    amount          INT,
    date_output      TIMESTAMP
);

ALTER TABLE tb_input
    ADD CONSTRAINT fk_input FOREIGN KEY (id_product) REFERENCES tb_product(id_product);

ALTER TABLE tb_output
    ADD CONSTRAINT fk_output FOREIGN KEY (id_product) REFERENCES tb_product(id_product);