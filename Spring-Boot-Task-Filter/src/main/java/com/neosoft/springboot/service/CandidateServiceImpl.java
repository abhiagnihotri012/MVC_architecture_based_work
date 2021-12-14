package com.neosoft.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.entity.Candidate;
import com.neosoft.springboot.repository.CandidateRepository;
import com.neosoft.springboot.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;	
	
	@Override
	public List<Candidate> getAllCandidates() {
		return candidateRepository.findAll();
	}

	@Override
	public Candidate saveCandidate(Candidate Candidate) {
		return candidateRepository.save(Candidate);
	}

	@Override
	public Candidate getCandidateById(Long id) {
		return candidateRepository.findById(id).get();
	}

	@Override
	public Candidate updateCandidate(Candidate Candidate) {		
		return candidateRepository.save(Candidate);
	}

	@Override
	public void deleteCandidateById(Long id) {
		candidateRepository.deleteById(id);	
	}
}

