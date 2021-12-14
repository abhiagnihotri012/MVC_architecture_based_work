package com.neosoft.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.springboot.entity.Candidate;
import com.neosoft.springboot.service.CandidateServiceImpl;

@Controller
public class CandidateController {

	@Autowired
	private CandidateServiceImpl candidateServiceImpl;
	
	@GetMapping("/candidates")
	public String listCandidates(Model model) {
		
		model.addAttribute("candidates",candidateServiceImpl.getAllCandidates());
		
		return "candidates";
	}
	
	@GetMapping("/candidates/new")
	public String createCandidateForm(Model model) {
		
		Candidate Candidate = new Candidate();
		model.addAttribute("candidate", Candidate);
		
		return "create_candidate";
	}
	
	@PostMapping("/candidates")
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {
		
		candidateServiceImpl.saveCandidate(candidate);
		
		return "redirect:/candidates";
	}
	
	@GetMapping("/candidates/edit/{id}")
	public String editCandidateForm(@PathVariable Long id, Model model) {
		
		model.addAttribute("candidate",candidateServiceImpl.getCandidateById(id));
		
		return "edit_candidate";
	}
	
	@PostMapping("/candidates/{id}")
	public String updateCandidate(@PathVariable Long id, 
			@ModelAttribute("Candidate") Candidate candidate,	Model model) {
		
		Candidate existingCandidate = candidateServiceImpl.getCandidateById(id);
		existingCandidate.setCid(id);
		existingCandidate.setName(candidate.getName());
		existingCandidate.setAge(candidate.getAge());	
		existingCandidate.setCity(candidate.getCity());	
		existingCandidate.setState(candidate.getState());	
		existingCandidate.setCountry(candidate.getCountry());	
		existingCandidate.setPin(candidate.getPin());	
		candidateServiceImpl.updateCandidate(existingCandidate);
		
		return "redirect:/candidates";
	}
	
	@GetMapping("/candidates/{id}")
	public String deleteCandidate(@PathVariable Long id) {
		
		candidateServiceImpl.deleteCandidateById(id);
		
		return "redirect:/candidates";
	}	
}
