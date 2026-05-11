package com.example.md04ss08bai3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/files")
public class UploadController {
    // định nghĩa tên thư mục lưu trữ trên server
    private static final String UPLOAD_DIR = "uploads";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file){
        try {
            // lấy tên gốc của file
            String fileName = file.getOriginalFilename();
            if(fileName == null || fileName.length() == 0){
                return new ResponseEntity<>("File không hợp lệ", HttpStatus.BAD_REQUEST);
            }

            // check loại file
            String lowercaseFileName = fileName.toLowerCase();
            if(lowercaseFileName.endsWith(".png") || lowercaseFileName.endsWith(".jpg")){
                // chuyển đổi chuỗi "uploads" thành một đối tượng đường dẫn hệ thống
                Path uploadPath = Paths.get(UPLOAD_DIR);

                if(!Files.exists(uploadPath)){
                    // nếu uploadPath chưa tồn tại, code sẽ tự động tạo thư mục này
                    Files.createDirectories(uploadPath);
                }

                // kết hợp đường dẫn thư mục và tên file để tạo đường dẫn đích (VD: uploads/photo.jpg)
                Path filePath = uploadPath.resolve(fileName);

                // thực hiện việc copy dữ liệu từ luồng (Stream) của file được upload vào đường dẫn đích trên server
                // StandardCopyOption.REPLACE_EXISTING :: Nếu trùng tên file, nó sẽ ghi đè lên file cũ
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                return new ResponseEntity<>("Upload thành công: " + fileName, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Chỉ chấp nhận file ảnh có đuổi png/jpg", HttpStatus.BAD_REQUEST);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Lỗi server: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
