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

/* Gestores y Documentos Gestores */

create table gestores
(cod_gestor int not null primary key,
tipo_gestor varchar(40) not null 
);

select * from gestores;

insert into gestores
values (122, 'Gerente de GPP');
insert into gestores
values (123, 'Secretaría de GPP');
insert into gestores
values (125, 'GAJ');
insert into gestores
values (124, 'Secretaría General');

create table detalle_documento
(cod_docu char(5) not null primary key,
des_docu varchar(50) not null,
cod_gestor int not null,
tiempo varchar(20) not null
);

SELECT * FROM detalle_documento;

alter table detalle_documento 
add constraint FK_01 foreign key (cod_gestor) references gestores (cod_gestor);

create table detalle_gestor
(
num_funcion int primary key auto_increment,
funciones_gestor varchar(50) not null,
cod_gestor int not null
);
alter table detalle_gestor
add constraint FK_02 foreign key (cod_gestor) references gestores (cod_gestor);

select * from detalle_gestor;



select tipo_gestor, des_docu
from detalle_documento d join gestores g
on d.cod_gestor=g.cod_gestor;