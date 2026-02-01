use productsMananger;
-- 1. Thêm một đơn hàng mới vào bảng orders và chi tiết của đơn hàng đó vào bảng order_details
INSERT INTO orders (customer_id, order_date) 
VALUES (1, CURDATE());

-- Thêm chi tiết cho đơn hàng vừa tạo (sử dụng LAST_INSERT_ID() để lấy id của đơn hàng mới nhất)
INSERT INTO order_details (order_id, product_id, quantity, price) 
VALUES (LAST_INSERT_ID(), 2, 5, 150.0);

-- 2. Tính tổng doanh thu của toàn bộ cửa hàng
SELECT SUM(quantity * price) AS total_store_revenue 
FROM order_details;

-- 3. Tính doanh thu trung bình của mỗi đơn hàng
SELECT AVG(order_total) AS average_order_revenue
FROM (
    SELECT SUM(quantity * price) AS order_total 
    FROM order_details 
    GROUP BY order_id
) AS subquery;

-- 4. Tìm và hiển thị thông tin của đơn hàng có doanh thu cao nhất
SELECT o.id, o.order_date, SUM(od.quantity * od.price) AS total_revenue
FROM orders o
JOIN order_details od ON o.id = od.order_id
GROUP BY o.id
ORDER BY total_revenue DESC
LIMIT 1;

-- 5. Tìm và hiển thị danh sách 3 sản phẩm bán chạy nhất dựa trên tổng số lượng đã bán
SELECT p.name, SUM(od.quantity) AS total_quantity_sold
FROM products p
JOIN order_details od ON p.id = od.product_id
GROUP BY p.id, p.name
ORDER BY total_quantity_sold DESC
LIMIT 3;