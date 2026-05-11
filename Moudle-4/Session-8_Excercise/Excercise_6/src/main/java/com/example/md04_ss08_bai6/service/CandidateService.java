package com.example.md04_ss08_bai6.service;

import com.example.md04_ss08_bai6.entity.Candidate;
import com.example.md04_ss08_bai6.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();

    public CandidateService(){
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Không thể tạo thư mục tải lên", e);
        }
    }

    public String storageFile(MultipartFile file){
        if(file.isEmpty()){
            throw new IllegalArgumentException("File không được để trống");
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.equals("application/pdf")) {
            throw new IllegalArgumentException("Chỉ nhận file PDF");
        }

        try {
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String fileName = UUID.randomUUID() + "." + extension;

            if (extension == null || !extension.equalsIgnoreCase("pdf")) {
                throw new IllegalArgumentException("Chỉ nhận file PDF");
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;

        } catch (IOException e) {
            throw new RuntimeException("Lỗi lưu trữ file", e);
        }
    }

    public Candidate saveCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }
}
