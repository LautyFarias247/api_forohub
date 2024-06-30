CREATE TABLE topicos (
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(400) not null,
    fecha datetime not null,
    usuario bigint not null,
    curso varchar(100) not null,
    PRIMARY KEY (id)
);