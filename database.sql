create database automatedStudentRegistration;
use automatedStudentRegistration;

-- Display section
show databases;
show tables;
select * from courses;
select * from students;
select * from batch;
select * from batchSeats;

-- Delete section
drop database automatedStudentRegistration;

create table courses
(
cId int primary key,
cName varchar(30) NOT NULL,
fees int NOT NULL,
cInfo varchar(100)
);

create table students
(
sEmail varchar(25) primary key,
sPassword varchar(15) NOT NULL,
sName varchar(20) NOT NULL
);

create table batchSeats
(
bId int primary key,
cId int,
totalSeats int,
seatsFilled int
);

create table batch
(
batchUId int primary key auto_increment,
batchNo int,
cId int,
sEmail varchar(25),

foreign key (cId) references courses(cId) ON DELETE CASCADE,
foreign key (sEmail) references students(sEmail) ON DELETE CASCADE,
foreign key (batchNo) references batchSeats (bId)
);

insert into courses values (1, 'Java', 5000,'backend');
insert into courses values (2, 'ML', 6000,'extra course');
insert into courses values (3, 'AI', 7000,'extra course');

insert into batchSeats values (1, 1, 5, 0);
insert into batchSeats values (2, 2, 5, 0);
insert into batchSeats values (3, 3, 5, 0);







