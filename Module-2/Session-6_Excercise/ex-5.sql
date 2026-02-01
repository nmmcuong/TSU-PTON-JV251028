use productsMananger;

-- 1. Liệt kê sản phẩm cùng với tên danh mục tương ứng
SELECT p.name AS product_name, c.name AS category_name
FROM products p
JOIN categories c ON p.category_id = c.id;

-- 2. Đếm số đơn hàng của từng khách hàng
SELECT c.name, COUNT(o.id) AS total_orders
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name;

-- 3. Xác định 5 khách hàng có tổng doanh thu chi tiêu cao nhất
SELECT c.name, SUM(od.quantity * od.price) AS total_spent
FROM customers c
JOIN orders o ON c.id = o.customer_id
JOIN order_details od ON o.id = od.order_id
GROUP BY c.id, c.name
ORDER BY total_spent DESC
LIMIT 5;

-- 4. Tìm các sản phẩm chưa từng xuất hiện trong bất kỳ đơn hàng nào
SELECT p.name
FROM products p
LEFT JOIN order_details od ON p.id = od.product_id
WHERE od.product_id IS NULL;

-- 5. Tìm những khách hàng đã mua sản phẩm thuộc danh mục có số lượng sản phẩm lớn nhất
SELECT DISTINCT c.name
FROM customers c
JOIN orders o ON c.id = o.customer_id
JOIN order_details od ON o.id = od.order_id
JOIN products p ON od.product_id = p.id
WHERE p.category_id = (
    -- Subquery tìm ID của danh mục có nhiều loại sản phẩm nhất
    SELECT category_id
    FROM products
    GROUP BY category_id
    ORDER BY COUNT(id) DESC
    LIMIT 1
);