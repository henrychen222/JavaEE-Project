create database mybatis;
use mybatis;
create table user(
	id varchar(50) primary key,
	name varchar(20) not null,
	password varchar(50) not null,
	realname varchar(10),
	email varchar(32)
);