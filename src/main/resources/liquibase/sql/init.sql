--liquibase formatted sql

--changeSet skryagin:1

create table if not exists news_type

(
    id    bigserial primary key,
    color varchar(255),
    title varchar(255)
);

create table if not exists news
(
    id           bigserial primary key,
    brief        varchar(255),
    content      varchar(255),
    title        varchar(255),
    news_type_id bigint not null references news_type
);