create table users
(
    id      INT(10) auto_increment
        primary key,
    name    VARCHAR(50) not null,
    surname VARCHAR(50) not null,
    profile JSON(1073741824) null,
    constraint users_name_surname_uindex
        unique (name, surname)
);