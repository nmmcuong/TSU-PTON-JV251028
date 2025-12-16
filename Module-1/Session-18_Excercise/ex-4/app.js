// Lấy các phần tử DOM cần thiết
const textInput = document.getElementById('text-input');
const keyboardLayout = document.querySelector('.keyboard-layout');
const deleteBtn = document.getElementById('delete-btn');

// 1. Thêm ký tự khi nhấn vào phím
keyboardLayout.addEventListener('click', function(event) {
    // Kiểm tra xem phần tử được click có phải là nút bấm (class 'key') không
    if (event.target.classList.contains('key')) {
        const key = event.target;
        
        // Bỏ qua nếu là nút Xóa, vì nó có sự kiện riêng
        if (key.id === 'delete-btn') {
            return;
        }

        // Lấy nội dung của nút (ví dụ: 'A', 'B', 'Z', ...)
        const char = key.textContent.trim();

        // Thêm ký tự vào cuối giá trị hiện tại của input
        textInput.value += char;

        // Tập trung vào input để người dùng có thể tiếp tục gõ
        textInput.focus();
    }
});


// 2. Xử lý nút Xóa
deleteBtn.addEventListener('click', function() {
    let currentValue = textInput.value;
    
    if (currentValue.length > 0) {
        // Xóa ký tự cuối cùng bằng cách cắt chuỗi
        textInput.value = currentValue.slice(0, -1);
    }
    
    textInput.focus();
});


console.log("Bàn phím ảo đã sẵn sàng!");