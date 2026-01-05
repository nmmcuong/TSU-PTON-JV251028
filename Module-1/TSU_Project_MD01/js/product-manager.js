/* ==========================================================================
   1. KHỞI TẠO DỮ LIỆU MẪU (Sửa lại thuộc tính cho đồng nhất)
   ========================================================================== */
const initialProducts = [
  {
    id: 1,
    product_code: "SP001",
    product_name: "Apple iPhone 14 Pro Max 128GB",
    category_id: 1,
    stock: 100,
    price: 20000000,
    discount: 10,
    image: "https://picsum.photos/200/300?random=1",
    status: "ACTIVE",
    description: "Hàng chính hãng VN/A",
    created_at: new Date().toISOString(),
  },
  {
    id: 2,
    product_code: "SP002",
    product_name: "Macbook Air M2",
    category_id: 2,
    stock: 50,
    price: 28000000,
    discount: 5,
    image: "https://picsum.photos/200/300?random=2",
    status: "ACTIVE",
    description: "Chip M2 mạnh mẽ",
    created_at: new Date().toISOString(),
  },
  {
    id: 3,
    product_code: "SP003",
    product_name: "Samsung Galaxy S23 Ultra",
    category_id: 1,
    stock: 80,
    price: 24500000,
    discount: 15,
    image: "https://picsum.photos/200/300?random=3",
    status: "ACTIVE",
    description: "Camera 200MP siêu sắc nét",
    created_at: new Date().toISOString(),
  },
  {
    id: 4,
    product_code: "SP004",
    product_name: "iPad Pro M2 11 inch",
    category_id: 3,
    stock: 30,
    price: 21000000,
    discount: 0,
    image: "https://picsum.photos/200/300?random=4",
    status: "ACTIVE",
    description: "Màn hình Liquid Retina",
    created_at: new Date().toISOString(),
  },
  {
    id: 5,
    product_code: "SP005",
    product_name: "Sony WH-1000XM5",
    category_id: 4,
    stock: 120,
    price: 7500000,
    discount: 20,
    image: "https://picsum.photos/200/300?random=5",
    status: "ACTIVE",
    description: "Chống ồn đỉnh cao",
    created_at: new Date().toISOString(),
  },
  {
    id: 6,
    product_code: "SP006",
    product_name: "Dell XPS 13 Plus",
    category_id: 2,
    stock: 15,
    price: 45000000,
    discount: 5,
    image: "https://picsum.photos/200/300?random=6",
    status: "INACTIVE",
    description: "Thiết kế tương lai",
    created_at: new Date().toISOString(),
  },
  {
    id: 7,
    product_code: "SP007",
    product_name: "Apple Watch Series 8",
    category_id: 5,
    stock: 60,
    price: 9000000,
    discount: 8,
    image: "https://picsum.photos/200/300?random=7",
    status: "ACTIVE",
    description: "Theo dõi sức khỏe chuyên sâu",
    created_at: new Date().toISOString(),
  },
  {
    id: 8,
    product_code: "SP008",
    product_name: "AirPods Pro Gen 2",
    category_id: 4,
    stock: 200,
    price: 5900000,
    discount: 12,
    image: "https://picsum.photos/200/300?random=8",
    status: "ACTIVE",
    description: "Âm thanh không gian",
    created_at: new Date().toISOString(),
  },
  {
    id: 9,
    product_code: "SP009",
    product_name: "Logitech MX Master 3S",
    category_id: 6,
    stock: 45,
    price: 2500000,
    discount: 0,
    image: "https://picsum.photos/200/300?random=9",
    status: "ACTIVE",
    description: "Chuột công thái học cao cấp",
    created_at: new Date().toISOString(),
  },
  {
    id: 10,
    product_code: "SP010",
    product_name: "Kindle Paperwhite 5",
    category_id: 3,
    stock: 75,
    price: 3800000,
    discount: 5,
    image: "https://picsum.photos/200/300?random=10",
    status: "ACTIVE",
    description: "Máy đọc sách chống nước",
    created_at: new Date().toISOString(),
  },
  {
    id: 11,
    product_code: "SP011",
    product_name: "Samsung Galaxy Tab S9",
    category_id: 3,
    stock: 25,
    price: 18000000,
    discount: 10,
    image: "https://picsum.photos/200/300?random=11",
    status: "ACTIVE",
    description: "Kèm bút S-Pen quyền năng",
    created_at: new Date().toISOString(),
  },
  {
    id: 12,
    product_code: "SP012",
    product_name: "ASUS ROG Zephyrus G14",
    category_id: 2,
    stock: 10,
    price: 35000000,
    discount: 7,
    image: "https://picsum.photos/200/300?random=12",
    status: "ACTIVE",
    description: "Laptop gaming mỏng nhẹ",
    created_at: new Date().toISOString(),
  },
  {
    id: 13,
    product_code: "SP013",
    product_name: "Xiaomi 13 Pro",
    category_id: 1,
    stock: 40,
    price: 17000000,
    discount: 15,
    image: "https://picsum.photos/200/300?random=13",
    status: "ACTIVE",
    description: "Ống kính Leica chuyên nghiệp",
    created_at: new Date().toISOString(),
  },
  {
    id: 14,
    product_code: "SP014",
    product_name: "Google Pixel 7 Pro",
    category_id: 1,
    stock: 20,
    price: 15500000,
    discount: 0,
    image: "https://picsum.photos/200/300?random=14",
    status: "ACTIVE",
    description: "Android thuần khiết từ Google",
    created_at: new Date().toISOString(),
  },
  {
    id: 15,
    product_code: "SP015",
    product_name: "HP Envy x360",
    category_id: 2,
    stock: 35,
    price: 22000000,
    discount: 10,
    image: "https://picsum.photos/200/300?random=15",
    status: "ACTIVE",
    description: "Laptop xoay gập 360 độ",
    created_at: new Date().toISOString(),
  },
  {
    id: 16,
    product_code: "SP016",
    product_name: "Garmin Fenix 7",
    category_id: 5,
    stock: 15,
    price: 16500000,
    discount: 5,
    image: "https://picsum.photos/200/300?random=16",
    status: "ACTIVE",
    description: "Đồng hồ thể thao chuyên dụng",
    created_at: new Date().toISOString(),
  },
  {
    id: 17,
    product_code: "SP017",
    product_name: "Keychron K2 V2",
    category_id: 6,
    stock: 90,
    price: 1850000,
    discount: 10,
    image: "https://picsum.photos/200/300?random=17",
    status: "ACTIVE",
    description: "Bàn phím cơ không dây",
    created_at: new Date().toISOString(),
  },
  {
    id: 18,
    product_code: "SP018",
    product_name: "Nintendo Switch OLED",
    category_id: 7,
    stock: 55,
    price: 8200000,
    discount: 5,
    image: "https://picsum.photos/200/300?random=18",
    status: "ACTIVE",
    description: "Máy chơi game cầm tay",
    created_at: new Date().toISOString(),
  },
  {
    id: 19,
    product_code: "SP019",
    product_name: "Bose QuietComfort 45",
    category_id: 4,
    stock: 40,
    price: 6800000,
    discount: 15,
    image: "https://picsum.photos/200/300?random=19",
    status: "INACTIVE",
    description: "Sự thoải mái tối đa",
    created_at: new Date().toISOString(),
  },
  {
    id: 20,
    product_code: "SP020",
    product_name: "Surface Laptop 5",
    category_id: 2,
    stock: 18,
    price: 26000000,
    discount: 8,
    image: "https://picsum.photos/200/300?random=20",
    status: "ACTIVE",
    description: "Mỏng nhẹ thời thượng",
    created_at: new Date().toISOString(),
  },
  {
    id: 21,
    product_code: "SP021",
    product_name: "Canon EOS R6",
    category_id: 8,
    stock: 5,
    price: 55000000,
    discount: 0,
    image: "https://picsum.photos/200/300?random=21",
    status: "ACTIVE",
    description: "Máy ảnh Mirrorless chuyên nghiệp",
    created_at: new Date().toISOString(),
  },
  {
    id: 22,
    product_code: "SP022",
    product_name: "DJI Mini 3 Pro",
    category_id: 9,
    stock: 12,
    price: 19500000,
    discount: 10,
    image: "https://picsum.photos/200/300?random=22",
    status: "ACTIVE",
    description: "Flycam dưới 249g",
    created_at: new Date().toISOString(),
  },
  {
    id: 23,
    product_code: "SP023",
    product_name: "Samsung Galaxy Z Fold 5",
    category_id: 1,
    stock: 22,
    price: 38000000,
    discount: 12,
    image: "https://picsum.photos/200/300?random=23",
    status: "ACTIVE",
    description: "Đỉnh cao màn hình gập",
    created_at: new Date().toISOString(),
  },
  {
    id: 24,
    product_code: "SP024",
    product_name: "Marshall Emberton II",
    category_id: 10,
    stock: 65,
    price: 4200000,
    discount: 5,
    image: "https://picsum.photos/200/300?random=24",
    status: "ACTIVE",
    description: "Loa bluetooth cổ điển",
    created_at: new Date().toISOString(),
  }
];

if (!localStorage.getItem("products")) {
  localStorage.setItem("products", JSON.stringify(initialProducts));
}

/* ==========================================================================
   2. BIẾN TOÀN CỤC & DOM
   ========================================================================== */
let currentPage = 1;
const rowsPerPage = 8; // Chỉnh lại để dễ test phân trang
let productToDeleteId = null;

const productTableBody = document.getElementById("productTableBody");
const productPagination = document.getElementById("productPagination");
const searchInput = document.getElementById("searchProduct");
const filterStatus = document.getElementById("filterStatus");
const filterCategory = document.getElementById("filterCategory");

const modal = document.getElementById("productModal");
const productForm = document.getElementById("productForm");
const btnOpenAdd = document.getElementById("btnOpenAddProduct");
const categoryInForm = document.getElementById("productCategorySelect");

const deleteModal = document.getElementById("deleteConfirmModal");
const deleteNameSpan = document.getElementById("deleteProductName");

/* ==========================================================================
   3. HÀM BỔ TRỢ (Sửa lỗi lọc và hiển thị)
   ========================================================================== */

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

        <div class="toast-close" onclick="this.parentElement.remove()">&times;</div>`;

  container.appendChild(toast);

  setTimeout(() => {
    toast.style.animation = "slideInLeft 0.5s ease reverse forwards";

    setTimeout(() => toast.remove(), 500);
  }, 3000);
}

function clearErrors() {
  document
    .querySelectorAll(".error-msg")
    .forEach((el) => (el.style.display = "none"));
  document
    .querySelectorAll("input")
    .forEach((el) => el.classList.remove("error-border"));
}

// Sửa lỗi loadCategories: Lấy từ danh sách danh mục thực tế (nếu có)
function loadCategories() {
  // 1. Lấy danh sách danh mục gốc (có chứa ID và Name)
  const categoryData = JSON.parse(localStorage.getItem("categories")) || [];

  // 2. Lấy danh sách sản phẩm để biết ID nào đang tồn tại (tùy chọn)
  const allProducts = JSON.parse(localStorage.getItem("products")) || [];
  const activeCatIds = [...new Set(allProducts.map((p) => p.category_id))];

  // Reset dropdowns
  filterCategory.innerHTML = '<option value="all">Lọc theo danh mục</option>';
  //categoryInForm.innerHTML = '<option value="">Chọn danh mục</option>';

  // 3. Hiển thị tên danh mục
  categoryData.forEach((cat) => {
    // Thêm vào dropdown trong Form Thêm/Sửa (luôn hiện tất cả danh mục)
    categoryInForm.add(new Option(cat.category_name, cat.id));

    // Thêm vào dropdown Lọc (chỉ hiện danh mục nào có sản phẩm - tùy bạn chọn)
    if (activeCatIds.includes(Number(cat.id))) {
      filterCategory.add(new Option(cat.category_name, cat.id));
    }
  });
}

function validateProduct(data, isEdit = false) {
  let isValid = true;
  clearErrors();
  if (!data.product_code) {
    document.getElementById("errorId").style.display = "block";
    isValid = false;
  }
  if (!data.product_name) {
    document.getElementById("errorName").style.display = "block";
    isValid = false;
  }
  return isValid;
}

/* ==========================================================================
   4. EDIT / DELETE / SAVE (Sửa lỗi logic)
   ========================================================================== */

function editProduct(id) {
  const allProducts = JSON.parse(localStorage.getItem("products")) || [];
  const product = allProducts.find((item) => item.id == id);
  if (!product) return;

  document.getElementById("modalTitle").innerText = "Cập nhật sản phẩm";

  // Đổ dữ liệu (Sửa đúng tên thuộc tính)
  document.getElementById("editProductId").value = product.id;
  document.getElementById("productId").value = product.product_code;
  document.getElementById("productId").disabled = true;
  document.getElementById("productName").value = product.product_name;
  document.getElementById("productCategorySelect").value = product.category_id;
  document.getElementById("productQuantity").value = product.stock;
  document.getElementById("productPrice").value = product.price;
  document.getElementById("productDiscount").value = product.discount; // Bỏ .replace()
  document.getElementById("productImage").value = product.image || "";
  document.getElementById("productDesc").value = product.description || "";

  document.querySelectorAll('input[name="status"]').forEach((r) => {
    r.checked = r.value === product.status;
  });

  clearErrors();
  modal.style.display = "flex";
}

function deleteProduct(id) {
  const allProducts = JSON.parse(localStorage.getItem("products")) || [];
  const product = allProducts.find((p) => p.id == id);
  if (product) {
    productToDeleteId = id;
    deleteNameSpan.innerText = product.product_name; // Sửa name -> product_name
    deleteModal.style.display = "flex";
  }
}

document.getElementById("btnConfirmDelete").onclick = () => {
  if (productToDeleteId) {
    let allProducts = JSON.parse(localStorage.getItem("products")) || [];
    allProducts = allProducts.filter((p) => p.id != productToDeleteId);
    localStorage.setItem("products", JSON.stringify(allProducts));
    renderProductTable();
    deleteModal.style.display = "none";
    showToast("Thành công", "Đã xóa sản phẩm");
  }
};

/* ==========================================================================
   5. RENDER GIAO DIỆN (Sửa lỗi hiển thị)
   ========================================================================== */

function renderProductTable() {
  const allProducts = JSON.parse(localStorage.getItem("products")) || [];
  const keyword = searchInput.value.toLowerCase().trim();
  const selectedStatus = filterStatus.value;
  const selectedCategory = filterCategory.value;

  let filtered = allProducts.filter((item) => {
    const mSearch = item.product_name.toLowerCase().includes(keyword);

    // Sửa tại đây: Dùng .toUpperCase() để so sánh chuẩn xác
    const mStatus =
      selectedStatus.toUpperCase() === "ALL"
        ? true
        : item.status === selectedStatus;

    // Sửa tại đây: Lọc theo category_id thay vì id sản phẩm
    const mCategory =
      selectedCategory.toUpperCase() === "ALL"
        ? true
        : item.category_id == selectedCategory;

    return mSearch && mStatus && mCategory;
  });

  const start = (currentPage - 1) * rowsPerPage;
  const pItems = filtered.slice(start, start + rowsPerPage);

  productTableBody.innerHTML =
    pItems.length === 0
      ? `<tr><td colspan="7" style="text-align:center">Không tìm thấy sản phẩm</td></tr>`
      : pItems
          .map(
            (item) => `
        <tr>
            <td>${item.product_code}</td>
            <td>${item.product_name}</td>
            <td>${Number(item.price).toLocaleString("vi-VN")} đ</td>
            <td>${item.stock}</td>
            <td>${item.discount}%</td>
            <td><span class="status ${item.status.toLowerCase()}">${
              item.status === "ACTIVE" ? "Đang hoạt động" : "Ngừng hoạt động"
            }</span></td>
            <td class="actions">
              <i class="fa-solid btn-delete" onclick="deleteProduct(${
                item.id
              })"><img src="..//public/icon/trash.png" alt=""></i>
              <i class="fa-solid btn-edit" onclick="editProduct(${
                item.id
              })"><img src="..//public/icon/pencil.png" alt=""></i>
            </td>
        </tr>`
          )
          .join("");

  renderPagination(filtered.length);
}

function renderPagination(totalItems) {
  productPagination.innerHTML = "";
  const totalPages = Math.ceil(totalItems / rowsPerPage) || 1;
  const prevBtn = document.createElement("button");
  prevBtn.className = "page-btn";
  prevBtn.innerHTML = '<i class="fa-solid fa-arrow-left"></i>';
  prevBtn.disabled = currentPage === 1;
  prevBtn.onclick = () => {
    currentPage--;
    renderProductTable();
  };

  productPagination.appendChild(prevBtn);
  for (let i = 1; i <= totalPages; i++) {
    const pageBtn = document.createElement("button");
    pageBtn.className = `page-btn ${i === currentPage ? "active" : ""}`;
    pageBtn.innerText = i;
    pageBtn.onclick = () => {
      currentPage = i;
      renderProductTable();
    };

    productPagination.appendChild(pageBtn);
  }

  const nextBtn = document.createElement("button");
  nextBtn.className = "page-btn";
  nextBtn.innerHTML = '<i class="fa-solid fa-arrow-right"></i>';
  nextBtn.disabled = currentPage === totalPages;
  nextBtn.onclick = () => {
    currentPage++;
    renderProductTable();
  };

  productPagination.appendChild(nextBtn);
}

/* ==========================================================================
   6. EVENT LISTENERS
   ========================================================================== */

btnOpenAdd.onclick = () => {
  document.getElementById("modalTitle").innerText = "Thêm mới sản phẩm";
  document.getElementById("btnSave").innerText = "Thêm";
  document.getElementById("productId").disabled = false;
  document.getElementById("editProductId").value = ""; // Reset trạng thái sửa
  productForm.reset();
  clearErrors();
  modal.style.display = "flex";
};





productForm.onsubmit = (e) => {
  e.preventDefault();
  let allProducts = JSON.parse(localStorage.getItem("products")) || [];
  const editId = document.getElementById("editProductId").value;

  const productData = {
    id: editId
      ? Number(editId)
      : allProducts.length > 0
      ? allProducts[allProducts.length - 1].id + 1
      : 1,
    product_code: document.getElementById("productId").value.trim(),
    product_name: document.getElementById("productName").value.trim(),
    category_id: Number(document.getElementById("productCategorySelect").value),
    status: document.querySelector('input[name="status"]:checked').value,
    stock: Number(document.getElementById("productQuantity").value) || 0,
    price: Number(document.getElementById("productPrice").value) || 0,
    discount: Number(document.getElementById("productDiscount").value) || 0,
    image: document.getElementById("productImage").value.trim(),
    description: document.getElementById("productDesc").value.trim(),
    created_at: editId
      ? allProducts.find((p) => p.id == editId).created_at
      : new Date().toISOString(),
  };

  if (!validateProduct(productData, !!editId)) return;

  if (editId) {
    const index = allProducts.findIndex((p) => p.id == editId);
    allProducts[index] = productData;
  } else {
    allProducts.push(productData);
  }

  localStorage.setItem("products", JSON.stringify(allProducts));
  modal.style.display = "none";
  renderProductTable();
};

// Đóng modal
document.getElementById("btnCancel").onclick = () =>
  (modal.style.display = "none");

document.getElementById("btnClose").onclick = () =>
  (modal.style.display = "none");

document.getElementById("btnCancelDelete").onclick = () =>
  (deleteModal.style.display = "none");

document.addEventListener("DOMContentLoaded", () => {
  loadCategories();
  renderProductTable();
});

filterStatus.addEventListener("change", () => {
  currentPage = 1; // Luôn về trang 1 khi lọc
  renderProductTable();
});

filterCategory.addEventListener("change", () => {
  currentPage = 1;
  renderProductTable();
});

searchInput.addEventListener("input", () => {
  currentPage = 1;
  renderProductTable();
});