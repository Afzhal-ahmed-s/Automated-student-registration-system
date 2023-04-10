create database mini_project;
use mini_project;

show tables;

drop database mini_project;

select * from admin;
select * from customer;
select * from seller;
select * from address;
select * from current_user_session;
select * from products;
select * from order_table;
select * from cart;
select * from cart_product;
select * from payment;
select * from productdto;
select * from card_details;
select * from customer_card;


create table salesKenTask(
id int primary key,
rollNo int,
name varchar(20),
subject varchar(20),
marks int
);

select * from salesKenTask;
insert into salesKenTask values(1 , 1, "afzhal", "chem", 20);



