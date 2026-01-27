CREATE DATABASE IF NOT EXISTS products ;
USE products;

CREATE TABLE products (
    product_dd INTEGER PRIMARY KEY,
    product_name varchar(255) not null,
    category varchar(255) not null,
    price float not null,
    quantitiy int not null
    
);

INSERT INTO products (product_dd, product_name, category, price, quantitiy)
VALUES 
(1, 'MacBook Pro M3', 'Laptop', 45000000, 15),
(2, 'Dell XPS 15', 'Laptop', 38000000, 10),
(3, 'iPhone 15 Pro', 'Phone', 28000000, 25),
(4, 'Samsung Galaxy S24', 'Phone', 22000000, 20),
(5, 'iPad Air M2', 'Tablet', 16000000, 30);

INSERT INTO products (product_dd, product_name, category, price, quantitiy)
VALUES 
(6, 'iPad Air M3', 'Tablet', 9000000, 30);

#Hiển thị sản phẩm có giá từ 5.000.000 đến 15.000.000
select * from products where price >= 5000000 and price <= 15000000;

#Hiển thị sản phẩm thuộc loại Laptop or Tablet
select * from products where product_name = 'Laptop' or product_name = 'Tablet';

#Hiển thị sản phẩm có tên bắt đầu bằng “Sam”
select * from products where product_name  like 'Sam%';


#Hiển thị sản phẩm không thuộc loại Phone
select * from products where category != 'Phone';

#Cập nhật & xóa dữ liệu (UPDATE – DELETE)
#Giảm giá 5% cho các sản phẩm thuộc loại Laptop
SET SQL_SAFE_UPDATES = 0;
update products set price = price * 0.005 where category = 'Laptop';
#Xóa các sản phẩm có số lượng tồn kho bằng 0
select * from products;
update products set quantitiy = 0 where product_name = 'iPad Air M3' ;
delete from products where quantitiy = 0;
select * from products;

#Kiểm tra lại bảng sau mỗi thao tác bằng SELECT


