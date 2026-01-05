document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.getElementById("form");

  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const emailInput = document.getElementById("email").value.trim();
    const passwordInput = document.getElementById("password").value.trim();

    // 1. Lấy danh sách người dùng từ LocalStorage (được lưu từ trang Register)
    // Dữ liệu thường được lưu dưới dạng chuỗi JSON của một mảng đối tượng
    const listUsers = JSON.parse(localStorage.getItem("email")) || [];

    // 2. Tìm kiếm người dùng có email trùng khớp
    const userFound = listUsers.find((user) => user.email === emailInput);

    // 3. Kiểm tra logic
    if (!emailInput || !passwordInput) {
      alert("Vui lòng không để trống!");
      return;
    }

    if (userFound) {
      // Kiểm tra mật khẩu
      if (userFound.password === passwordInput) {
        alert("Đăng nhập thành công!");

        // Lưu thông tin người dùng hiện tại đang đăng nhập (để hiển thị tên ở trang chủ)
        localStorage.setItem("currentUser", JSON.stringify(userFound));

        // Chuyển hướng
        window.location.href = "../index.html";
      } else {
        alert("Mật khẩu không chính xác!");
      }
    } else {
      alert("Tài khoản không tồn tại! Vui lòng đăng ký.");
    }
  });
});
