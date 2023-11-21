drop database if exists demo_thymeleaf;
create database demo_thymeleaf;
use demo_thymeleaf;

create table user
(
    id       int primary key auto_increment,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null
);

insert into user (name, email, password)
values ('Nguyễn Minh Triết', 'trietnm@gmail.com', '123456'),
       ('Phạm Minh Chính', 'chinhpm@gmail.com', '123456'),
       ('Nguyễn Phú Trọng', 'trongpt@gmail.com', '123456'),
       ('Dương Đức Anh', 'anhdd@gmail.com', '123456');
