package com.toursandtravels.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toursandtravels.Services.PassengerService;
import com.toursandtravels.dto.PassengerDto;
import com.toursandtravels.entities.Passanger;

@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "http://localhost:3000")
public class PassengerController {
//	@Autowired
//	private DocsAndImagesHandlingService fileService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired 
	private ModelMapper mapper;
	
	
	@GetMapping("/allPassenger")
	public List<Passanger> getAllPassenger(){
		return passengerService.getAllPassenger();
	}
//	
	@PostMapping("/addpassenger/{custId}")
	public ResponseEntity<?> addPassenger(@RequestBody PassengerDto passenger,@PathVariable int custId) {
		
		Passanger passen = mapper.map(passenger, Passanger.class);
		System.out.println(passen);
		return ResponseEntity.ok(passengerService.addPassenger(passen,custId));
//		return null;
	}
	
	@PutMapping("/updatePassenger/{passId}")
	public Passanger updatePassenger(@RequestBody PassengerDto passenger,@PathVariable int passId) {
		
		return passengerService.updatePassenger(passenger,passId);
	}
	
	@DeleteMapping("/deletePassenger/{passId}")
	public ResponseEntity<?> deletePassenger(@PathVariable int passId) {
		return ResponseEntity.ok(passengerService.deletePassenger(passId));
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
