CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS tb_product(
    id_product      uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name            VARCHAR,
    price           BIGINT,
    description     VARCHAR,
    imageUri        TEXT
);