const profileGroup = document.getElementById("profileGroup");
const dropdownLogout = document.getElementById("dropdownLogout");

// 1. Click vào avatar để hiện/ẩn menu
profileGroup.addEventListener("click", function (e) {
  e.stopPropagation(); // Ngăn sự kiện nổi bọt
  dropdownLogout.classList.toggle("show");
});

// 2. Click ra ngoài để đóng menu
window.addEventListener("click", function () {
  if (dropdownLogout.classList.contains("show")) {
    dropdownLogout.classList.remove("show");
  }
});
