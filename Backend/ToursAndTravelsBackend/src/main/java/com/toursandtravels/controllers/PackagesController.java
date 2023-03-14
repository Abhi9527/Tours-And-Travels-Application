package com.toursandtravels.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.toursandtravels.Services.PackageService;
import com.toursandtravels.dto.ApiResponse;
import com.toursandtravels.dto.PackageDto;
import com.toursandtravels.entities.Packages;

@RestController
@RequestMapping("/package")
@CrossOrigin(origins = "http://localhost/3000")
public class PackagesController {

	@Autowired
	private PackageService packagesService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/allpackages")
	public List<Packages> getAllPackages(){
		return packagesService.getAllPackages();
	}
	
	@PostMapping("/addpackages")
	public Packages addPackages(@RequestBody PackageDto packages){
		Packages pack = mapper.map(packages,Packages.class);
		return packagesService.addPackages(pack);
	}
	
	@PutMapping("/updatepackages")
	public Packages updatePackages(@RequestBody PackageDto packages){
		Packages pack = mapper.map(packages,Packages.class);
		return packagesService.updatePackages(pack);
	}
	
	@DeleteMapping("/deletepackage/{packageId}")
	public ApiResponse deletePackage(@PathVariable int packageId) {
		return packagesService.deletePackages(packageId);
	}
	
	
	
	
	
	
	
	
}
