package com.gaviros.tvlix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaviros.tvlix.entity.Opinion;
import com.gaviros.tvlix.service.OpinionsService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("/opinions")
public class OpinionsController {
	
	@Autowired
	private OpinionsService opinionsService;
	
	@GetMapping
	public List <Opinion> getAllOpinions() {
		
		return opinionsService.getAllOpinions();
	}
	
	@PostMapping
	public void postOpinion (@RequestBody @Valid Opinion opinion) {
		
		opinionsService.saveOpinion(opinion);
	}
	
	// Method to probe
	@PutMapping
	public void putOpinion (@RequestBody @Valid Opinion opinion) {
		
		opinionsService.updateOpinion(opinion);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOpinion (@PathVariable (required = true) @Valid Long id) {
		
		opinionsService.deleteOpinion(id);
	}

}
