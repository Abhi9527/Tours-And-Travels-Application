package com.toursandtravels.controllers;

import java.util.List;

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

import com.toursandtravels.Services.IterneryService;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.entities.Iternery;

@RestController
@RequestMapping("/iternery")
@CrossOrigin(origins = "http://localhost/3000")
public class IterneryController {

	@Autowired
	private IterneryService iterneryService;
	
	@GetMapping("/alliterneries")
	public List<Iternery>getAllIterneries(){
		return iterneryService.getAllIternery();
	}
	
	@PostMapping("/additerneries")
	public Iternery addIterneries(@RequestBody Iternery iternery){
		return iterneryService.addIternery(iternery);
	}
	
	@PutMapping("/Updateiterneries")
	public Iternery updateiterneries(@RequestBody Iternery iternery){
		return iterneryService.updateIternery(iternery);
	}
	
	@DeleteMapping("/deleteiternery/{iterneryId}")
	public ApiResponse deleteIternery(@PathVariable int iterneryId) {
		return iterneryService.deleteIternery(iterneryId);
	}
	
	
	
	
	
	
	
	
}
