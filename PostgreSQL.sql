-- Database: ecommerceKeola

DROP DATABASE IF EXISTS "ecommerceKeola";

CREATE DATABASE "ecommerceKeola"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio NUMERIC(10, 2) NOT NULL
);

INSERT INTO clientes (nombre, email) VALUES ('Javier Marroquin', 'jmarroquin@example.com');
INSERT INTO clientes (nombre, email) VALUES ('Julio Cesar', 'jcesar@example.com');

INSERT INTO productos (nombre, precio) VALUES ('Producto 1', 19.99);
INSERT INTO productos (nombre, precio) VALUES ('Producto 2', 29.99);