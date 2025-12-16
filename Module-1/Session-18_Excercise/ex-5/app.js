// Khởi tạo dữ liệu mẫu và ID tự động tăng
let students = [
    { id: 1, name: 'Linh', age: 18, className: 'A1' },
    { id: 2, name: 'Cường', age: 22, className: 'A1' }
];
let nextId = 3; 
let isEditing = false; // Biến cờ để kiểm tra chế độ đang là Thêm hay Sửa
let currentEditId = null; // ID của sinh viên đang được chỉnh sửa

// Lấy các phần tử DOM
const studentList = document.getElementById('student-list');
const nameInput = document.getElementById('student-name');
const ageInput = document.getElementById('student-age');
const classInput = document.getElementById('student-class');
const addEditBtn = document.getElementById('add-edit-btn');
const searchInput = document.getElementById('search-input');


// --- READ (R) & SEARCH ---
function renderStudents(data = students) {
    studentList.innerHTML = ''; // Xóa nội dung cũ

    data.forEach(student => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.className}</td>
            <td>
                <button class="edit-btn" data-id="${student.id}">Sửa</button>
                <button class="delete-btn" data-id="${student.id}">Xóa</button>
            </td>
        `;
        studentList.appendChild(row);
    });

    // Sau khi render xong, gắn lại sự kiện cho các nút Sửa/Xóa mới
    attachEventListeners();
}

function handleSearch() {
    const keyword = searchInput.value.toLowerCase().trim();
    if (keyword === '') {
        renderStudents(students);
        return;
    }
    
    // Lọc sinh viên theo tên
    const filteredStudents = students.filter(student => 
        student.name.toLowerCase().includes(keyword)
    );
    renderStudents(filteredStudents);
}

searchInput.addEventListener('input', handleSearch);


// --- CREATE (C) & UPDATE (U) ---
function handleAddEdit() {
    const name = nameInput.value.trim();
    const age = parseInt(ageInput.value);
    const className = classInput.value.trim();

    if (!name || !age || !className) {
        alert("Vui lòng điền đầy đủ thông tin!");
        return;
    }

    if (isEditing) {
        // Chế độ UPDATE
        const studentIndex = students.findIndex(s => s.id === currentEditId);
        if (studentIndex !== -1) {
            students[studentIndex].name = name;
            students[studentIndex].age = age;
            students[studentIndex].className = className;
        }
        
        // Reset về chế độ THÊM
        isEditing = false;
        currentEditId = null;
        addEditBtn.textContent = 'Thêm sinh viên';
    } else {
        // Chế độ CREATE
        const newStudent = {
            id: nextId++,
            name: name,
            age: age,
            className: className
        };
        students.push(newStudent);
    }

    // Xóa input và render lại
    nameInput.value = '';
    ageInput.value = '';
    classInput.value = '';
    renderStudents();
}

addEditBtn.addEventListener('click', handleAddEdit);


// --- UPDATE (Chuyển chế độ Sửa) ---
function startEdit(id) {
    const studentToEdit = students.find(s => s.id === id);
    if (studentToEdit) {
        // Đổ dữ liệu vào input
        nameInput.value = studentToEdit.name;
        ageInput.value = studentToEdit.age;
        classInput.value = studentToEdit.className;

        // Thiết lập biến cờ và ID
        isEditing = true;
        currentEditId = id;
        addEditBtn.textContent = 'Lưu chỉnh sửa';
        
        // Cuộn lên đầu trang để người dùng dễ nhìn
        window.scrollTo({ top: 0, behavior: 'smooth' });
        nameInput.focus();
    }
}

// --- DELETE (D) ---
function handleDelete(id) {
    if (confirm("Bạn có chắc chắn muốn xóa sinh viên này không?")) {
        // Lọc sinh viên có id khác với id cần xóa
        students = students.filter(s => s.id !== id);
        renderStudents();
    }
}

// Gắn sự kiện cho các nút Sửa và Xóa
function attachEventListeners() {
    document.querySelectorAll('.edit-btn').forEach(btn => {
        btn.onclick = () => startEdit(parseInt(btn.dataset.id));
    });
    
    document.querySelectorAll('.delete-btn').forEach(btn => {
        btn.onclick = () => handleDelete(parseInt(btn.dataset.id));
    });
}


// Khởi chạy ứng dụng lần đầu
renderStudents();