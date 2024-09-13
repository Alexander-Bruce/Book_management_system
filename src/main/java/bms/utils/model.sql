create database yichuang
create table user
(
    id            int auto_increment
        primary key,
    user_name     varchar(50)                          not null,
    surname       varchar(50)                          null,
    user_password varchar(200)                         not null,
    user_type     int                                  not null,
    email         varchar(50)                          not null,
    image_url     varchar(100)                         null,
    updated_time  datetime   default CURRENT_TIMESTAMP null,
    created_time  datetime   default CURRENT_TIMESTAMP null,
    isDeleted     tinyint(1) default 0                 not null,
    constraint user_pk
        unique (user_name)
);