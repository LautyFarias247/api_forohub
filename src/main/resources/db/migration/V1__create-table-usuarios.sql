CREATE TABLE usuarios (
    id bigint not null auto_increment,
    email varchar(200) not null,
    clave varchar (200) not null,

    PRIMARY KEY (id),
    UNIQUE(email)
);