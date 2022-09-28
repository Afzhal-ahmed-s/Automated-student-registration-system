create database automatedStudentRegistration;
use automatedStudentRegistration;

-- Display section
show databases;

-- Delete section
drop database automatedStudentRegistration;

create table students
(
cId int primary key,
cName varchar(30) NOT NULL,
fees int NOT NULL
);

create table courses
(
sEmail varchar(25) primary key,
sPassword varchar(15) NOT NULL,
sName varchar(20) NOT NULL,
sPlace varchar(25) NOT NULL
);

create table batch
(
batchId int,
cId int,
sEmail varchar(25),
totalSeats int,
seatsFilled int,

foreign key (cId) references courses(cId),
foreign key (sEmail) references students(sEmail)
);



