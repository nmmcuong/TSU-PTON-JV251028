use productsMananger;

-- 1. Tìm các sản phẩm có giá nằm trong một khoảng cụ thể (ví dụ từ 100 đến 500)
SELECT * FROM products 
WHERE price BETWEEN 100 AND 500;

-- 2. Tìm các sản phẩm có tên chứa một chuỗi ký tự nhất định (ví dụ chứa chữ 'iPhone')
SELECT * FROM products 
WHERE name LIKE '%iPhone%';

-- 3. Tính giá trung bình của sản phẩm cho mỗi danh mục
SELECT c.name AS category_name, AVG(p.price) AS average_price
FROM categories c
JOIN products p ON c.id = p.category_id
GROUP BY c.id, c.name;

-- 4. Tìm những sản phẩm có giá cao hơn mức giá trung bình của toàn bộ sản phẩm
SELECT * FROM products 
WHERE price > (SELECT AVG(price) FROM products);

-- 5. Tìm sản phẩm có giá thấp nhất cho từng danh mục
SELECT c.name AS category_name, p.name AS product_name, p.price
FROM categories c
JOIN products p ON c.id = p.category_id
WHERE p.price = (
    SELECT MIN(price) 
    FROM products 
    WHERE category_id = c.id
);