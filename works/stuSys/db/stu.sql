create database studb;

go

use studb;

go

create table stuInfo (
	stuNo		varchar(15) primary key,
	stuName		varchar(20) not null,
	stuSex		char(2) default 'ÄÐ',
	stuAge		int,
	score		decimal,	
	className	varchar(10)
);

insert into stuInfo (stuName, stuSex, stuAge, score, className)
	values
	(11, 'aaa', 'ÄÐ', 250, 260, '134'),
	(22, 'bbb', 'ÄÐ', 250, 260, '134'),
	(33, 'ccc', 'Å®', 250, 260, '134'),
	(44, 'ddd', 'ÄÐ', 250, 260, '134'),
	(55, 'eee', 'ÄÐ', 250, 260, '134');
go

