create database studb;

go

use studb;

go

create table stuInfo (
	stuNo		varchar(15) primary key,
	stuName		varchar(20) not null,
	stuSex		char(2) default '��',
	stuAge		int,
	score		decimal,	
	className	varchar(10)
);

insert into stuInfo (stuName, stuSex, stuAge, score, className)
	values
	(11, 'aaa', '��', 250, 260, '134'),
	(22, 'bbb', '��', 250, 260, '134'),
	(33, 'ccc', 'Ů', 250, 260, '134'),
	(44, 'ddd', '��', 250, 260, '134'),
	(55, 'eee', '��', 250, 260, '134');
go

