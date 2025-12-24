const registerForm = document.getElementById('registerForm');

registerForm.addEventListener('submit', function(e) {
    e.preventDefault(); // Ngăn trang web bị load lại

    // 1. Lấy giá trị từ các ô input
    const lastName = document.getElementById('lastName').value.trim();
    const firstName = document.getElementById('firstName').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmPassword').value.trim();
    const confirmReg = document.getElementById('confirmReg').checked;

    // 2. Kiểm tra bỏ trống
    if (!lastName || !firstName || !email || !password || !confirmPassword || !confirmReg) {
        alert("Vui lòng nhập đầy đủ thông tin!");
        return;
    }

    // 3. Kiểm tra mật khẩu khớp nhau
    if (password !== confirmPassword) {
        alert("Mật khẩu xác nhận không khớp!");
        return;
    }

    // 4. THAO TÁC VỚI LOCAL STORAGE
    // Lấy danh sách user cũ về (nếu chưa có thì tạo mảng rỗng)
    const listUsers = JSON.parse(localStorage.getItem('users')) || [];

    // 5. Kiểm tra email đã tồn tại chưa
    const isExisted = listUsers.some(user => user.email === email);
    if (isExisted) {
        alert("Email này đã được đăng ký!");
        return;
    }

    // 6. Lưu tài khoản mới
    const newUser = {
        name: lastName + " " + firstName,
        email: email,
        password: password
    };

    
    listUsers.push(newUser); // Thêm user mới vào mảng
    
    // Lưu mảng mới ngược lại vào Local Storage
    localStorage.setItem('users', JSON.stringify(listUsers));
    window.location.href = "login.html";
    alert("Đăng ký thành công!");
    
    //console.log("Danh sách người dùng hiện tại:", listUsers);
    registerForm.reset(); // Xóa sạch form sau khi đăng ký
});