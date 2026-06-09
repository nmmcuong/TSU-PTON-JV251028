package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String home(Model model,
                       Principal principal,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "size", defaultValue = "5") int size,
                       @RequestParam(value = "keyword", required = false) String keyword) {

    	
        if (principal == null) {
            return "redirect:/login";
        }
        // Tạo cấu trúc phân trang: trang số 'page', mỗi trang 5 phần tử
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursePage;
        
        
        if (keyword != null && !keyword.isEmpty()) {
        	coursePage = courseRepository.findByCourseNameContainingIgnoreCaseOrInstructorContainingIgnoreCase(
                    keyword, keyword, pageable);
        } else {
        	coursePage = courseRepository.findAll(pageable);
            
        }
    
        
        model.addAttribute("coursePage", coursePage);
        //model.addAttribute("courses", coursePage.getContent()); 
        model.addAttribute("currentPage", page);
        //model.addAttribute("courses", courses);
        model.addAttribute("keyword", keyword != null ? keyword : "");
        model.addAttribute("course", new Course());
        return "list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("course", new Course());
        return "list";
    }


	@PostMapping("/save")
	public String saveCourse(@Valid @ModelAttribute("course") Course course,
	                         BindingResult result,
	                         @RequestParam(value = "currentPage", defaultValue = "1") int page,
	                         @RequestParam(value = "keyword", required = false) String keyword,
	                         @RequestParam(value = "file", required = false) MultipartFile file,
	                         Model model,
	                         RedirectAttributes redirectAttributes) throws IOException {
	
		
	    if (result.hasErrors()) {
	    	model.addAttribute("courses", courseRepository.findAll());
	    	model.addAttribute("hasError", true);
	    	Pageable pageable = PageRequest.of(0, 5); 
	        model.addAttribute("coursePage", courseRepository.findAll(pageable));
	    	return "list";
	    }
	
	    if (file != null && !file.isEmpty()) {
	        Path uploadDir = Paths.get(uploadPath).toAbsolutePath().normalize();
	        Files.createDirectories(uploadDir);
	
	        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
	        Path savePath = uploadDir.resolve(filename);
	
	        file.transferTo(savePath.toFile());
	
	        course.setThumbnail("/uploads/" + filename);
	
	        System.out.println("Tên file ảnh đã upload: " + filename);
	        System.out.println("Thư mục upload: " + uploadDir);
	        System.out.println("Đường dẫn file lưu trên máy: " + savePath);
	        System.out.println("File tồn tại sau khi lưu? " + Files.exists(savePath));
	        System.out.println("Đường dẫn hiển thị ảnh: " + course.getThumbnail());
	
	    } else if (course.getId() != null) {
	        Course existingCourse = courseRepository.findById(course.getId())
	                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khóa học"));
	        course.setThumbnail(existingCourse.getThumbnail());
	    }
	
	    courseRepository.save(course);
	    String message = (course.getId() == null) ? "Thêm mới thành công!" : "Cập nhật thành công!";
	    redirectAttributes.addFlashAttribute("successMessage", message);
	    String url = "redirect:/?page=" + page;
	    if (keyword != null && !keyword.isEmpty()) {
	        url += "&keyword=" + keyword;
	    }
	    
	    return url;
	    //return "redirect:/?page=" + page;
	}


	@GetMapping("/edit/{id}")
	public String editCourse(@PathVariable("id") Long id, Model model) {
	    // 1. Tìm khóa học trong DB
	    Course course = courseRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khóa học"));
	    
	    // 2. Đẩy dữ liệu vào model
	    model.addAttribute("course", course);
	    model.addAttribute("modalTitle", "Cập nhật khóa học");
	    
	    // 3. Bạn cần logic để tự động mở Modal khi trang tải xong
	    model.addAttribute("openModal", true); 
	    
	    // 4. Trả về trang danh sách (list)
	    return "list"; 
	}

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
    		@RequestParam(value = "page", defaultValue = "0") int page,
    		@RequestParam(value = "keyword", required = false) String keyword,
    		RedirectAttributes redirectAttributes) {
    	
    	// Lấy keyword trực tiếp từ URL
        //String keyword = request.getParameter("keyword");    	System.out.println("--- TOÀN BỘ PARAMETERS ---");
        
        System.out.println("Keyword cuối cùng nhận được: " + keyword);
    	System.out.println("DEBUG: Keyword nhận được tại hàm delete là: [" + keyword + "]");
        courseRepository.deleteById(id);
        
     // xem trang hiện tại còn dữ liệu không
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Course> currentPageData;
        
        if (keyword != null && !keyword.isEmpty()) {
            currentPageData = courseRepository.findByCourseNameContainingIgnoreCaseOrInstructorContainingIgnoreCase(keyword, keyword, pageable);
        } else {
            currentPageData = courseRepository.findAll(pageable);
        }
        
        //  Nếu trang hiện tại trống và không phải trang 0, lùi về 1 trang
        if (currentPageData.isEmpty() && page > 0) {
            page = page - 1;
        }
        
        //  Redirect về, giữ nguyên keyword và page
        String redirectUrl = "redirect:/?page=" + page + "&size=" + pageSize;
        if (keyword != null && !keyword.isEmpty()) {
        	redirectAttributes.addAttribute("keyword", keyword);
        }
        System.out.println(redirectUrl);
        System.out.println(keyword);
        return redirectUrl;
    }
}