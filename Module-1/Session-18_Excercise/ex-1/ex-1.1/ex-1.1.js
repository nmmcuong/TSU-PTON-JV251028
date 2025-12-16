// Tạo đối tượng 'person'
let person = {
    name: "Nguyễn Văn B",
    age: 25,
    address: "123 Đường ABC, Quận 1, TP.HCM",
    phoneNumber: "0901234567"
};

// Truy xuất và in ra các thuộc tính của đối tượng
console.log("--- Thông tin Người ---");
console.log("Tên: " + person.name); // Truy xuất bằng toán tử chấm (.)
console.log("Tuổi: " + person['age']); // Truy xuất bằng ngoặc vuông (['...'])
console.log("Địa chỉ: " + person.address);
console.log("SĐT: " + person.phoneNumber);
