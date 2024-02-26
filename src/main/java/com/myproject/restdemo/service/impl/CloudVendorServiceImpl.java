package com.myproject.restdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.restdemo.exception.CloudVendorNotFoundException;
import com.myproject.restdemo.model.CloudVendor;
import com.myproject.restdemo.repository.*;
import com.myproject.restdemo.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
	
	CloudVendorRepository cloudVendorRepository;
	

	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		
		this.cloudVendorRepository = cloudVendorRepository;
	}

	public String createCloudVendor(CloudVendor cloudVendor) {
		//More Business Logic
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}
	
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}
	
	public String deleteCloudVendor(String cloudVendorId) {
		//More Business Logic
		cloudVendorRepository.deleteById(cloudVendorId);
		return "Success";
	}
	
	@Autowired
	
	
	public List<CloudVendor> getAllCloudVendors(){
		//More Business Logic
		return cloudVendorRepository.findAll();
	}

	@Override
	public List<CloudVendor> getByVendorName(String vendorName) {
		// TODO Auto-generated method stub
		return cloudVendorRepository.findByVendorName(vendorName);
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		return cloudVendorRepository.findById(cloudVendorId).get();
	}


}
