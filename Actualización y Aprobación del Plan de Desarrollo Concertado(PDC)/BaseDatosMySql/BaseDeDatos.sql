/*
	Proyecto LP base de datos
*/
CREATE DATABASE  IF NOT EXISTS `PDC_BD`;
use PDC_BD;

create table Login_Usuarios
(
	usuario varchar(10),
    contrasenia varchar(10),
    constraint PK_Login primary key (usuario)
);
insert into login_Usuarios values ('admin','admin');
insert into login_Usuarios values ('user','123');
