// 1. Tạo đối tượng 'student1' (dựa theo bảng)
let student1 = {
    id: 1,
    name: "Nguyễn Văn A",
    gender: "nam",
    age: 20,
    mark: 8
};

// 2. Khởi tạo đối tượng 'newStudent' (với value khác)
let newStudent = {
    id: 2,
    name: "Lê Thị C",
    gender: "nữ",
    age: 21,
    mark: 9
};

// 3. Tạo mảng 'students' và thêm 2 đối tượng vào
let students = [student1, newStudent]; 


console.log("\n--- Danh sách Students ---");
console.log("Tổng số học sinh: " + students.length); 
console.log("Thông tin Student 1:", students[0]);
console.log("Thông tin New Student:", students[1]);

// 4. Truy xuất các thuộc tính của đối tượng 'newStudent' sau khi nó đã ở trong mảng 'students'
console.log("\n--- Truy xuất New Student (từ mảng students) ---");
let studentInArray = students[1];
console.log("ID của New Student: " + studentInArray.id);
console.log("Tên của New Student: " + studentInArray.name); 
console.log("Điểm của New Student: " + studentInArray.mark); 

let studentHighestMark = students[0]; // Giả sử học sinh đầu tiên có điểm cao nhất ban đầu

// Lặp qua mảng từ phần tử thứ hai (chỉ số 1)
for (let i = 1; i < students.length; i++) {
    // So sánh điểm (mark) của học sinh hiện tại với học sinh đang có điểm cao nhất
    if (students[i].mark > studentHighestMark.mark) {
        // Nếu điểm cao hơn, cập nhật lại học sinh có điểm cao nhất
        studentHighestMark = students[i];
    }
}

// In ra thông tin của học sinh có điểm cao nhất
console.log("\n--- Học sinh có điểm cao nhất ---");
console.log("Tên: " + studentHighestMark.name);
console.log("Điểm: " + studentHighestMark.mark);
console.log("Toàn bộ thông tin:");
console.log(studentHighestMark);

