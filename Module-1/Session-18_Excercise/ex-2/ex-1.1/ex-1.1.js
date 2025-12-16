let products = [
    { id: 1, name: 'Milk', count: 100 },
    { id: 2, name: 'Orange', count: 100 },
    { id: 3, name: 'Butter', count: 100 }
];
// Thêm đối tượng mới (ví dụ: Bread)
let newProduct = { id: 4, name: 'Bread', count: 50 };
products.push(newProduct);

console.log("--- A. Thêm đối tượng mới (Bread) ---");
console.log(products);

// Dùng filter để tạo mảng mới không bao gồm sản phẩm có id = 2
products = products.filter(product => product.id !== 2);

console.log("\n--- B. Xóa đối tượng có id là 2 (Orange) ---");
console.log(products); 
// Lưu ý: Mảng 'products' bây giờ chỉ còn id 1, 3, 4
// Dùng find để tìm đối tượng cần cập nhật
let productToUpdate = products.find(product => product.id === 3);

if (productToUpdate) {
    productToUpdate.count = 0; // Cập nhật thuộc tính 'count'
}

console.log("\n--- C. Cập nhật count của id 3 (Butter) thành 0 ---");
console.log(products.find(product => product.id === 3));

let searchKeyword = "Butter";
let foundProduct = products.find(product => product.name === searchKeyword);

console.log("\n--- D. Tìm kiếm sản phẩm bằng từ khóa 'Butter' ---");

if (foundProduct) {
    console.log("Tìm thấy dữ liệu:");
    console.log(foundProduct);
} else {
    console.log("Không có dữ liệu bạn tìm kiếm");
}