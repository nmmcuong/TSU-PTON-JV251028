let heightInput = prompt("Nhập chiều cao (mét):");
let weightInput = prompt("Nhập cân nặng (Kg):");

let height = Number(heightInput);
let weight = Number(weightInput);

if (isNaN(height) || isNaN(weight) || height <= 0 || weight <= 0) {
    alert("Dữ liệu nhập không hợp lệ. Vui lòng nhập số dương cho cả chiều cao và cân nặng.");
} else {
    let bmi = weight / (height * height);

    let classWHO = "";
    let classIDIandWPRO = "";

    if (bmi < 18.5) {
        classWHO = "Cân nặng thấp (gầy)";
    } else if (bmi >= 40) { // Kiểm tra từ trên xuống dưới (hoặc dưới lên trên) là cách tốt nhất
        classWHO = "Béo phì độ III";
    } else if (bmi >= 35) {
        classWHO = "Béo phì độ II";
    } else if (bmi >= 30) {
        classWHO = "Béo phì độ I";
    } else if (bmi >= 25) {
        classWHO = "Thừa cân (bao gồm Tiền béo phì: 25 - 29.9)";
    } else if (bmi >= 18.5) {
        classWHO = "Bình thường (18.5 - 24.9)";
    } 

    if (bmi < 18.5) {
        classIDIandWPRO = "Cân nặng thấp (gầy)";
    } else if (bmi >= 30) { // Béo phì độ II
        classIDIandWPRO = "Béo phì độ II (>= 30)";
    } else if (bmi >= 25) { // Béo phì độ I
        classIDIandWPRO = "Béo phì độ I (25 - 29.9)";
    } else if (bmi >= 23) { // Tiền béo phì
        classIDIandWPRO = "Tiền béo phì (23 - 24.9)";
    } else if (bmi >= 18.5) { // Bình thường
        classIDIandWPRO = "Bình thường (18.5 - 22.9)";
    } 
    
    // Kết quả cuối cùng
    alert(`Chỉ số BMI của bạn là: ${bmi.toFixed(2)} kg/m²
    
Phân loại theo WHO:
=> ${classWHO}
    
Phân loại theo IDI và WPRO:
=> ${classIDIandWPRO}`);
}