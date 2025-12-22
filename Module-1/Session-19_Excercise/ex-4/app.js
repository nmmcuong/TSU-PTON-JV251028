const inputBox = document.querySelector(".inputField input");
const addBtn = document.querySelector(".inputField button");
const todoList = document.querySelector(".todoList");
const deleteAllBtn = document.querySelector(".footer button");

// Lần đầu tải trang
showTasks();

// Khi nhấn nút Thêm (+)
addBtn.onclick = () => {
    let userData = inputBox.value;
    if(userData.trim() != 0) { // Nếu không để trống
        let getLocalStorage = localStorage.getItem("New Todo");
        let listArr = getLocalStorage == null ? [] : JSON.parse(getLocalStorage);
        listArr.push(userData);
        localStorage.setItem("New Todo", JSON.stringify(listArr));
        showTasks();
        inputBox.value = ""; // Xóa ô nhập sau khi thêm
    }
}

// Hàm hiển thị danh sách
function showTasks() {
    let getLocalStorage = localStorage.getItem("New Todo");
    let listArr = getLocalStorage == null ? [] : JSON.parse(getLocalStorage);
    const pendingNumb = document.querySelector(".pendingTasks");
    pendingNumb.textContent = listArr.length; // Cập nhật số lượng task

    let newLiTag = '';
    listArr.forEach((element, index) => {
        newLiTag += `<li>${element} <span class="icon" onclick="deleteTask(${index})"><i class="fas fa-trash"></i></span></li>`;
    });
    todoList.innerHTML = newLiTag;
}

// Hàm xóa 1 task
function deleteTask(index) {
    let getLocalStorage = localStorage.getItem("New Todo");
    let listArr = JSON.parse(getLocalStorage);
    listArr.splice(index, 1); // Xóa phần tử tại vị trí index
    localStorage.setItem("New Todo", JSON.stringify(listArr));
    showTasks();
}

// Hàm xóa tất cả (Clear All)
deleteAllBtn.onclick = () => {
    localStorage.setItem("New Todo", JSON.stringify([]));
    showTasks();
}