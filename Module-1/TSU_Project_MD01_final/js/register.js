const registerForm = document.getElementById('registerForm');

registerForm.addEventListener('submit', function(e) {
    e.preventDefault(); // Ngăn trang web bị load lại

    const lastName = document.getElementById('lastName').value.trim();
    const firstName = document.getElementById('firstName').value.trim();
    const email = document.getElementById('email').value.trim();
    const emailLower = email.toLowerCase().trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmPassword').value.trim();
    const confirmReg = document.getElementById('confirmReg').checked;

    if (!lastName || !firstName || !email || !password || !confirmPassword || !confirmReg) {
        alert("Vui lòng nhập đầy đủ thông tin!");
        return;
    }

    if (! emailLower.endsWith("@gmail.com")) {
        alert("Email không đúng định dạng!");
        return;
    }

    if (password.length < 8) {
        alert("Mật khẩu phải có ít nhất 8 ký tự!");
        return;
    }

    if (password !== confirmPassword) {
        alert("Mật khẩu xác nhận không khớp!");
        return;
    }

    const listUsers = JSON.parse(localStorage.getItem('users')) || [];

    const isExisted = listUsers.some(user => user.email === email);
    if (isExisted) {
        alert("Email này đã được đăng ký!");
        return;
    }

    const newUser = {
      id: listUsers.length > 0 ? listUsers[listUsers.length - 1].id + 1 : 1, 
      first_name: firstName,
      last_name: lastName,
      gender: 0, 
      date_of_birth: "", 
      address: "", 
      avatar: "https://example.com/avatar.jpg", 
      email: email,
      password: password,
      phone_number: "", 
      created_at: new Date().toISOString(), 
    };

    
    listUsers.push(newUser); 
    
    localStorage.setItem('users', JSON.stringify(listUsers));
    window.location.href = "login.html";
    alert("Đăng ký thành công!");
    
    registerForm.reset(); 
});