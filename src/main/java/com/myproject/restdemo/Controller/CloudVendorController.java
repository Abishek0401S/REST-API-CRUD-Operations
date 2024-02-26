package com.myproject.restdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.restdemo.model.CloudVendor;
import com.myproject.restdemo.response.ResponseHandler;
import com.myproject.restdemo.service.CloudVendorService;


@RestController
@RequestMapping("/cloudvendor")


public class CloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	@Autowired
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

	@GetMapping("{vendorId}")
	
	public ResponseEntity<Object> getCloudVendorDeatils(@PathVariable("vendorId") String vendorId){
		
		return ResponseHandler.responseBuilder("Requested Vendor Information are given here", 
				HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
	
	}
	
	//Read all CloudVendor Details from the DB
	@GetMapping
	public List<CloudVendor> getAllCloudVendorDetails(){
		return cloudVendorService.getAllCloudVendors();
	}
	
	@PostMapping
	public String createCloudVendorDeatils(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Information created Successfully";
	}
	
	@PutMapping
	public String updateCloudVendorDeatils(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Information updated Successfully";
	}
	
	@DeleteMapping ("{vendorId}")
	public String deleteCloudVendorDeatils(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Information Deleted Successfully";
	}
}
