create database BookDB;

go

use BookDB;

go

create table book
(
	id int primary key identity,
	bookName varchar(20) not null,
	price money check(price > 0),
	author varchar(20) not null,
	publisher varchar(20) not null,
	publishDate date
);


insert into book (name, price, author, publisher, publishDate)
values
('aaa', 222, 'xxx', 'ooo', '2016-10-17'),
('bbb', 333, 'xx1', 'ooo', '2016-10-16'),
('ccc', 444, 'xx2', 'ooo', '2016-1-17'),
('ddd', 555, 'xx3', 'ooo', '2016-11-17'),
('eee', 666, 'xx4', 'ooo', '2016-10-17');

go

