package com.example.md04_ss08_bai6.repository;

import com.example.md04_ss08_bai6.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
