CREATE DATABASE IF NOT EXISTS sales_db;
USE sales_db;

CREATE TABLE Product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE
);

CREATE TABLE `Order` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATE NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);

CREATE TABLE OrderDetail (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    order_id INT,
    quantity INT NOT NULL CHECK (quantity > 0),
    priceSell DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Product(id),
    FOREIGN KEY (order_id) REFERENCES `Order`(id)
);
