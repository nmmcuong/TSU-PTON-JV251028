let danhSachSach = [];

let running = true;

do {
    let choice = prompt(`Hệ thống Quản lý Sách (Tổng: ${danhSachSach.length} cuốn)
--------------------------------------
1. Thêm sách mới
2. Hiển thị danh sách sách
3. Tìm kiếm sách theo tên
4. Xóa sách theo ID
5. Thoát chương trình
--------------------------------------
Vui lòng nhập lựa chọn của bạn (1-5):`);

    // Chuyển lựa chọn sang kiểu số
    choice = Number(choice);

    // 2. Xử lý lựa chọn bằng switch case
    switch (choice) {
        case 1:
            // === 1. Thêm sách mới ===
            {
                let id = prompt("Nhập ID sách:");
                let ten = prompt("Nhập Tên sách:");
                let tacGia = prompt("Nhập Tác giả:");
                let namXuatBan = Number(prompt("Nhập Năm xuất bản (số):"));

                if (!ten || !tacGia || isNaN(namXuatBan) || namXuatBan < 1000) {
                    alert("Dữ liệu nhập vào không hợp lệ hoặc thiếu.");
                    break;
                }

                let sachMoi = {
                    id: nextBookId,
                    ten: ten,
                    tacGia: tacGia,
                    namXuatBan: namXuatBan
                };

                // Thêm vào danh sách bằng phương thức push()
                danhSachSach.push(sachMoi);
                alert(`Đã thêm sách:\nID: ${sachMoi.id} - Tên: ${sachMoi.ten}`);
            }
            break;

        case 2:
            // === 2. Hiển thị danh sách sách ===
            {
                if (danhSachSach.length === 0) {
                    alert("Danh sách sách hiện đang trống.");
                    break;
                }

                let thongTin = "DANH SÁCH SÁCH HIỆN TẠI:\n";
                // Duyệt qua danh sách và nối chuỗi thông tin
                danhSachSach.forEach(sach => {
                    thongTin += `--- ID: ${sach.id} | Tên: ${sach.ten} | Tác giả: ${sach.tacGia} | Năm: ${sach.namXuatBan}\n`;
                });

                alert(thongTin);
            }
            break;

        case 3:
            // === 3. Tìm kiếm sách theo tên ===
            {
                let keyword = prompt("Nhập từ khóa Tên sách cần tìm:");
                if (!keyword) break;

                // Không phân biệt hoa thường
                const searchKeyword = keyword.toLowerCase();

                // Sử dụng filter() để tạo mảng mới chứa sách tìm được
                let ketQuaTimKiem = danhSachSach.filter(sach => 
                    sach.ten.toLowerCase().includes(searchKeyword)
                );

                if (ketQuaTimKiem.length > 0) {
                    let thongTinKQ = `Tìm thấy ${ketQuaTimKiem.length} cuốn sách chứa từ khóa "${keyword}":\n`;
                    ketQuaTimKiem.forEach(sach => {
                        thongTinKQ += `--- ID: ${sach.id} | Tên: ${sach.ten} | Tác giả: ${sach.tacGia}\n`;
                    });
                    alert(thongTinKQ);
                } else {
                    alert(`Không tìm thấy sách nào có tên chứa từ khóa "${keyword}".`);
                }
            }
            break;

        case 4:
            // === 4. Xóa sách theo ID ===
            {
                let idCanXoa = Number(prompt("Nhập ID của sách cần xóa:"));
                if (isNaN(idCanXoa)) {
                    alert("ID nhập vào không hợp lệ.");
                    break;
                }

                // Tìm vị trí (index) của sách trong mảng
                let indexCanXoa = danhSachSach.findIndex(sach => sach.id === idCanXoa);

                if (indexCanXoa !== -1) {
                    let sachDaXoa = danhSachSach.splice(indexCanXoa, 1);
                    alert(`Đã xóa sách:\nID: ${sachDaXoa[0].id} - Tên: ${sachDaXoa[0].ten}`);
                } else {
                    // Nếu ID không tồn tại
                    alert(`Lỗi: Không tìm thấy sách có ID ${idCanXoa}.`);
                }
            }
            break;

        case 5:
            // === 5. Thoát chương trình ===
            alert("Thoát chương trình. Tạm biệt!");
            running = false;
            break;

        default:
            alert("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 5.");
    }

} while (running);

console.log("Chương trình Quản lý Sách đã kết thúc.");