// 1. Dữ liệu mẫu ban đầu (nếu Local Storage trống)
const initialCourses = [
    { id: 1, content: 'Learn Javascript Session 01', dueDate: '2023-04-17', status: 'Pending', assignedTo: 'Anh Bách' },
    { id: 2, content: 'Learn Javascript Session 02', dueDate: '2023-04-17', status: 'Pending', assignedTo: 'Lâm th' },
    { id: 3, content: 'Learn CSS Session 1', dueDate: '2023-04-17', status: 'Pending', assignedTo: 'Hiếu Ci ớt ớt' }
];

// 2. Khởi tạo dữ liệu từ Local Storage
let tasks = JSON.parse(localStorage.getItem('tasks')) || initialCourses;

const taskTableBody = document.getElementById('taskTableBody');
const taskForm = document.getElementById('taskForm');

// --- CHỨC NĂNG READ: Hiển thị danh sách ---
function renderTasks() {
    taskTableBody.innerHTML = ''; // Xóa bảng cũ
    tasks.forEach((task, index) => {
        taskTableBody.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${task.content}</td>
                <td>${task.dueDate}</td>
                <td>${task.status}</td>
                <td>${task.assignedTo}</td>
                <td>
                    <button onclick="editTask(${task.id})">Sửa</button>
                    <button onclick="deleteTask(${task.id})">Xóa</button>
                </td>
            </tr>
        `;
    });
    // Lưu vào Local Storage mỗi khi render (để cập nhật dữ liệu mới nhất)
    localStorage.setItem('tasks', JSON.stringify(tasks));
}

// --- CHỨC NĂNG CREATE & UPDATE ---
taskForm.addEventListener('submit', function(e) {
    e.preventDefault();
    
    const id = document.getElementById('taskId').value;
    const content = document.getElementById('content').value;
    const dueDate = document.getElementById('dueDate').value;
    const status = document.getElementById('status').value;
    const assignedTo = document.getElementById('assignedTo').value;

    if (id) {
        // Nếu có id -> Đang ở chế độ Sửa (Update)
        const index = tasks.findIndex(t => t.id == id);
        tasks[index] = { id: Number(id), content, dueDate, status, assignedTo };
    } else {
        // Nếu không có id -> Đang ở chế độ Thêm mới (Create)
        const newTask = {
            id: Date.now(), // Tạo id duy nhất bằng timestamp
            content, dueDate, status, assignedTo
        };
        tasks.push(newTask);
    }

    renderTasks();
    taskForm.reset();
    document.getElementById('taskId').value = ''; // Reset ID ẩn
});

// --- CHỨC NĂNG DELETE: Xóa công việc ---
function deleteTask(id) {
    if (confirm('Bạn có chắc chắn muốn xóa?')) {
        tasks = tasks.filter(task => task.id !== id);
        renderTasks();
    }
}

// --- CHỨC NĂNG UPDATE: Đưa dữ liệu lên form để sửa ---
function editTask(id) {
    const task = tasks.find(t => t.id === id);
    if (task) {
        document.getElementById('taskId').value = task.id;
        document.getElementById('content').value = task.content;
        document.getElementById('dueDate').value = task.dueDate;
        document.getElementById('status').value = task.status;
        document.getElementById('assignedTo').value = task.assignedTo;
        document.getElementById('submitBtn').innerText = 'Update';
    }
}

// Chạy lần đầu khi load trang
renderTasks();