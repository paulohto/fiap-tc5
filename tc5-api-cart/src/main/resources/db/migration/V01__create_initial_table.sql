CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS tb_order(
    id_order            uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    address             VARCHAR,
    latitude            VARCHAR,
    longitude           VARCHAR,
    moment              TIMESTAMP,
    status              SMALLINT,
    total               BIGINT
);

CREATE TABLE IF NOT EXISTS tb_order_status(
    status SMALLINT
);

CREATE TABLE IF NOT EXISTS tb_order_product(
    id_order            uuid,
    id_product          uuid
);
