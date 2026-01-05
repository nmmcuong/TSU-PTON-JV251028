window.onload = function () {
  const container = document.querySelector(".slider-container");
  const slides = document.querySelectorAll(".hero-item");
  const nextBtn = document.querySelector(".next-btn");
  const prevBtn = document.querySelector(".prev-btn");
  const dots = document.querySelectorAll(".dot");

  let counter = 0;
  const totalSlides = slides.length;

  function updateSlider() {
    // Di chuyển container dựa trên index (counter)
    container.style.transform = `translateX(${-counter * 100}%)`;

    // Cập nhật trạng thái chấm tròn (dots)
    dots.forEach((dot) => dot.classList.remove("active"));
    if (dots[counter]) {
      dots[counter].classList.add("active");
    }
  }

  // Sự kiện nút Next
  nextBtn.addEventListener("click", () => {
    counter++;
    if (counter >= totalSlides) {
      counter = 0; // Quay lại slide đầu tiên
    }
    updateSlider();
  });

  // Sự kiện nút Prev
  prevBtn.addEventListener("click", () => {
    counter--;
    if (counter < 0) {
      counter = totalSlides - 1; // Nhảy tới slide cuối cùng
    }
    updateSlider();
  });

  // Cho phép click vào từng chấm tròn để chuyển slide
  dots.forEach((dot, index) => {
    dot.addEventListener("click", () => {
      counter = index;
      updateSlider();
    });
  });

  // Tự động chạy (Auto-play) - 5 giây chuyển 1 lần
  let autoSlide = setInterval(() => {
    nextBtn.click();
  }, 5000);

  // Dừng tự động chạy khi người dùng di chuột vào slider
  const sliderArea = document.querySelector(".hero-slider");
  sliderArea.addEventListener("mouseenter", () => clearInterval(autoSlide));
  sliderArea.addEventListener("mouseleave", () => {
    autoSlide = setInterval(() => {
      nextBtn.click();
    }, 5000);
  });
};

// document.addEventListener("DOMContentLoaded", function () {
//   const track = document.getElementById("categoryContainer");
//   const nextBtn = document.querySelector(".next-cat");
//   const prevBtn = document.querySelector(".prev-cat");

//   // 1. LẤY DỮ LIỆU VÀ RENDER
//   function renderCategories() {
//     const localData = localStorage.getItem("categories");
//     if (!localData) return;

//     const categories = JSON.parse(localData).filter(
//       (cat) => cat.status !== "inactive"
//     );
//     track.innerHTML = "";

//     categories.forEach((cat) => {
//       const catDiv = document.createElement("div");
//       // Gán class inactive nếu status là inactive
//       catDiv.className = "cat-item";
//       // CHỈNH SỬA 2: Sửa lại cấu trúc HTML bên trong để tránh lồng class
//       catDiv.innerHTML = `<span>${cat.name}</span>`;
//       track.appendChild(catDiv);
//     });
//   }

//   renderCategories();

//   // 2. LOGIC TRƯỢT (SLIDE)
//   let index = 0;
//   const items = track.querySelectorAll(".cat-item");
//   const itemWidth = document.querySelector(".cat-item")?.offsetWidth + 20 || 0;
//   const visibleItems = 6;
//   const totalItems = track.children.length;

//   function updateSlide() {
//     const firstItem = track.querySelector(".cat-item");
//     if (!firstItem) return;

//     const itemWidth = firstItem.offsetWidth + 20; // Chiều rộng + gap
//     track.style.transform = `translateX(${-index * itemWidth}px)`;
//     updateButtonState();
//   }

//   function updateButtonState() {
//     const totalItems = track.children.length;
//     // maxIndex là vị trí cuối cùng mà slide có thể trượt tới
//     const maxIndex = totalItems > visibleItems ? totalItems - visibleItems : 0;

//     // Toggle class disabled để highlight nút
//     prevBtn.classList.toggle("disabled", index <= 0);
//     nextBtn.classList.toggle("disabled", index >= maxIndex);

//     // Thêm màu sắc highlight rõ rệt khi nút còn bấm được
//     if (index < maxIndex) {
//       nextBtn.style.backgroundColor = "#000"; // Ví dụ highlight màu đen
//       nextBtn.style.color = "#fff";
//     } else {
//       nextBtn.style.backgroundColor = "#eee";
//       nextBtn.style.color = "#999";
//     }
//   }

//   nextBtn.onclick = () => {
//         const totalItems = track.children.length;
//         const maxIndex = totalItems - visibleItems;

//         if (index < maxIndex) {
//             // Lần đầu click nếu đang ở đầu, nhảy đến 7
//             // Nếu đã qua 7, thì mỗi lần click tiếp theo tiến lên 1 hoặc 6 (tùy bạn chọn)
//             if (index < 7) {
//                 index = 7;
//             } else {
//                 index = Math.min(index + 6, maxIndex); // Trượt thêm một trang 6 cái
//             }
            
//             if (index > maxIndex) index = maxIndex;
//             updateSlide();
//         }
//     };

//     prevBtn.onclick = () => {
//         if (index > 0) {
//             // Trượt lùi 7 cái hoặc về 0
//             index = Math.max(0, index - 7);
//             updateSlide();
//         }
//     };

//     renderCategories();
//     window.addEventListener("resize", updateSlide);
// });
//   nextBtn.onclick = () => {
//     if (index < totalItems - visibleItems) {
//       index += 7;

//       // Giới hạn không cho trượt quá danh mục cuối cùng
//       const maxIndex = track.querySelectorAll(".cat-item").length - 6; // 6 là số item hiển thị trên màn hình
//       if (index > maxIndex) index = maxIndex;

//       track.style.transform = `translateX(${-index * itemWidth}px)`;
//       updateSlide();
//     }
//   };

//   prevBtn.onclick = () => {
//     if (index > 0) {
//       index = index - 6;
//       updateSlide();
//     }
//   };

//   function updateSlide() {
//     track.style.transform = `translateX(${-index * itemWidth}px)`;
//   }
// });