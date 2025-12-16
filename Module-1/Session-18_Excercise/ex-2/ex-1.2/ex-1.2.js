let tasks = [
    { id: 1, name: 'HTML', complete: false },
    { id: 2, name: 'CSS', complete: false },
    { id: 3, name: 'Basic of Javascript', complete: false },
    { id: 4, name: 'Node package Manager (npm)', complete: false },
    { id: 5, name: 'Git', complete: false }
];
let nextId = 6; 

function prompt(message) {

    console.log(`\n(Chờ người dùng nhập: ${message})`);
    return null; // Trả về null hoặc giá trị mẫu nếu không nhập thủ công
}

function displayTasks() {
    console.log("\n--- TOÀN BỘ CÁC KHÓA HỌC (STATUS) ---");
    tasks.forEach(task => {
        let status = task.complete ? "Complete: true" : "Complete: false";
        console.log(`${task.id}. ${task.name}\n   ${status}`);
    });
}

function handleMenu() {
    while (true) {
        console.log("\n--- MENU HỆ THỐNG TASK ---");
        console.log("C - Thêm khóa học mới và trạng thái hoàn thành");
        console.log("R - In toàn bộ các khóa học");
        console.log("U - Cập nhật tên và trạng thái hoàn thành (theo tên)");
        console.log("D - Xóa khóa học (theo tên)");
        console.log("E - Thoát chương trình");

        let input = prompt("Nhập 5 chữ cái C/R/U/D/E:").toUpperCase();

        if (input === 'E') {
            console.log("\nCảm ơn bạn đã đến với Rikkei Academy");
            break; // Thoát vòng lặp
        }

        switch (input) {
            case 'C': // Create
                let newName = prompt("Nhập tên khóa học mới:");
                let newComplete = prompt("Nhập trạng thái hoàn thành (true/false):").toLowerCase() === 'true';

                if (newName) {
                    tasks.push({ id: nextId++, name: newName, complete: newComplete });
                    displayTasks();
                } else {
                    console.log("Tên khóa học không được để trống.");
                }
                break;
            
            case 'R': // Read
                displayTasks();
                break;
            
            case 'U': // Update
                let updateName = prompt("Nhập tên khóa học cần UPDATE:");
                let taskToUpdate = tasks.find(task => task.name === updateName);

                if (taskToUpdate) {
                    let updatedNewName = prompt(`Nhập tên mới cho '${updateName}' (Để trống nếu không đổi):`);
                    if (updatedNewName) {
                        taskToUpdate.name = updatedNewName;
                    }
                    
                    let updatedCompleteStatus = prompt(`Nhập trạng thái hoàn thành mới (true/false) cho '${taskToUpdate.name}':`).toLowerCase();
                    if (updatedCompleteStatus === 'true' || updatedCompleteStatus === 'false') {
                        taskToUpdate.complete = updatedCompleteStatus === 'true';
                    }
                    console.log(`Đã cập nhật khóa học '${taskToUpdate.name}'.`);
                    displayTasks();
                } else {
                    console.log(`Không tìm thấy khóa học có tên '${updateName}'.`);
                }
                break;
            
            case 'D': // Delete
                let deleteName = prompt("Nhập tên khóa học cần XÓA:");
                let initialLength = tasks.length;
                
                // Dùng filter để tạo mảng mới chỉ giữ lại các task KHÔNG có tên cần xóa
                tasks = tasks.filter(task => task.name !== deleteName); 

                if (tasks.length < initialLength) {
                    console.log(`Đã xóa khóa học '${deleteName}'.`);
                    displayTasks();
                } else {
                    console.log(`Không tìm thấy khóa học có tên '${deleteName}' để xóa.`);
                }
                break;
                
            default:
                console.log("Lựa chọn không hợp lệ. Vui lòng nhập C, R, U, D, hoặc E.");
        }
    }
}


displayTasks();