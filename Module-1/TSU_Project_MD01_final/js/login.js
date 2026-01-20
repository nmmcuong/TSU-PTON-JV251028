<<<<<<< HEAD
document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.getElementById("form");

  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const emailInput = document.getElementById("email").value.trim();
    const passwordInput = document.getElementById("password").value.trim();

    // 1. Lấy dữ liệu từ localStorage
    // Giả sử trang Register lưu danh sách dưới key 'users'
    const rawData = localStorage.getItem("users");
    const listUsers = JSON.parse(rawData) || [];

    // 2. Kiểm tra validation cơ bản
    if (!emailInput || !passwordInput) {
      alert("Vui lòng nhập đầy đủ email và mật khẩu!");
      return;
    }

    // 3. Tìm kiếm tài khoản trong danh sách
    const userFound = listUsers.find(
      (user) => user.email === emailInput && user.password === passwordInput
    );

    // 4. Xử lý kết quả
    if (userFound) {
        console.log("Login");
      alert(`Đăng nhập thành công!`);

      // Lưu thông tin người dùng hiện tại vào session hoặc local để dùng ở trang chủ
      localStorage.setItem("currentUser", JSON.stringify(userFound));

      // Chuyển hướng sang trang quản lý/trang chủ
      window.location.href = "../pages/dashboard.html";
    } else {
      alert("Email hoặc mật khẩu không đúng. Vui lòng thử lại!");
    }
  });
});
=======
document.addEventListener("DOMContentLoaded", () => {
  const loginForm = document.getElementById("form");

  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const emailInput = document.getElementById("email").value.trim();
    const passwordInput = document.getElementById("password").value.trim();

    // 1. Lấy dữ liệu từ localStorage
    // Giả sử trang Register lưu danh sách dưới key 'users'
    const rawData = localStorage.getItem("users");
    const listUsers = JSON.parse(rawData) || [];

    // 2. Kiểm tra validation cơ bản
    if (!emailInput || !passwordInput) {
      alert("Vui lòng nhập đầy đủ email và mật khẩu!");
      return;
    }

    // 3. Tìm kiếm tài khoản trong danh sách
    const userFound = listUsers.find(
      (user) => user.email === emailInput && user.password === passwordInput
    );

    // 4. Xử lý kết quả
    if (userFound) {
        console.log("Login");
      alert(`Đăng nhập thành công!`);

      // Lưu thông tin người dùng hiện tại vào session hoặc local để dùng ở trang chủ
      localStorage.setItem("currentUser", JSON.stringify(userFound));

      // Chuyển hướng sang trang quản lý/trang chủ
      window.location.href = "../pages/dashboard.html";
    } else {
      alert("Email hoặc mật khẩu không đúng. Vui lòng thử lại!");
    }
  });
});
>>>>>>> af7eab56334c3ecae8ce3f3e8e96e87d1c474475
