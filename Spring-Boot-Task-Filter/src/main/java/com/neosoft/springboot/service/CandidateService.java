package com.neosoft.springboot.service;

import java.util.List;

import com.neosoft.springboot.entity.Candidate;

public interface CandidateService {

	List<Candidate> getAllCandidates();
	
	Candidate saveCandidate(Candidate candidate);
	
	Candidate getCandidateById(Long id);
	
	Candidate updateCandidate(Candidate candidate);
	
	void deleteCandidateById(Long id);
}
