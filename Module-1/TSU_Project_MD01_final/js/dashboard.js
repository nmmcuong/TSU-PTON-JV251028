<<<<<<< HEAD
document.addEventListener('DOMContentLoaded', function() {
    const logoutLink = document.querySelector('#logoutDropdown .logout-link');
    
    const logoutModal = document.getElementById('logoutModal');
    const btnCancel = document.getElementById('btnCancelLogout');
    const btnConfirm = document.getElementById('btnConfirmLogout');

    if (logoutLink) {
        logoutLink.addEventListener('click', function(e) {
            e.preventDefault(); 
            logoutModal.style.display = 'flex'; 
        });
    }

    // Nút Hủy bỏ: Đóng modal
    btnCancel.addEventListener('click', function() {
        logoutModal.style.display = 'none';
    });

    // Nút Xác nhận: Chuyển hướng
    btnConfirm.addEventListener('click', function() {
        window.location.href = '../pages/login.html';
    });
=======
document.addEventListener('DOMContentLoaded', function() {
    const logoutLink = document.querySelector('#logoutDropdown .logout-link');
    
    const logoutModal = document.getElementById('logoutModal');
    const btnCancel = document.getElementById('btnCancelLogout');
    const btnConfirm = document.getElementById('btnConfirmLogout');

    if (logoutLink) {
        logoutLink.addEventListener('click', function(e) {
            e.preventDefault(); 
            logoutModal.style.display = 'flex'; 
        });
    }

    // Nút Hủy bỏ: Đóng modal
    btnCancel.addEventListener('click', function() {
        logoutModal.style.display = 'none';
    });

    // Nút Xác nhận: Chuyển hướng
    btnConfirm.addEventListener('click', function() {
        window.location.href = '../pages/login.html';
    });
>>>>>>> af7eab56334c3ecae8ce3f3e8e96e87d1c474475
});