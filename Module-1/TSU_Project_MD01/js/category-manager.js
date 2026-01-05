// 1. Khởi tạo dữ liệu mẫu nếu LocalStorage trống
let currentPage = 1; 
let idToDelete = null; 

const rowsPerPage = 8; // Số lượng dòng trên mỗi trang
if (!localStorage.getItem("categories")) {
  const defaultData = [
    {
      id: 1,
      category_code: "DM001",
      category_name: "Quần áo",
      image: "https://example.com/clothes.jpg",
      status: "ACTIVE",
      created_at: new Date().toISOString(),
    },
    {
      id: 2,
      category_code: "DM002",
      category_name: "Kính mắt",
      image: "https://example.com/glasses.jpg",
      status: "INACTIVE",
      created_at: new Date().toISOString(),
    },
  ];
  localStorage.setItem("categories", JSON.stringify(defaultData));
}

// Các phần tử DOM
const modalAdd = document.getElementById("modalAdd");
const btnOpen = document.querySelector(".btn-primary"); 
const btnClose = document.getElementById("btnClose");
const btnCancel = document.getElementById("btnCancel");

const formAdd = document.getElementById("formAddCategory");
const tableBody = document.querySelector("tbody");
const searchInput = document.getElementById("searchInput");
const filterStatus = document.getElementById("filterStatus");

const modalConfirm = document.getElementById("modalConfirm");
const btnCancelDelete = document.getElementById("btnCancelDelete");
const btnConfirmDelete = document.getElementById("btnConfirmDelete");
const deleteTargetName = document.getElementById("deleteTargetName");


searchInput.addEventListener("input", () => {
  currentPage = 1; // Luôn reset về trang 1 khi tìm kiếm
  renderTable();
});

filterStatus.addEventListener("change", () => {
  currentPage = 1; // Reset về trang 1 khi lọc
  renderTable();
});

// 2. Sự kiện hiển thị Modal khi click vào nút Thêm mới
btnOpen.addEventListener("click", function() {
    // Thêm class 'show' để hiện modal (kết hợp với CSS display: flex)
    modalAdd.classList.add("show");
});

// 3. Sự kiện đóng Modal khi click vào dấu X hoặc nút Hủy
const closeModal = () => {
    modalAdd.classList.remove("show");
};

btnClose.addEventListener("click", closeModal);
btnCancel.addEventListener("click", closeModal);

// 4. (Tùy chọn) Đóng modal khi click ra ngoài vùng form
window.addEventListener("click", function(event) {
    if (event.target == modalAdd) {
        closeModal();
    }
});

// 2. Hàm hiển thị dữ liệu ra bảng
function renderTable() {
  const allCategories = JSON.parse(localStorage.getItem("categories")) || [];
  const tableBody = document.querySelector("tbody");

  // 1. Lấy giá trị từ các ô nhập liệu
  const keyword = searchInput.value
    ? searchInput.value.trim().toLowerCase()
    : "";
  const selectedStatus = filterStatus.value || "ALL"; // ALL, ACTIVE, INACTIVE
  // 2. LOGIC LỌC ĐA NĂNG (Tìm kiếm + Trạng thái)
  let filteredData = allCategories.filter((item) => {
    // Kiểm tra khớp tên (không phân biệt hoa thường)
    const matchesSearch = item.category_name.toLowerCase().includes(keyword);

    // Kiểm tra khớp trạng thái
    const matchesStatus =
      selectedStatus === "ALL" ? true : item.status === selectedStatus;

    // Chỉ giữ lại những mục thỏa mãn cả 2 điều kiện
    return matchesSearch && matchesStatus;
  });

  // 3. LOGIC PHÂN TRANG
  const startIndex = (currentPage - 1) * rowsPerPage;
  const endIndex = startIndex + rowsPerPage;
  const paginatedItems = filteredData.slice(startIndex, endIndex);

  // 4. VẼ BẢNG
  tableBody.innerHTML = "";
  if (paginatedItems.length === 0) {
    tableBody.innerHTML = `<tr><td colspan="4" style="text-align:center; padding: 20px;">Không tìm thấy kết quả phù hợp</td></tr>`;
  } else {
    paginatedItems.forEach((item) => {
      const row = `
                <tr>
                    <td>${item.category_code}</td>
                    <td>${item.category_name}</td>
                    <td>
                        <span class="status ${item.status.toLowerCase()}">
                            ${
                              item.status === "ACTIVE"
                                ? "Đang hoạt động"
                                : "Ngừng hoạt động"
                            }
                        </span>
                    </td>
                    <td class="actions">
                        <i class="fa-solid btn-delete" onclick="deleteCategory('${
                          item.id
                        }')"><img src="..//public/icon/trash.png" alt=""></i>
                        <i class="fa-solid btn-edit" onclick="editCategory('${
                          item.id
                        }')"><img src="..//public/icon/pencil.png" alt=""></i>
                    </td>
                </tr>
            `;
      tableBody.innerHTML += row;
    });
  }

  // 5. CẬP NHẬT PHÂN TRANG
  renderPagination(filteredData.length);
}

// function renderPagination(totalItems) {
//   const paginationContainer = document.querySelector(".pagination");
//   paginationContainer.innerHTML = "";

//   const totalPages = Math.ceil(totalItems / rowsPerPage);

//   // Nút Previous
//   const prevBtn = document.createElement("button");
//   prevBtn.className = "page-btn";
//   prevBtn.innerHTML = '<i class="fa-solid fa-arrow-left"></i>';
//   prevBtn.disabled = currentPage === 1;
//   prevBtn.onclick = () => {
//     currentPage--;
//     renderTable();
//   };
//   paginationContainer.appendChild(prevBtn);

//   // Các nút số trang
//   for (let i = 1; i <= totalPages; i++) {
//     const pageBtn = document.createElement("button");
//     pageBtn.className = `page-btn ${i === currentPage ? "active" : ""}`;
//     pageBtn.innerText = i;
//     pageBtn.onclick = () => {
//       currentPage = i;
//       renderTable();
//     };
//     paginationContainer.appendChild(pageBtn);
//   }

//   // Nút Next
//   const nextBtn = document.createElement("button");
//   nextBtn.className = "page-btn";
//   nextBtn.innerHTML = '<i class="fa-solid fa-arrow-right"></i>';
//   nextBtn.disabled = currentPage === totalPages;
//   nextBtn.onclick = () => {
//     currentPage++;
//     renderTable();
//   };
//   paginationContainer.appendChild(nextBtn);
// }

function renderPagination(totalItems) {
  const paginationContainer = document.querySelector(".pagination");
  paginationContainer.innerHTML = "";

  const totalPages = Math.ceil(totalItems / rowsPerPage);

  // Nút Previous
  const prevBtn = document.createElement("button");
  prevBtn.className = "page-btn";
  prevBtn.innerHTML = '<i class="fa-solid fa-arrow-left"></i>';
  prevBtn.disabled = currentPage === 1;
  prevBtn.onclick = () => {
    currentPage--;
    renderTable();
  };
  paginationContainer.appendChild(prevBtn);

  // Các nút số trang
  for (let i = 1; i <= totalPages; i++) {
    const pageBtn = document.createElement("button");
    pageBtn.className = `page-btn ${i === currentPage ? "ACTIVE" : ""}`;
    pageBtn.innerText = i;
    pageBtn.onclick = () => {
      currentPage = i;
      renderTable();
    };
    paginationContainer.appendChild(pageBtn);
  }

  // Nút Next
  const nextBtn = document.createElement("button");
  nextBtn.className = "page-btn";
  nextBtn.innerHTML = '<i class="fa-solid fa-arrow-right"></i>';
  nextBtn.disabled = currentPage === totalPages;
  nextBtn.onclick = () => {
    currentPage++;
    renderTable();
  };
  paginationContainer.appendChild(nextBtn);
}

// 3. Xử lý mở/đóng Modal
btnOpen.onclick = () => modalAdd.classList.add("show");
btnClose.onclick = btnCancel.onclick = () => modalAdd.classList.remove("show");

// 4. Xử lý thêm mới từ Form
formAdd.onsubmit = (e) => {
    e.preventDefault();

    // 1. Lấy các phần tử input và thẻ lỗi
    const catIdInput = document.getElementById("catId");
    const catNameInput = document.getElementById("catName");
    const catIdError = document.getElementById("catIdError");
    const catNameError = document.getElementById("catNameError");

    // Lấy giá trị
    //const catCodeValue = catIdInput.value.trim();
    const catIdValue = catIdInput.value.trim();
    const catNameValue = catNameInput.value.trim();
    const statusValue = document.querySelector(
        'input[name="status"]:checked'
    ).value;

    let isValid = true;

    // 2. Validate Mã danh mục
    if (catIdValue === "") {
        catIdError.innerText = "Mã danh mục không được để trống";
        catIdError.style.display = "block";
        catIdInput.classList.add("input-error");
        isValid = false;
    } else {
        catIdError.style.display = "none";
        catIdInput.classList.remove("input-error");
    }

    // 3. Validate Tên danh mục
    if (catNameValue === "") {
        catNameError.innerText = "Tên danh mục không được để trống";
        catNameError.style.display = "block";
        catNameInput.classList.add("input-error");
        isValid = false;
    } else {
        catNameError.style.display = "none";
        catNameInput.classList.remove("input-error");
    }

    // 4. Nếu hợp lệ thì mới tiến hành lưu
    if (isValid) {
        const categories = JSON.parse(localStorage.getItem("categories")) || [];

        // Kiểm tra trùng ID (Validate logic nghiệp vụ)
        if (categories.some((c) => c.id === catIdValue)) {
        catIdError.innerText = "Mã danh mục đã tồn tại!";
        catIdError.style.display = "block";
        catIdInput.classList.add("input-error");
        return;
        }

        const newCategory = {
          id:
            categories.length > 0
              ? categories[categories.length - 1].id + 1
              : 1,
          category_code: catIdValue,
          category_name: catNameValue,
          image: "https://example.com/default.jpg",
          status: statusValue,
          created_at: new Date().toISOString(),
        };

        categories.push(newCategory);
        localStorage.setItem("categories", JSON.stringify(categories));

        // Reset và đóng modal
        renderTable();
        formAdd.reset();
        modalAdd.classList.remove("show");
    }
};

// Bonus: Xóa thông báo lỗi khi người dùng bắt đầu gõ lại
document.getElementById("catId").oninput = function () {
  this.classList.remove("input-error");
  document.getElementById("catIdError").style.display = "none";
};
document.getElementById("catName").oninput = function () {
  this.classList.remove("input-error");
  document.getElementById("catNameError").style.display = "none";
};

// // 5. Hàm xóa danh mục
// function deleteCategory(id) {
//   if (confirm("Bạn có chắc chắn muốn xóa?")) {
//     let categories = JSON.parse(localStorage.getItem("categories"));
//     categories = categories.filter((c) => c.id !== id);
//     localStorage.setItem("categories", JSON.stringify(categories));
//     renderTable();
//   }
// }

function deleteCategory(id) {
  idToDelete = Number(id);
  const categories = JSON.parse(localStorage.getItem("categories"));
  const category = categories.find((c) => c.id == id);

  // Hiển thị tên danh mục vào câu hỏi
  deleteTargetName.innerText = category.category_name;;
  modalConfirm.classList.add("show");
}

// 2. Nút Hủy trong modal xác nhận
btnCancelDelete.onclick = () => {
  modalConfirm.classList.remove("show");
  idToDelete = null;
};

function showToast(title, message) {
  const container = document.getElementById("toast-container");
  const toast = document.createElement("div");
  toast.className = "toast";

  toast.innerHTML = `
        <div class="toast-icon"><i class="fa-solid fa-check"></i></div>
        <div class="toast-content">
            <div class="toast-title">${title}</div>
            <div class="toast-msg">${message}</div>
        </div>
        <div class="toast-close" onclick="this.parentElement.remove()">&times;</div>
    `;

  container.appendChild(toast);

  // Tự động xóa thông báo sau 3 giây
  setTimeout(() => {
    toast.style.animation = "slideInLeft 0.5s ease reverse forwards";
    setTimeout(() => toast.remove(), 500);
  }, 3000);
}

// CẬP NHẬT HÀM XÁC NHẬN XÓA (Nút thực sự xóa)
btnConfirmDelete.onclick = () => {
  if (idToDelete) {
    let categories = JSON.parse(localStorage.getItem("categories"));
    categories = categories.filter((c) => c.id !== idToDelete);
    localStorage.setItem("categories", JSON.stringify(categories));

    renderTable(); // Vẽ lại bảng
    modalConfirm.classList.remove("show"); // Đóng modal xác nhận

    // Gọi thông báo thành công ở đây
    showToast("Thành công", "Xóa sản phẩm thành công");

    idToDelete = null;
  }
};

const modalEdit = document.getElementById("modalEdit");
const formEdit = document.getElementById("formEditCategory");

// 1. Hàm mở Modal Sửa và đổ dữ liệu cũ vào form
function editCategory(id) {
  console.log("Đang sửa ID:", id); // Kiểm tra xem hàm có chạy khi bấm nút không
  const categories = JSON.parse(localStorage.getItem("categories")) || [];
  const category = categories.find((c) => c.id == Number(id));

  if (category) {
    // Đổ dữ liệu vào các ô input
    document.getElementById("editCatId").value = category.id;
    document.getElementById("editCatName").value = category.category_name;

    const activeRadio = document.getElementById("editStatusActive");
    const inactiveRadio = document.getElementById("editStatusInactive");

    if (activeRadio && inactiveRadio) {
      // Kiểm tra nếu phần tử tồn tại mới gán
      if (category.status === "ACTIVE") {
        activeRadio.checked = true;
      } else {
        inactiveRadio.checked = true;
      }
    }

    // Hiện modal
    modalEdit.classList.add("show");
  }
}

// 2. Đóng modal sửa
document.getElementById("btnCloseEdit").onclick = document.getElementById(
  "btnCancelEdit"
).onclick = () => {
  modalEdit.classList.remove("show");
};

// 3. Xử lý lưu dữ liệu sau khi sửa
formEdit.onsubmit = (e) => {
  e.preventDefault();

  // 1. Lấy giá trị và ép kiểu ID về số để so sánh chính xác
  const id = Number(document.getElementById("editCatId").value);
  const newName = document.getElementById("editCatName").value.trim();

  // Lưu ý: Kiểm tra ID của Radio Status trong Modal Edit đã đúng chưa
  const statusElement = document.querySelector(
    'input[name="editStatus"]:checked'
  );
  const newStatus = statusElement ? statusElement.value : "ACTIVE";

  // 2. Validate
  const nameError = document.getElementById("editCatNameError");
  if (newName === "") {
    nameError.innerText = "Tên danh mục không được để trống";
    nameError.style.display = "block";
    document.getElementById("editCatName").classList.add("input-error");
    return;
  }

  // 3. Tìm và cập nhật mảng
  let categories = JSON.parse(localStorage.getItem("categories")) || [];
  const index = categories.findIndex((c) => Number(c.id) === id); // Ép kiểu cả 2 bên cho chắc chắn

  if (index !== -1) {
    // Cập nhật đúng tên thuộc tính trong dữ liệu mẫu
    categories[index].category_name = newName;
    categories[index].status = newStatus;

    localStorage.setItem("categories", JSON.stringify(categories));

    // 4. Cập nhật giao diện
    renderTable();
    modalEdit.classList.remove("show");
    showToast("Thành công", "Cập nhật danh mục thành công");
  } else {
    console.error("Không tìm thấy danh mục có ID:", id);
  }
};




// Chạy lần đầu khi load trang
window.onload = () => {
  renderTable();
};
