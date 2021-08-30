create database kurs

\c kurs;

CREATE TABLE users_table
(
    id bigint NOT NULL,
    name character varying NOT NULL,
    pass character varying NOT NULL,
    PRIMARY KEY (id)
);