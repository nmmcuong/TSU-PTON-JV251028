CREATE DATABASE IF NOT EXISTS usersex3 ;
USE usersex3;
 create table users(
 idUser int primary key,
 userName varchar(255) unique,
 email varchar(255) unique,
 passwords varchar(8) not null,
 statuss varchar(255) not null default('ACTIVE')
 );
 
 -- ALTER TABLE
 ALTER TABLE users
 ADD CONSTRAINT chk_status 
CHECK (statuss IN ('ACTIVE', 'INACTIVE'));

-- DROP TABLE
DROP TABLE users;