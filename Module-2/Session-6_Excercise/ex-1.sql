create database productsManager;
use productsManager;

create table categories 
(
ctId int primary key,
name varchar(255) not null
);

create table products
(
pdId int primary key,
PproductName varchar(255) not null,
price decimal(15,2) not null,
ctId int,
foreign key (ctId) references categories(ctId)
);

insert into categories values 
(1, 'Tablet'),
(2, 'Laptop'),
(3, 'Phone');

insert into products values 
(1, 'iphone X', 10000000, 3),
(2, 'Tablet  X', 15000000, 1),
(3, 'Mac M2', 19000000, 2);

SET sql_safe_updates = 0;
update products set price = 9000000
where PproductName = 'iphone X';

select * from products;

delete from products where PproductName = 'iphone X';

select * from products order by price desc;

SELECT c.name, COUNT(p.pdId) as total
FROM categories c
LEFT JOIN products p ON c.ctId = p.ctId
GROUP BY c.ctId, c.name;

