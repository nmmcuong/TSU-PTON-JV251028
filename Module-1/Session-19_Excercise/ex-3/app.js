let showPassword = document.querySelector('.show-password');
let inputPassword = document.querySelector('#password');

// Sử dụng toán tử ba ngôi (ternary operator) để rút gọn logic ẩn/hiện password
showPassword.onclick = () => {
    const isPassword = inputPassword.getAttribute('type') === 'password';
    inputPassword.setAttribute('type', isPassword ? 'text' : 'password');
};

let users = JSON.parse(localStorage.getItem('users')) || [];
let form = document.getElementById('form');
let errorEmail = document.querySelector('.error-email');
let errorPassword = document.querySelector('.error-password');

// Sử dụng addEventListener thay vì onsubmit để code sạch sẽ hơn
form.addEventListener('submit', (e) => {
    e.preventDefault();
    
    if (validateData(form)) {
        const isAuth = checkEmailAndPassword(form.email.value, form.password.value);
        if (isAuth) {
            alert('Đăng nhập thành công');
            // Bạn có thể thêm lệnh chuyển trang tại đây: window.location.href = "index.html";
        } else {
            alert('Email hoặc mật khẩu sai');
        }
    }
});

// Giữ nguyên logic tìm kiếm user trong mảng
function checkEmailAndPassword(email, password) {
    return users.some((el) => el.email === email && el.password === password);
}

function validateData(form) {
    let check = true;
    const emailVal = form.email.value;
    const passVal = form.password.value;

    // Validate email
    if (emailVal === '') {
        errorEmail.innerText = 'Email không được để trống';
        check = false;
    } else if (!validEmail(emailVal)) {
        errorEmail.innerText = 'Email không hợp lệ';
        check = false;
    } else {
        errorEmail.innerText = '';
    }

    // Validate password
    if (passVal === '') {
        errorPassword.innerText = 'Password không được để trống';
        check = false;
    } else if (!validPassword(passVal)) {
        errorPassword.innerText = 'Password không hợp lệ';
        check = false;
    } else {
        errorPassword.innerText = '';
    }

    return check;
}

// Giữ nguyên các hàm Regex để kiểm tra định dạng
function validEmail(email) {
    return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email);
}

function validPassword(password) {
    return /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(password);
}