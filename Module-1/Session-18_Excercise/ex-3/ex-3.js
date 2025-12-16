// Khởi tạo dữ liệu mẫu và ID tự động tăng
let todos = [
    { id: 1, text: 'Xin việc', completed: true },
    { id: 2, text: 'Mua Manga', completed: true },
    { id: 3, text: 'Cưới vợ', completed: false },
    { id: 4, text: 'Mua xe hơi', completed: false },
    { id: 5, text: 'Học tiếng Nhật', completed: false },
    { id: 6, text: 'Đi du lịch vòng quanh thế giới', completed: false }
];
let nextId = 7; 

// Lấy các phần tử DOM cần thiết
const todoList = document.getElementById('todo-list');
const todoInput = document.getElementById('todo-input');
const addBtn = document.getElementById('add-btn');

// --- READ (R) ---
// Hàm hiển thị danh sách công việc ra giao diện
function renderTodos() {
    todoList.innerHTML = ''; // Xóa nội dung cũ
    
    todos.forEach(todo => {
        const item = document.createElement('div');
        item.classList.add('todo-item');
        if (todo.completed) {
            item.classList.add('completed');
        }
        item.setAttribute('data-id', todo.id); // Dùng data-id để thao tác CRUD
        
        item.innerHTML = `
            <span class="task-text">${todo.text}</span>
            ${todo.completed ? '<i class="fa-solid fa-check check-icon"></i>' : ''}
        `;

        // Gắn sự kiện để Cập nhật (Update) và Xóa (Delete)
        item.addEventListener('click', toggleComplete); // Cập nhật trạng thái
        item.addEventListener('dblclick', deleteTodo); // Xóa (Double-click)

        todoList.appendChild(item);
    });
}

// --- CREATE (C) ---
function addTodo() {
    const text = todoInput.value.trim();
    if (text === "") {
        alert("Vui lòng nhập tên công việc!");
        return;
    }

    const newTodo = {
        id: nextId++,
        text: text,
        completed: false
    };

    todos.push(newTodo);
    todoInput.value = ''; // Xóa nội dung input
    renderTodos(); // Cập nhật lại giao diện
}

addBtn.addEventListener('click', addTodo);
todoInput.addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
        addTodo();
    }
});


// --- UPDATE (U) ---
// ... (các hàm khác) ...

// --- UPDATE (U) ---
function toggleComplete(event) {
    const item = event.currentTarget; 
    const id = parseInt(item.getAttribute('data-id'));
    
    // Tìm và cập nhật trạng thái trong mảng dữ liệu
    const todoIndex = todos.findIndex(t => t.id === id);
    if (todoIndex > -1) {
        // Đảo ngược trạng thái completed
        todos[todoIndex].completed = !todos[todoIndex].completed; 
        renderTodos(); 
}

}

// --- DELETE (D) ---
function deleteTodo(event) {
    event.stopPropagation(); // Ngăn sự kiện click (toggleComplete) chạy
    const item = event.currentTarget;
    const id = parseInt(item.getAttribute('data-id'));

    if (confirm("Bạn có chắc chắn muốn xóa công việc này không?")) {
        // Tạo mảng mới không bao gồm id cần xóa
        todos = todos.filter(t => t.id !== id);
        renderTodos(); // Cập nhật lại giao diện
    }
}


// Khởi chạy ứng dụng lần đầu
renderTodos();