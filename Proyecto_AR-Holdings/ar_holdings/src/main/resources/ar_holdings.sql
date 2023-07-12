create database ar_holdings;
use ar_holdings;
drop database if exists ar_holdings;

create user hr identified by 'Holding';
grant all privileges on ar_holdings to hr;
flush privileges;
drop user if exists hr;

create table Restaurantes(
id_Restaurante int auto_increment primary key,
nombre varchar (255),
ruta_imagen varchar(1024),
ubicacion varchar (1000),
telefono int,
sitio_web varchar (1000),
correo varchar (255));

insert into Restaurantes (nombre,ruta_imagen,ubicacion,telefono,sitio_web,correo) values
('McDonalds','URL','url','234535','url','correo'),
('Burger King','URL','url','234535','url','correo'),
('KFC','URL','url','234535','url','correo');

create table Tiendas(
id_Tienda int auto_increment primary key,
nombre varchar (255),
ruta_imagen varchar(1024),
ubicacion varchar (1000),
telefono int,
sitio_web varchar (1000),
correo varchar (255));

insert into Tiendas (nombre,ruta_imagen,ubicacion,telefono,sitio_web,correo) values
('Zara','URL','url','234535','url','correo'),
('Pull&Bear','URL','url','234535','url','correo'),
('Forever21','URL','url','234535','url','correo');

create table Contacto(
id_Contacto int auto_increment primary key,
nombre varchar (255),
apellido1 varchar (255),
apellido2 varchar (255),
telefono int,
correo varchar (255));

insert into Contacto (nombre,apellido1,apellido2,telefono,correo) values
('Juan','Correa','Uva','34646','correo'),
('Maria','Correa','Uva','34646','correo'),
('Paco','Correa','Uva','34646','correo');

create table Puestos(
id_Puestos int auto_increment primary key,
nombre varchar (255),
turno varchar (1),
area varchar (255),
salario double,
requicitos varchar (1000));

insert into Puestos (nombre,turno,area,salario,requicitos) values
('Vendedor','A','ventas','34646','2 idiomas'),
('Cobros','A','ventas','34646','2 idiomas'),
('Finanzas','A','ventas','34646','2 idiomas');

create table Empleados(
id_Empleado int auto_increment primary key,
nombre varchar (255),
apellido1 varchar (255),
apellido2 varchar (255),
puesto varchar (255),
fecha_ingreso date (255),
salario double);

insert into Empleados (nombre,apellido1,apellido2,puesto,fecha_ingreso,salario) values
('Alex','Correa','Uva','hr','DD-MM-YY','3243424'),
('Ana','Correa','Uva','hr','DD-MM-YY','3243424'),
('Felix','Correa','Uva','hr','DD-MM-YY','3243424');