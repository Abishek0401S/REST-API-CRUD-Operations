package com.myproject.restdemo.service;

import java.util.List;

import com.myproject.restdemo.model.CloudVendor;

public interface CloudVendorService {
	
	public String createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String cloudVendorId);
	public CloudVendor getCloudVendor(String cloudVedorId);
	
	public List<CloudVendor> getAllCloudVendors();
	public List<CloudVendor> getByVendorName(String vendorName);
}
