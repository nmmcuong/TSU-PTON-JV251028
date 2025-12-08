
let danhSachSinhVien = [];


// Biến điều khiển vòng lặp chính
let running = true;

// Hàm chính của chương trình
do {
    // 1. Hiển thị Menu và nhận lựa chọn
    let choice = prompt(`Hệ thống Quản lý Sinh viên (Tổng: ${danhSachSinhVien.length} SV)
--------------------------------------
1. Thêm sinh viên mới
2. Hiển thị danh sách sinh viên
3. Xóa sinh viên theo ID
4. Thoát chương trình
--------------------------------------
Vui lòng nhập lựa chọn của bạn (1-4):`);

    // Chuyển lựa chọn sang kiểu số
    choice = Number(choice);

    // 2. Xử lý lựa chọn bằng switch case
    switch (choice) {
        case 1:
            // === 1. Thêm sinh viên mới ===
            {
                let ten = prompt("Nhập Tên sinh viên:");
                if (!ten) break; // Thoát nếu người dùng không nhập tên

                let tuoi = Number(prompt("Nhập Tuổi sinh viên:"));
                if (isNaN(tuoi) || tuoi <= 0) {
                    alert("Tuổi nhập vào không hợp lệ.");
                    break;
                }
                let Id = Number(prompt("Nhập ID sinh viên:"));

                // Tạo đối tượng sinh viên mới
                let sinhVienMoi = {
                    id: Id,
                    ten: ten,
                    tuoi: tuoi
                };

                // Thêm vào danh sách bằng phương thức push()
                danhSachSinhVien.push(sinhVienMoi);
                alert(`Đã thêm sinh viên:\nID: ${sinhVienMoi.id}\nTên: ${sinhVienMoi.ten}`);
                
            }
            break;

        case 2:
            {
                if (danhSachSinhVien.length === 0) {
                    alert("Danh sách sinh viên hiện đang trống.");
                    break;
                }

                let thongTin = "DANH SÁCH SINH VIÊN:\n";
                danhSachSinhVien.forEach(sv => {
                    thongTin += `--- ID: ${sv.id} | Tên: ${sv.ten} | Tuổi: ${sv.tuoi}\n`;
                });

                alert(thongTin);
                console.log(danhSachSinhVien); // In ra console để dễ kiểm tra
            }
            break;

        case 3:
            {
                let idCanXoa = Number(prompt("Nhập ID của sinh viên cần xóa:"));
                if (isNaN(idCanXoa)) {
                    alert("ID nhập vào không hợp lệ.");
                    break;
                }

                let indexCanXoa = danhSachSinhVien.findIndex(sv => sv.id === idCanXoa);

                if (indexCanXoa !== -1) {
                    let svDaXoa = danhSachSinhVien.splice(indexCanXoa, 1);
                    alert(`Đã xóa sinh viên:\nID: ${svDaXoa[0].id}\nTên: ${svDaXoa[0].ten}`);
                } else {
                    alert(`Lỗi: Không tìm thấy sinh viên có ID ${idCanXoa}.`);
                }
            }
            break;

        case 4:
            alert("Thoát chương trình. Tạm biệt!");
            running = false;
            break;

        default:
            alert("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 4.");
    }

} while (running);

console.log("Chương trình kết thúc.");