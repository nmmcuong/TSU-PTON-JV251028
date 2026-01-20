CREATE TABLE orders( 
    OrderId INTEGER PRIMARY KEY,
    priceTotal FLOAT NOT NULL,
    ngayTao DATE NOT NULL 
);

CREATE TABLE products (
    ProductId INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    price FLOAT NOT NULL
);

CREATE TABLE order_items(
    OrderId INTEGER,
    ProductId INTEGER,
    total INTEGER NOT NULL,
    PRIMARY KEY (OrderId, ProductId), 
    FOREIGN KEY (OrderId) REFERENCES orders(OrderId),
    FOREIGN KEY (ProductId) REFERENCES products(ProductId)
);