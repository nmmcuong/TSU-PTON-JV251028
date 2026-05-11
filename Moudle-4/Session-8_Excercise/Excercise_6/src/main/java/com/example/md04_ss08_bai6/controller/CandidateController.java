package com.example.md04_ss08_bai6.controller;

import com.example.md04_ss08_bai6.dto.CandidateDTO;
import com.example.md04_ss08_bai6.entity.Candidate;
import com.example.md04_ss08_bai6.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("apply")
    public ResponseEntity<?> addCandidate(
            @RequestPart("data") @Valid CandidateDTO candidateDTO,
            @RequestPart("file") MultipartFile file
            ){

        String cv_url = candidateService.storageFile(file);

        Candidate candidate = new Candidate();
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setFullName(candidateDTO.getFullName());
        candidate.setSkills(candidateDTO.getSkills());
        candidate.setCv_url(cv_url);

        return ResponseEntity.ok().body(candidateService.saveCandidate(candidate));
    }
}
