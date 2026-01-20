<<<<<<< HEAD
window.onload = function () {
  const container = document.querySelector(".slider-container");
  const slides = document.querySelectorAll(".hero-item");
  const nextBtn = document.querySelector(".next-btn");
  const prevBtn = document.querySelector(".prev-btn");
  const dots = document.querySelectorAll(".dot");

  let counter = 0;
  const totalSlides = slides.length;

  function updateSlider() {
    container.style.transform = `translateX(${-counter * 100}%)`;

    dots.forEach((dot) => dot.classList.remove("active"));
    if (dots[counter]) {
      dots[counter].classList.add("active");
    }
  }

  nextBtn.addEventListener("click", () => {
    counter++;
    if (counter >= totalSlides) {
      counter = 0; 
    }
    updateSlider();
  });

  prevBtn.addEventListener("click", () => {
    counter--;
    if (counter < 0) {
      counter = totalSlides - 1; 
    }
    updateSlider();
  });

  dots.forEach((dot, index) => {
    dot.addEventListener("click", () => {
      counter = index;
      updateSlider();
    });
  });

  let autoSlide = setInterval(() => {
    nextBtn.click();
  }, 5000);

  const sliderArea = document.querySelector(".hero-slider");
  sliderArea.addEventListener("mouseenter", () => clearInterval(autoSlide));
  sliderArea.addEventListener("mouseleave", () => {
    autoSlide = setInterval(() => {
      nextBtn.click();
    }, 5000);
  });
};
=======
window.onload = function () {
  const container = document.querySelector(".slider-container");
  const slides = document.querySelectorAll(".hero-item");
  const nextBtn = document.querySelector(".next-btn");
  const prevBtn = document.querySelector(".prev-btn");
  const dots = document.querySelectorAll(".dot");

  let counter = 0;
  const totalSlides = slides.length;

  function updateSlider() {
    container.style.transform = `translateX(${-counter * 100}%)`;

    dots.forEach((dot) => dot.classList.remove("active"));
    if (dots[counter]) {
      dots[counter].classList.add("active");
    }
  }

  nextBtn.addEventListener("click", () => {
    counter++;
    if (counter >= totalSlides) {
      counter = 0; 
    }
    updateSlider();
  });

  prevBtn.addEventListener("click", () => {
    counter--;
    if (counter < 0) {
      counter = totalSlides - 1; 
    }
    updateSlider();
  });

  dots.forEach((dot, index) => {
    dot.addEventListener("click", () => {
      counter = index;
      updateSlider();
    });
  });

  let autoSlide = setInterval(() => {
    nextBtn.click();
  }, 5000);

  const sliderArea = document.querySelector(".hero-slider");
  sliderArea.addEventListener("mouseenter", () => clearInterval(autoSlide));
  sliderArea.addEventListener("mouseleave", () => {
    autoSlide = setInterval(() => {
      nextBtn.click();
    }, 5000);
  });
};
>>>>>>> af7eab56334c3ecae8ce3f3e8e96e87d1c474475
