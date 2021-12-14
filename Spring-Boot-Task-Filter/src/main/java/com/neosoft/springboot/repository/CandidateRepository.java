package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long>{

			
}
